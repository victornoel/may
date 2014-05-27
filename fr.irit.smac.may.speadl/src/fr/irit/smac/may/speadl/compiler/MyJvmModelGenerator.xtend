package fr.irit.smac.may.speadl.compiler

import com.google.inject.Inject
import fr.irit.smac.may.speadl.SpeADLUtils
import org.eclipse.emf.ecore.EObject
import org.eclipse.xtext.common.types.JvmDeclaredType
import org.eclipse.xtext.diagnostics.Severity
import org.eclipse.xtext.generator.IFileSystemAccess
import org.eclipse.xtext.xbase.compiler.IElementIssueProvider
import org.eclipse.xtext.xbase.compiler.JvmModelGenerator

class MyJvmModelGenerator extends JvmModelGenerator {
	
	@Inject extension SpeADLUtils
	@Inject IElementIssueProvider.Factory issueProviderFactory
	
	override dispatch internalDoGenerate(JvmDeclaredType type, IFileSystemAccess fsa) {
		// see also SpeADLBuilderParticipant where checking of errors is disabled
		// Note: only Ecosystem are generated
		val eco = type.associatedEcosystem
		if (eco != null && !eco.modelElementHasError) {
			super._internalDoGenerate(type, fsa)
		}
	}
	
	private def boolean modelElementHasError(EObject e) {
		val issueProvider = issueProviderFactory.get(e.eResource)
		issueProvider.getIssues(e).exists[severity == Severity.ERROR]
			|| e.eContents.exists[modelElementHasError]
	}
}
