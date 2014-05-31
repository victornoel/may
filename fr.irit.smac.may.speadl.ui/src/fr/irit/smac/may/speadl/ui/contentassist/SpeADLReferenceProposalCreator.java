package fr.irit.smac.may.speadl.ui.contentassist;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.jface.text.contentassist.ICompletionProposal;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.ui.editor.contentassist.ConfigurableCompletionProposal;
import org.eclipse.xtext.xbase.ui.contentassist.XbaseReferenceProposalCreator;

import com.google.common.base.Function;

import fr.irit.smac.may.speadl.speadl.SpeadlPackage;

/**
 * @see http://www.eclipse.org/forums/index.php/m/1017108/
 *
 */
public class SpeADLReferenceProposalCreator extends XbaseReferenceProposalCreator {
	
	// so that a '.' is automatically added after auto-completing the part of in PortRef
	// and the part of SpeciesReference
	
	@Override
	protected Function<IEObjectDescription, ICompletionProposal> getWrappedFactory(EObject model, EReference reference, 
			final Function<IEObjectDescription, ICompletionProposal> proposalFactory) {
		
		if(reference.equals(SpeadlPackage.Literals.PORT_REF__PART)
			|| reference.equals(SpeadlPackage.Literals.SPECIES_REFERENCE__PART)) {
			return new Function<IEObjectDescription, ICompletionProposal>() {
				public ICompletionProposal apply(IEObjectDescription from) {
					ConfigurableCompletionProposal result = (ConfigurableCompletionProposal) proposalFactory.apply(from);
					
					if (result != null) {
						result.setReplacementString(result.getReplacementString() + ".");
						result.setCursorPosition(result.getCursorPosition()+1);
					}
					return result;
				}
			};
		}
		
		return super.getWrappedFactory(model, reference, proposalFactory);
	}
	
}