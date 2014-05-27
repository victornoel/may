package fr.irit.smac.may.speadl.scoping;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.impl.ImportNormalizer;
import org.eclipse.xtext.xbase.scoping.XImportSectionNamespaceScopeProvider;

import com.google.common.collect.Lists;
import com.google.inject.Inject;

public class SpeADLImportSectionNamespaceScopeProvider extends XImportSectionNamespaceScopeProvider {
	
	@Inject private SpeADLDeclarativeScopeProvider myScopeProvider;
	
	@Override
	public IScope getScope(EObject context, EReference reference) {
		IScope scope = null;
		
		if(scope == null && reference.getEContainingClass() != null) {
			// the second test prevent the declarative scope to be called
			// on an incomplete reference... (because we use them in fr.irit.smac.may.juno.spead.ui.contentassist.SpeADLProposalProvider)
			scope = myScopeProvider.getScope(context, reference);
		}
		
		if(scope == null){
			scope = super.getScope(context, reference);
		}
		return scope;
	}
	
	@Override
	protected List<ImportNormalizer> getImplicitImports(boolean ignoreCase) {
		// only import java lang by default
		return Lists.newArrayList(new ImportNormalizer(JAVA_LANG, true, false));
	}
}
