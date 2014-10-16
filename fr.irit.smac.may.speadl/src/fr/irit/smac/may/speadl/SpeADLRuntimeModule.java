/*
 * generated by Xtext
 */
package fr.irit.smac.may.speadl;

import org.eclipse.xtext.generator.IGenerator;
import org.eclipse.xtext.generator.IOutputConfigurationProvider;
import org.eclipse.xtext.naming.IQualifiedNameProvider;
import org.eclipse.xtext.scoping.IScopeProvider;
import org.eclipse.xtext.scoping.impl.AbstractDeclarativeScopeProvider;
import org.eclipse.xtext.service.SingletonBinding;
import org.eclipse.xtext.validation.INamesAreUniqueValidationHelper;
import org.eclipse.xtext.xbase.validation.JvmTypeReferencesValidator;

import com.google.inject.Binder;
import com.google.inject.name.Names;

import fr.irit.smac.may.speadl.compiler.MyJvmModelGenerator;
import fr.irit.smac.may.speadl.compiler.SpeADLOutputConfigurationProvider;
import fr.irit.smac.may.speadl.scoping.SpeADLImportSectionNamespaceScopeProvider;
import fr.irit.smac.may.speadl.scoping.SpeADLQualifiedNameProvider;
import fr.irit.smac.may.speadl.validation.MyNamesAreUniqueValidationHelper;
import fr.irit.smac.may.speadl.validation.SpeADLJvmTypeReferenceValidator;

/**
 * Use this class to register components to be used at runtime / without the Equinox extension registry.
 */
public class SpeADLRuntimeModule extends AbstractSpeADLRuntimeModule {

	@Override
	public void configureIScopeProviderDelegate(Binder binder) {
		binder.bind(IScopeProvider.class).annotatedWith(Names.named(AbstractDeclarativeScopeProvider.NAMED_DELEGATE)).to(SpeADLImportSectionNamespaceScopeProvider.class);
	}
	
	@Override
	public Class<? extends IQualifiedNameProvider> bindIQualifiedNameProvider() {
		return SpeADLQualifiedNameProvider.class;
	}
	
	@Override
	@SingletonBinding(eager=true)
	public Class<? extends JvmTypeReferencesValidator> bindJvmTypeReferencesValidator() {
		return SpeADLJvmTypeReferenceValidator.class;
	}
	
	@Override
	public Class<? extends IGenerator> bindIGenerator() {
		return MyJvmModelGenerator.class;
	}
	
	public Class<? extends INamesAreUniqueValidationHelper> bindINamesAreUniqueValidationHelper() {
		return MyNamesAreUniqueValidationHelper.class;
	}
	
	public Class<? extends IOutputConfigurationProvider> bindIOutputConfigurationProvider() {
		return SpeADLOutputConfigurationProvider.class;
	}
	
	
}
