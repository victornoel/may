/*
 * generated by Xtext
 */
package fr.irit.smac.may.speadl.ui;

import org.eclipse.xtext.ui.guice.AbstractGuiceAwareExecutableExtensionFactory;
import org.osgi.framework.Bundle;

import com.google.inject.Injector;

import fr.irit.smac.may.speadl.ui.internal.SpeADLActivator;

/**
 * This class was generated. Customizations should only happen in a newly
 * introduced subclass. 
 */
public class SpeADLExecutableExtensionFactory extends AbstractGuiceAwareExecutableExtensionFactory {

	@Override
	protected Bundle getBundle() {
		return SpeADLActivator.getInstance().getBundle();
	}
	
	@Override
	protected Injector getInjector() {
		return SpeADLActivator.getInstance().getInjector(SpeADLActivator.FR_IRIT_SMAC_MAY_SPEADL_SPEADL);
	}
	
}
