package fr.irit.smac.may.speadl.ui.contentassist

import fr.irit.smac.may.speadl.speadl.ComponentPart
import fr.irit.smac.may.speadl.speadl.Ecosystem
import fr.irit.smac.may.speadl.speadl.SpeadlPackage
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.EcoreFactory
import org.eclipse.xtext.Assignment
import org.eclipse.xtext.CrossReference
import org.eclipse.xtext.ui.editor.contentassist.ContentAssistContext
import org.eclipse.xtext.ui.editor.contentassist.ICompletionProposalAcceptor

/**
 * see http://www.eclipse.org/Xtext/documentation.html#contentAssist on how to customize content assistant
 */
class SpeADLProposalProvider extends AbstractSpeADLProposalProvider {
	
	// propose the component instead of the jvm class for the specialize and for the component part
	override void completeJvmParameterizedTypeReference_Type(EObject model, Assignment assignment, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		// if there was multiple JvmParameterizedTypeReference in these Rules,
		// we would be screwed because it is not possible to know the feature to which
		// the type ref is attributed...
		if(model instanceof Ecosystem || model instanceof ComponentPart) {
			val eref = EcoreFactory.eINSTANCE.createEReference()
			eref.setEType(SpeadlPackage.Literals.ECOSYSTEM)
			// this works because the qualified name of the Component is the same as the one of the generated element!
			// TODO it doesn't work when completing an already typed thing (like finishing the type ref)
			// it will proposes anyway all possibilities, but as soon as one starts to type with the completion thing
			// already open, it will work as desired…
			lookupCrossReference(assignment.getTerminal() as CrossReference, eref, context, acceptor, getFeatureDescriptionPredicate(context))
		} else {
			super.completeJvmParameterizedTypeReference_Type(model, assignment, context, acceptor)
		}
	}
}
