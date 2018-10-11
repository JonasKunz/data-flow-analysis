package edu.kit.ipd.sdq.dataflow.systemmodel

import edu.kit.ipd.sdq.dataflow.systemmodel.typing.AssignmentTypeRestrictionsCollector
import edu.kit.ipd.sdq.dataflow.systemmodel.typing.TypeRestrictions
import java.util.ArrayList
import java.util.Collections
import java.util.HashMap
import java.util.List
import java.util.stream.Collectors
import org.eclipse.emf.ecore.util.EcoreUtil
import java.util.Collection
import edu.kit.ipd.sdq.dataflow.systemmodel.typing.AttributeRestriction
import java.util.Optional

class AssignmentsTranslator {
	
	
	val TranslationCache bb;
	val AssignmentTypeRestrictionsCollector restrictionsCollector;
	val LogicTermTranslator logicTermTranslator;
	val Configuration config;
	/**
	 * cache variable for the type restrictions, is used across different methods.
	 */
	val typeRestrictions = new HashMap<VariableAssignment, TypeRestrictions>();
	
	/**
	 * Only used when the "shorter assignments" optimization is enabled.
	 * This counter is used for generating a unique assignment id.
	 */
	var assignmentIdCounter = 1;
	
	new(TranslationCache bb, Configuration config) {
		this.bb = bb;
		this.config = config;
		restrictionsCollector = new AssignmentTypeRestrictionsCollector(bb);
		logicTermTranslator = new LogicTermTranslator(bb, config);
	}
	
	def void buildAssignments(List<VariableAssignment> assignments, AssignmentContext assiContext, PrologProgram sink) {
		typeRestrictions.clear();
		for(a : assignments) {
			typeRestrictions.put(a, restrictionsCollector.collect(a));
		}
		var reversedAssignments = new ArrayList<VariableAssignment>(assignments);
		Collections.reverse(reversedAssignments);
		if(config.shorterAssignments) {
			generateShortenedAssignments(reversedAssignments, assiContext, sink);
		} else {
			generateStandardAssignments(reversedAssignments, assiContext, sink);			
		}
	}
	
	protected def void generateShortenedAssignments(List<VariableAssignment> reversedAssignments, AssignmentContext assiContext, PrologProgram sink) {
		val assignmentId = assignmentIdCounter;
		assignmentIdCounter++;
		
		//generate a indirection to our assignment rule set
		
		val LogicTermContext ltContext = new LogicTermContext;
		generateStackInfoForLogicTermContext(assiContext, true, ltContext);
		val allVars = reversedAssignments.stream().map([assi | assi.variable]).collect(Collectors.toSet());
		
		val adaptedContext = assiContext.copy();
		adaptedContext.predicate = [S,VAR,A,VAL | '''assignment_«assignmentId»(«S»,'«VAR.name»',«A»,«VAL»)'''];
		
		for(vari : allVars) {
			sink.addRule(assiContext.predicate.getPredicate(ltContext.currentStack,vari,"A","V"),
				adaptedContext.predicate.getPredicate(ltContext.currentStack,vari,"A","V"));
			if(config.optimizedNegations) {
				sink.addRule("not_"+assiContext.predicate.getPredicate(ltContext.currentStack,vari,"A","V"),
				"not_" + adaptedContext.predicate.getPredicate(ltContext.currentStack,vari,"A","V"));
			}
		}
		
		val generateAssignment = [VariableAssignment assi, boolean negated | 
			val restrictions = typeRestrictions.get(assi);
			
			val value = getValueVariable(assi.value, restrictions);
			var attribute = getAttributeVariable(assi.attribute, restrictions);
			
			var Optional<Collection<AttributeRestriction>> preconditions;			
			if(assi.isAttributeWildcard) {
				preconditions = Optional.of(restrictions.attributeRestrictions);
			} else {
				preconditions = Optional.of(Collections.emptyList());
			}
			writeAssignmentRule(adaptedContext,restrictions.isStackReferenced,negated,preconditions,attribute,value, assi,sink);
		];
		
		for(assi : reversedAssignments) {
			generateAssignment.apply(assi,false);			
		}
		if(config.optimizedNegations) {
			for(assi : reversedAssignments) {
				generateAssignment.apply(assi,true);			
			}
		}
	}
	
