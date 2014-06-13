package fr.irit.smac.may.speadl.validation;

import org.eclipse.xtext.common.types.util.TypeReferences;
import org.eclipse.xtext.validation.Check;
import org.eclipse.xtext.validation.EValidatorRegistrar;
import org.eclipse.xtext.xbase.validation.IssueCodes;
import org.eclipse.xtext.xbase.validation.JvmTypeReferencesValidator;

import com.google.inject.Inject;

import fr.irit.smac.may.speadl.speadl.Feature;

public class SpeADLJvmTypeReferenceValidator extends JvmTypeReferencesValidator {
	
	@Inject
	private TypeReferences typeReferences;
	
	@Override
	public void register(EValidatorRegistrar registrar) {
		// this prevents the validator to be registered and executed automatically
		// it is only activated as part of the ComposedChecks of the SpeADLValidator
	}
		
	@Check
	public void checkFeatureNotPrimitiveVoid(Feature param) {
		if (typeReferences.is(param.getParameterType(), Void.TYPE)) {
			error("The primitive 'void' cannot be the type of a parameter", param.getParameterType(), null, IssueCodes.INVALID_USE_OF_TYPE);
		}
	}
}
