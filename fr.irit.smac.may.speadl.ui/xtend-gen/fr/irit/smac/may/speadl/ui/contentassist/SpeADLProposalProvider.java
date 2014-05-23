package fr.irit.smac.may.speadl.ui.contentassist;

import com.google.common.base.Function;
import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import fr.irit.smac.may.speadl.speadl.ComponentPart;
import fr.irit.smac.may.speadl.speadl.Ecosystem;
import fr.irit.smac.may.speadl.speadl.SpeadlPackage;
import fr.irit.smac.may.speadl.ui.contentassist.AbstractSpeADLProposalProvider;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.jface.text.contentassist.ICompletionProposal;
import org.eclipse.xtext.Assignment;
import org.eclipse.xtext.common.types.TypesPackage;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.ui.editor.contentassist.ContentAssistContext;
import org.eclipse.xtext.ui.editor.contentassist.ICompletionProposalAcceptor;
import org.eclipse.xtext.xbase.ui.contentassist.XbaseReferenceProposalCreator;

/**
 * see http://www.eclipse.org/Xtext/documentation.html#contentAssist on how to customize content assistant
 */
@SuppressWarnings("all")
public class SpeADLProposalProvider extends AbstractSpeADLProposalProvider {
  public void completeJvmParameterizedTypeReference_Type(final EObject model, final Assignment assignment, final ContentAssistContext context, final ICompletionProposalAcceptor acceptor) {
    boolean _or = false;
    XbaseReferenceProposalCreator _xbaseCrossReferenceProposalCreator = this.getXbaseCrossReferenceProposalCreator();
    boolean _isShowTypeProposals = _xbaseCrossReferenceProposalCreator.isShowTypeProposals();
    if (_isShowTypeProposals) {
      _or = true;
    } else {
      XbaseReferenceProposalCreator _xbaseCrossReferenceProposalCreator_1 = this.getXbaseCrossReferenceProposalCreator();
      boolean _isShowSmartProposals = _xbaseCrossReferenceProposalCreator_1.isShowSmartProposals();
      _or = _isShowSmartProposals;
    }
    if (_or) {
      boolean _or_1 = false;
      if ((model instanceof Ecosystem)) {
        _or_1 = true;
      } else {
        _or_1 = (model instanceof ComponentPart);
      }
      if (_or_1) {
        final EReference eref = EcoreFactory.eINSTANCE.createEReference();
        eref.setEType(SpeadlPackage.Literals.ECOSYSTEM);
        Predicate<IEObjectDescription> _alwaysTrue = Predicates.<IEObjectDescription>alwaysTrue();
        Function<IEObjectDescription, ICompletionProposal> _proposalFactory = this.getProposalFactory("QualifiedName", context);
        this.lookupCrossReference(model, eref, acceptor, _alwaysTrue, _proposalFactory);
      } else {
        this.completeJavaTypes(context, TypesPackage.Literals.JVM_PARAMETERIZED_TYPE_REFERENCE__TYPE, acceptor);
      }
    }
  }
}
