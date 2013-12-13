package fr.irit.smac.may.speadl.ui.contentassist

import com.google.common.base.Predicates
import fr.irit.smac.may.speadl.speadl.ComponentPart
import fr.irit.smac.may.speadl.speadl.Ecosystem
import fr.irit.smac.may.speadl.speadl.SpeadlPackage
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.EcoreFactory
import org.eclipse.xtext.Assignment
import org.eclipse.xtext.common.types.TypesPackage
import org.eclipse.xtext.resource.IEObjectDescription
import org.eclipse.xtext.ui.editor.contentassist.ContentAssistContext
import org.eclipse.xtext.ui.editor.contentassist.ICompletionProposalAcceptor

/**
 * see http://www.eclipse.org/Xtext/documentation.html#contentAssist on how to customize content assistant
 */
class SpeADLProposalProvider extends AbstractSpeADLProposalProvider {
	
	// avoid the problem with the redefinition of the JvmParameteriwedTypeReference rule
	// where content assist wouldn't work anymore
	override void completeJvmParameterizedTypeReference_Type(EObject model, Assignment assignment, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		if (getXbaseCrossReferenceProposalCreator().isShowTypeProposals() || getXbaseCrossReferenceProposalCreator().isShowSmartProposals()) {
			if(model instanceof Ecosystem || model instanceof ComponentPart) {
				val eref = EcoreFactory.eINSTANCE.createEReference()
				eref.setEType(SpeadlPackage.Literals.ECOSYSTEM)
				// this works because the qualified name of the Component is the same as the one of the generated element!
				lookupCrossReference(model, eref, acceptor, Predicates.<IEObjectDescription> alwaysTrue(), getProposalFactory("QualifiedName", context));
			} else {
				completeJavaTypes(context, TypesPackage.Literals.JVM_PARAMETERIZED_TYPE_REFERENCE__TYPE, acceptor);
			}
		}
	}
}
