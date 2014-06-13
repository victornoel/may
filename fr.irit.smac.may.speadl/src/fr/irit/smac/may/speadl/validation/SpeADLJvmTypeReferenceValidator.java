package fr.irit.smac.may.speadl.validation;

import org.eclipse.xtext.common.types.JvmGenericType;
import org.eclipse.xtext.common.types.JvmParameterizedTypeReference;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.util.TypeReferences;
import org.eclipse.xtext.validation.Check;
import org.eclipse.xtext.validation.EValidatorRegistrar;
import org.eclipse.xtext.xbase.validation.IssueCodes;
import org.eclipse.xtext.xbase.validation.JvmTypeReferencesValidator;
import org.eclipse.xtext.xbase.validation.ProxyAwareUIStrings;

import com.google.inject.Inject;

import fr.irit.smac.may.speadl.speadl.Feature;

public class SpeADLJvmTypeReferenceValidator extends JvmTypeReferencesValidator {
	
	@Inject
	private TypeReferences typeReferences;

	@Inject
	private ProxyAwareUIStrings proxyAwareUIStrings;
	
	@Override
	public void register(EValidatorRegistrar registrar) {
		// this prevents the validator to be registered and executed automatically
		// it is only activated as part of the ComposedChecks of the SpeADLValidator
	}
	
	@Check
	@Override // to always have an error even when there is no arguments
	public void checkTypeArgsAgainstTypeParameters(JvmParameterizedTypeReference typeRef) {
		JvmType type = typeRef.getType();
		if(type instanceof JvmGenericType && !type.eIsProxy()) {
			int numTypeParameters = ((JvmGenericType) type).getTypeParameters().size();
			if (numTypeParameters == 0) {
				errorTypeIsNotGeneric(type, typeRef);
			} else if (numTypeParameters != typeRef.getArguments().size()) {
				StringBuilder message = new StringBuilder(64);
				message.append("Incorrect number of arguments for type ");
				message = proxyAwareUIStrings.appendTypeSignature(type, message);
				message.append("; it cannot be parameterized with arguments ");
				message = proxyAwareUIStrings.appendTypeArguments(typeRef, message);
				if (message != null) {
					error(message.toString(),
							IssueCodes.INVALID_NUMBER_OF_TYPE_ARGUMENTS, typeRef);
				}
			}
		} else if (type != null && !type.eIsProxy() && !typeRef.getArguments().isEmpty()) {
			errorTypeIsNotGeneric(type, typeRef);
		}
	}
	
	@Check
	public void checkFeatureNotPrimitiveVoid(Feature param) {
		if (typeReferences.is(param.getParameterType(), Void.TYPE)) {
			error("The primitive 'void' cannot be the type of a parameter", param.getParameterType(), null, IssueCodes.INVALID_USE_OF_TYPE);
		}
	}
}
