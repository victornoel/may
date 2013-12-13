package fr.irit.smac.may.speadl.validation;

import org.eclipse.xtext.util.Strings;
import org.eclipse.xtext.validation.AbstractDeclarativeValidator;
import org.eclipse.xtext.validation.Check;
import org.eclipse.xtext.validation.EValidatorRegistrar;

import fr.irit.smac.may.speadl.speadl.SpeadlPackage;
import fr.irit.smac.may.speadl.speadl.Species;

/**
 * This class contains validation copied from stuffs from xtend or xtext
 *
 */
public class SpeADLXtendXtextInspiredValidator extends AbstractDeclarativeValidator {
	
	@Override
	public void register(EValidatorRegistrar registrar) {
		// this prevents the validator to be registered and executed automatically
		// it is only activated as part of the ComposedChecks of the SpeADLValidator
	}
		
	/**
	 * Inspired from org.eclipse.xtend.core.validation.XtendJavaValidator
	 * 
	 */
	@Check
	public void checkParameterNames(Species species) {
		for (int i = 0; i < species.getParameters().size(); ++i) {
			String leftParameterName = species.getParameters().get(i).getName();
			for (int j = i + 1; j < species.getParameters().size(); ++j) {
				if (Strings.equal(leftParameterName, species.getParameters().get(j).getName())) {
					error("Duplicate parameter " + leftParameterName, SpeadlPackage.Literals.ABSTRACT_COMPONENT__PARAMETERS, i);
					error("Duplicate parameter " + leftParameterName, SpeadlPackage.Literals.ABSTRACT_COMPONENT__PARAMETERS, j);
				}
			}
		}
	}
	
}
