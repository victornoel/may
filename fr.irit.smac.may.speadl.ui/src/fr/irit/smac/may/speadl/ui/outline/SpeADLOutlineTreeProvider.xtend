package fr.irit.smac.may.speadl.ui.outline

import com.google.inject.Inject
import fr.irit.smac.may.speadl.speadl.Ecosystem
import fr.irit.smac.may.speadl.speadl.Model
import fr.irit.smac.may.speadl.speadl.Part
import fr.irit.smac.may.speadl.speadl.Port
import fr.irit.smac.may.speadl.speadl.SpeadlPackage
import fr.irit.smac.may.speadl.speadl.Species
import org.eclipse.xtext.EcoreUtil2
import org.eclipse.xtext.ui.editor.outline.IOutlineNode
import org.eclipse.xtext.ui.editor.outline.impl.DefaultOutlineTreeProvider
import org.eclipse.xtext.ui.editor.outline.impl.DocumentRootNode
import org.eclipse.xtext.ui.editor.outline.impl.OutlineNodeFactory
import org.eclipse.xtext.xbase.ui.labeling.XbaseImages2
import org.eclipse.xtext.xtype.XtypePackage

/**
 * Customization of the default outline structure.
 *
 * see http://www.eclipse.org/Xtext/documentation.html#outline
 */
// TODO support multiple mode (see ModeAwareOutlineTreeProvider) for with and without inherited ports
class SpeADLOutlineTreeProvider extends DefaultOutlineTreeProvider {
	
	@Inject XbaseImages2 images
	
	@Inject OutlineNodeFactory factory
	
	def _createChildren(DocumentRootNode parentNode, Model modelElement) {
		// TODO add import
		if (modelElement.imports != null && !modelElement.imports.importDeclarations.empty) {
				factory.createEStructuralFeatureNode(parentNode, modelElement.imports,
						XtypePackage.Literals.XIMPORT_SECTION__IMPORT_DECLARATIONS, images.forImportContainer(),
						"import declarations", false)
		}
		modelElement.elements.forEach[e|
			createNode(parentNode,e)
		]
	}
	
	def _createChildren(IOutlineNode parentNode, Ecosystem modelElement) {
		modelElement.eContents.filter[e|
			EcoreUtil2.isAssignableFrom(SpeadlPackage.eINSTANCE.contentElement, e.eClass)
			|| EcoreUtil2.isAssignableFrom(SpeadlPackage.eINSTANCE.species, e.eClass)
		].forEach[e|
			createNode(parentNode, e);
		]
	}
	
	def _createChildren(IOutlineNode parentNode, Species modelElement) {
		modelElement.eContents.filter[e|
			EcoreUtil2.isAssignableFrom(SpeadlPackage.eINSTANCE.contentElement, e.eClass)
		].forEach[e|
			createNode(parentNode, e);
		]
	}
	
	def _isLeaf(Port p) {
		true
	}
	
	def _isLeaf(Part p) {
		true
	}
}
