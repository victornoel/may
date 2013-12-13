package fr.irit.smac.may.speadl.compiler

import org.eclipse.xtext.common.types.JvmDeclaredType
import org.eclipse.xtext.generator.IFileSystemAccess
import org.eclipse.xtext.xbase.compiler.JvmModelGenerator

class MyJvmModelGenerator extends JvmModelGenerator {
	
	//@Inject extension SpeADLUtils
	
	//@Inject extension ErrorSafeExtensions
	
	//@Inject extension IJvmModelAssociations
	
	//@Inject IElementIssueProvider.Factory issueProviderFactory
	
	override dispatch internalDoGenerate(JvmDeclaredType type, IFileSystemAccess fsa) {
		// TODO check for errors there using ErrorSafeExtensions.getErrors for example (need recursion...)
		// see also SpeADLBuilderParticipant where checking of errors is disabled
		// only Ecosystem are generated
		super._internalDoGenerate(type, fsa)
	}
	
	// TODO change the default output folder!!!
}
