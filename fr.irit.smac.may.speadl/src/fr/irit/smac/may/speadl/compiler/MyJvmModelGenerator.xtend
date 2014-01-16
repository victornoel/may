package fr.irit.smac.may.speadl.compiler

import com.google.inject.Inject
import fr.irit.smac.may.speadl.SpeADLUtils
import org.eclipse.xtext.common.types.JvmDeclaredType
import org.eclipse.xtext.generator.IFileSystemAccess
import org.eclipse.xtext.validation.CheckType
import org.eclipse.xtext.xbase.compiler.JvmModelGenerator

class MyJvmModelGenerator extends JvmModelGenerator {
	
	@Inject extension SpeADLUtils
	
	override dispatch internalDoGenerate(JvmDeclaredType type, IFileSystemAccess fsa) {
		// TODO check for errors there using ErrorSafeExtensions.getErrors for example (need recursion...)
		// see also SpeADLBuilderParticipant where checking of errors is disabled
		// only Ecosystem are generated
		// do not prevent generation when the error is on implementedBy!
		val eco = type.associatedEcosystem
		if (!eco.modelElementHasError(false, [it.type == CheckType.NORMAL], true)) {
			super._internalDoGenerate(type, fsa)
		}
	}
}