	private def quote(String str) {
		return "'" + str + "'";
	}
	
	protected def void generateStandardAssignments(List<VariableAssignment> reversedAssignments, AssignmentContext assiContext, PrologProgram sink) {
		var allVariables = reversedAssignments.stream().map([a | a.variable]).distinct().collect(Collectors.toSet);
		
		for(vari : allVariables) {
			for(attrib : vari.datatype.attributes) {
				for(value : attrib.type.values) {
					var wasAssigned = false;
					for(assi : reversedAssignments) {
						if(!wasAssigned && assi.variable === vari) {
							
							var tr = typeRestrictions.get(assi);
							
							val valueMatch = assi.value === null || assi.value === value;
							val attributeMatch = (assi.attribute === attrib || assi.attribute === null)
												&& tr.doesAttributeMatchRestrictions(bb, attrib);
							
							if(valueMatch && attributeMatch) {
								wasAssigned = true;
								writeAssignmentRule(assiContext, tr.isStackReferenced,false, Optional.empty(), attrib.name.quote(), value.name.quote(), assi, sink)
								if(config.optimizedNegations) {
									writeAssignmentRule(assiContext, tr.isStackReferenced,true, Optional.empty(), attrib.name.quote() , value.name.quote(), assi, sink)			
								}
							}
						}
					}
				}
			}
		}
	}
	
	private def generateStackInfoForLogicTermContext(AssignmentContext assiContext, boolean isStackReferenced, LogicTermContext ltContext) {
		var String stackVariable;
		if(isStackReferenced) {
			stackVariable= "S";
		} else {
			stackVariable= "_";					
		}
		ltContext.currentStack = '''['«assiContext.getCurrentOperation.name»'|«stackVariable»]''';
		
		if(assiContext.previousCall.isPresent) {
			val call = assiContext.previousCall.get();
			ltContext.stateAccessPredicate = StateAccessMode.POSTCALL;
			ltContext.stateAccessStack = '''['«call.callee.name»','«call.name»','«call.caller.name»'|«stackVariable»]''';
		} else {
			ltContext.stateAccessPredicate = StateAccessMode.PRECALL;
			ltContext.stateAccessStack = ltContext.currentStack;	
		}
	}
	
	private def getValueVariable(Value value, TypeRestrictions typeRestrictions) {
		if(value !== null) {
			return "'" + value.name + "'";
		} else {
			if(!typeRestrictions.valueWildCardReferenced) {
				return "_";				
			} else {
				return "V";
			}
		}
	}
	
	private def getAttributeVariable(Attribute attrib, TypeRestrictions typeRestrictions) {
		if(attrib !== null) {
			return "'" + attrib.name + "'";
		} else {
			if(typeRestrictions.attributeRestrictions.isEmpty() && !typeRestrictions.attributeWildCardReferenced) {
				return "_";
			} else {
				return "A";
			}
		}
	}	
	
	private def void writeAssignmentRule(AssignmentContext assiContext, boolean isStackReferenced, boolean negated, Optional<Collection<AttributeRestriction>> preconditions, String attrib, String value, VariableAssignment assi, PrologProgram sink) {
		
		val LogicTermContext ltContext = new LogicTermContext;
		generateStackInfoForLogicTermContext(assiContext, isStackReferenced, ltContext);
		
		
		ltContext.valueWildCardInstatiation = value;
		ltContext.attributeWildCardInstatiation = attrib;
		
		var preconditionsPrefix = "";
		if(preconditions.isPresent) {
			for(precond : preconditions.get()) {
				preconditionsPrefix += precond.getPredicateForRestriction(attrib) + ",";
			}
			preconditionsPrefix = preconditionsPrefix + "!,";
		}
		
		var String pred = assiContext.predicate.getPredicate(ltContext.currentStack,assi.variable,attrib,value);
		
		
		if(negated) {
			pred = "not_"+pred;
			val negatedTerm = SystemModelFactory.eINSTANCE.createNot();
			negatedTerm.operand = EcoreUtil.copy(assi.term);
			val term = logicTermTranslator.translate(negatedTerm, ltContext);
			sink.addRule(pred, preconditionsPrefix + term);									
		} else {
			var String term = logicTermTranslator.translate(assi.term, ltContext);
			sink.addRule(pred, preconditionsPrefix + term);			
		}
	}
	
}