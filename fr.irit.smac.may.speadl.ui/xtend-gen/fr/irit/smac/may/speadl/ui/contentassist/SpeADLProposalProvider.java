package fr.irit.smac.may.speadl.ui.contentassist;

import fr.irit.smac.may.speadl.speadl.ComponentPart;
import fr.irit.smac.may.speadl.speadl.Ecosystem;
import fr.irit.smac.may.speadl.speadl.SpeadlPackage;
import fr.irit.smac.may.speadl.ui.contentassist.AbstractSpeADLProposalProvider;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.Assignment;
import org.eclipse.xtext.CrossReference;
import org.eclipse.xtext.common.types.TypesPackage;
import org.eclipse.xtext.ui.editor.contentassist.ContentAssistContext;
import org.eclipse.xtext.ui.editor.contentassist.ICompletionProposalAcceptor;

/**
 * see http://www.eclipse.org/Xtext/documentation.html#contentAssist on how to customize content assistant
 */
@SuppressWarnings("all")
public class SpeADLProposalProvider extends AbstractSpeADLProposalProvider {
  @Override
  public void completeJvmParameterizedTypeReference_Type(final EObject model, final Assignment assignment, final ContentAssistContext context, final ICompletionProposalAcceptor acceptor) {
    if (((model instanceof Ecosystem) || (model instanceof ComponentPart))) {
      final EReference eref = EcoreFactory.eINSTANCE.createEReference();
      eref.setEType(SpeadlPackage.Literals.ECOSYSTEM);
      AbstractElement _terminal = assignment.getTerminal();
      this.lookupCrossReference(((CrossReference) _terminal), eref, context, acceptor, this.getFeatureDescriptionPredicate(context));
    } else {
      if ((this.getXbaseCrossReferenceProposalCreator().isShowTypeProposals() || this.getXbaseCrossReferenceProposalCreator().isShowSmartProposals())) {
        this.completeJavaTypes(context, TypesPackage.Literals.JVM_PARAMETERIZED_TYPE_REFERENCE__TYPE, acceptor);
      }
    }
  }
}
