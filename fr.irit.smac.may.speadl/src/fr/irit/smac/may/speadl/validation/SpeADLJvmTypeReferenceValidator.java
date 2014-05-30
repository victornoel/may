package fr.irit.smac.may.speadl.validation;

import org.eclipse.xtext.common.types.JvmGenericType;
import org.eclipse.xtext.common.types.JvmParameterizedTypeReference;
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
	@Override // to always have an error even when there is no arguments
	public void checkTypeArgsAgainstTypeParameters(JvmParameterizedTypeReference typeRef) {
		if(typeRef.getType() instanceof JvmGenericType) {
			int numTypeParameters = ((JvmGenericType) typeRef.getType()).getTypeParameters().size();
			if(numTypeParameters != typeRef.getArguments().size()) 
				error("Incorrect number of arguments for type " 
						+ getTypeSignature(typeRef.getType()) 
						+ "; it cannot be parameterized with arguments " 
						+ getTypeArguments(typeRef),
					IssueCodes.INVALID_NUMBER_OF_TYPE_ARGUMENTS, typeRef);
		}
	}
	
	@Check
	public void checkFeatureNotPrimitiveVoid(Feature param) {
		if (typeReferences.is(param.getParameterType(), Void.TYPE)) {
			error("The primitive 'void' cannot be the type of a parameter", param.getParameterType(), null, IssueCodes.INVALID_USE_OF_TYPE);
		}
	}
}
