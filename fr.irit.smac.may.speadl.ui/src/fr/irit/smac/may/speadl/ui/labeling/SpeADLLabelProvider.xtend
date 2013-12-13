package fr.irit.smac.may.speadl.ui.labeling

import com.google.inject.Inject
import fr.irit.smac.may.speadl.speadl.ComponentPart
import fr.irit.smac.may.speadl.speadl.Ecosystem
import fr.irit.smac.may.speadl.speadl.Namespace
import fr.irit.smac.may.speadl.speadl.Part
import fr.irit.smac.may.speadl.speadl.Port
import fr.irit.smac.may.speadl.speadl.ProvidedPort
import fr.irit.smac.may.speadl.speadl.RequiredPort
import fr.irit.smac.may.speadl.speadl.Species
import fr.irit.smac.may.speadl.speadl.SpeciesPart
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider
import org.eclipse.xtext.common.types.JvmVisibility
import org.eclipse.xtext.xbase.ui.labeling.XbaseLabelProvider

/**
 * Provides labels for a EObjects.
 * 
 * see http://www.eclipse.org/Xtext/documentation.html#labelProvider
 */
class SpeADLLabelProvider extends XbaseLabelProvider {

	@Inject SpeADLImages images

	@Inject
	new(AdapterFactoryLabelProvider delegate) {
		super(delegate);
	}

	def image(Namespace ns) {
		images.forPackage
	}
	
	def image(Ecosystem e) {
		images.forEcosystem
	}
	
	def image(Species e) {
		images.forSpecies
	}
	
	def image(ProvidedPort p) {
		images.forOperation(JvmVisibility.PUBLIC, 0)
	}
	
	def image(RequiredPort p) {
		images.forOperation(JvmVisibility.PROTECTED, 0)
	}
	
	def image(Part p) {
		images.forField(JvmVisibility.PROTECTED, 0)
	}

	def text(Port p) {
		p.name + ": " + p.typeReference.simpleName
	}
	
	def text(ComponentPart p) {
		p.name + ": " + p.componentReference.type.simpleName
	}
	
	def text(SpeciesPart p) {
		p.name + ": " p.speciesReference.part.name + "." + p.speciesReference.species.name
	}
}
