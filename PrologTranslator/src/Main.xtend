import edu.kit.ipd.sdq.dataflow.systemmodel.System
import edu.kit.ipd.sdq.dataflow.systemmodel.SystemModelPackage
import edu.kit.ipd.sdq.dataflow.systemmodel.SystemTranslator
import java.nio.file.Files
import java.nio.file.Paths
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl
import edu.kit.ipd.sdq.dataflow.systemmodel.Configuration
import org.eclipse.ocl.pivot.utilities.PivotStandaloneSetup
import org.eclipse.ocl.xtext.completeocl.CompleteOCLStandaloneSetup

class Main {
	
	def static System loadSystem(String filePath) {
		PivotStandaloneSetup.doSetup();
		CompleteOCLStandaloneSetup.doSetup();
		SystemModelPackage.eINSTANCE.eClass();
        val reg = Resource.Factory.Registry.INSTANCE;
      	reg.getExtensionToFactoryMap().put("*", new XMIResourceFactoryImpl());
      	
        val resSet = new ResourceSetImpl();
        val resource = resSet.getResource(URI.createURI("file://" + filePath), true);
        
        return resource.getContents().get(0) as System;
	}
	
	def static void main(String[] args) {
		
		val config = new Configuration();
		
		if(args.length < 2 || args.length > 3) {
			println("Usage: [modelfile] [outputfile] [optional:prolog-to-append]");
			return;
		}
        val sys = loadSystem(args.get(0));
        val SystemTranslator st = new SystemTranslator(config);
        
		val result = st.translate(sys);
		
		val output = newArrayList(result.code);
		if(args.length == 3) {
			val additionalRules = Files.readAllLines(Paths.get(args.get(2)));
			output.addAll(additionalRules);
		}
		Files.write(Paths.get(args.get(1)), output);
		
		
	}
	
	
}