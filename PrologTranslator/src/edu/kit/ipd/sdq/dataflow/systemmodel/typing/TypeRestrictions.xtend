package edu.kit.ipd.sdq.dataflow.systemmodel.typing

import org.eclipse.xtend.lib.annotations.Accessors
import java.util.Set
import java.util.HashSet
import edu.kit.ipd.sdq.dataflow.systemmodel.Attribute
import edu.kit.ipd.sdq.dataflow.systemmodel.TranslationCache

class TypeRestrictions {
	
	public static val NO_RESTRICTIONS = new TypeRestrictions();
	
	/**
	 * Specifies whether any term references the current stack-list.
	 * This required to prevent warnings about unused Variables in the Prolog Code.
	 */
	@Accessors
	boolean isStackReferenced = false;
	
	/**
	 * Specifies, whether the value of the "Value-Wildcard" is used on the right side of the assignment.
	 */
	@Accessors
	boolean valueWildCardReferenced = false;
	
	/**
	 * Specifies, whether the value of the "Attribute-Wildcard" is used on the right side of the assignment.
	 */
	@Accessors
	boolean attributeWildCardReferenced = false;
	
	@Accessors(PUBLIC_GETTER,NONE)
	Set<AttributeRestriction> attributeRestrictions = new HashSet<AttributeRestriction>();
	
	def void addAttributeRestriction(AttributeRestriction restriction) {
		attributeRestrictions.add(restriction);
	}
	
	def boolean doesAttributeMatchRestrictions(TranslationCache bb, Attribute attrib) {
		for(res : attributeRestrictions) {
			if(!res.doesAttributeMatch(bb, attrib)) {
				return false;
			}
		}
		return true;
	}
	
	def duplicate() {
		//BeanUtils.cloneBean not applicable as we want a deep copy for the sets
		val copy = new TypeRestrictions();
		copy.isStackReferenced = this.isStackReferenced;
		copy.attributeWildCardReferenced = this.attributeWildCardReferenced;
		copy.valueWildCardReferenced = this.valueWildCardReferenced;
		copy.attributeRestrictions.addAll(this.attributeRestrictions);
		return copy;
	}
	
	/**
	 * Combines this isntance with another one, resulting in a TypeRestrictions instance which represents both restrictiosn combined.
	 */
	def getMerged(TypeRestrictions other) {
		val copy = new TypeRestrictions();
		copy.isStackReferenced = this.isStackReferenced || other.isStackReferenced;
		copy.attributeWildCardReferenced = this.attributeWildCardReferenced || other.attributeWildCardReferenced;
		copy.valueWildCardReferenced = this.valueWildCardReferenced || other.valueWildCardReferenced;
		copy.attributeRestrictions.addAll(this.attributeRestrictions);
		copy.attributeRestrictions.addAll(other.attributeRestrictions);
		return copy;
	}
	
	
}
