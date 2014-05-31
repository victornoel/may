package fr.irit.smac.may.speadl.ui.contentassist;

import com.google.common.base.Predicate;
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
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.ui.editor.contentassist.ContentAssistContext;
import org.eclipse.xtext.ui.editor.contentassist.ICompletionProposalAcceptor;

/**
 * see http://www.eclipse.org/Xtext/documentation.html#contentAssist on how to customize content assistant
 */
@SuppressWarnings("all")
public class SpeADLProposalProvider extends AbstractSpeADLProposalProvider {
  public void completeJvmParameterizedTypeReference_Type(final EObject model, final Assignment assignment, final ContentAssistContext context, final ICompletionProposalAcceptor acceptor) {
    boolean _or = false;
    if ((model instanceof Ecosystem)) {
      _or = true;
    } else {
      _or = (model instanceof ComponentPart);
    }
    if (_or) {
      final EReference eref = EcoreFactory.eINSTANCE.createEReference();
      eref.setEType(SpeadlPackage.Literals.ECOSYSTEM);
      AbstractElement _terminal = assignment.getTerminal();
      Predicate<IEObjectDescription> _featureDescriptionPredicate = this.getFeatureDescriptionPredicate(context);
      this.lookupCrossReference(((CrossReference) _terminal), eref, context, acceptor, _featureDescriptionPredicate);
    } else {
      super.completeJvmParameterizedTypeReference_Type(model, assignment, context, acceptor);
    }
  }
}
