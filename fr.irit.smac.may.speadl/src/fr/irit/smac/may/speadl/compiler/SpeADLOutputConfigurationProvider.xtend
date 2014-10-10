package fr.irit.smac.may.speadl.compiler

import org.eclipse.xtext.generator.IFileSystemAccess
import org.eclipse.xtext.generator.OutputConfiguration
import org.eclipse.xtext.generator.OutputConfigurationProvider

class SpeADLOutputConfigurationProvider extends OutputConfigurationProvider {
	
	// taken fron XtendOutputConfigurationProvider
	override getOutputConfigurations() {
		#{
			new OutputConfiguration(IFileSystemAccess.DEFAULT_OUTPUT) => [
				description = "Output folder for generated Java files"
				outputDirectory = "speadl-gen"
				overrideExistingResources = true
				createOutputDirectory = true
				canClearOutputDirectory = false
				cleanUpDerivedResources = true
				keepLocalHistory = false
				setDerivedProperty = true
			]
		}
	}
	
}