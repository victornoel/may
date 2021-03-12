package fr.irit.smac.may.speadl.ui.outline;

import com.google.inject.Inject;
import fr.irit.smac.may.speadl.speadl.Ecosystem;
import fr.irit.smac.may.speadl.speadl.Model;
import fr.irit.smac.may.speadl.speadl.Namespace;
import fr.irit.smac.may.speadl.speadl.Part;
import fr.irit.smac.may.speadl.speadl.Port;
import fr.irit.smac.may.speadl.speadl.SpeadlPackage;
import fr.irit.smac.may.speadl.speadl.Species;
import java.util.function.Consumer;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.ui.editor.outline.IOutlineNode;
import org.eclipse.xtext.ui.editor.outline.impl.DefaultOutlineTreeProvider;
import org.eclipse.xtext.ui.editor.outline.impl.DocumentRootNode;
import org.eclipse.xtext.ui.editor.outline.impl.OutlineNodeFactory;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.ui.labeling.XbaseImages2;
import org.eclipse.xtext.xtype.XtypePackage;

/**
 * Customization of the default outline structure.
 * 
 * see http://www.eclipse.org/Xtext/documentation.html#outline
 */
@SuppressWarnings("all")
public class SpeADLOutlineTreeProvider extends DefaultOutlineTreeProvider {
  @Inject
  private XbaseImages2 images;
  
  @Inject
  private OutlineNodeFactory factory;
  
  public void _createChildren(final DocumentRootNode parentNode, final Model modelElement) {
    if (((modelElement.getImports() != null) && (!modelElement.getImports().getImportDeclarations().isEmpty()))) {
      this.factory.createEStructuralFeatureNode(parentNode, modelElement.getImports(), 
        XtypePackage.Literals.XIMPORT_SECTION__IMPORT_DECLARATIONS, this.images.forImportContainer(), 
        "import declarations", false);
    }
    final Consumer<Namespace> _function = (Namespace e) -> {
      this.createNode(parentNode, e);
    };
    modelElement.getElements().forEach(_function);
  }
  
  public void _createChildren(final IOutlineNode parentNode, final Ecosystem modelElement) {
    final Function1<EObject, Boolean> _function = (EObject e) -> {
      return Boolean.valueOf((EcoreUtil2.isAssignableFrom(SpeadlPackage.eINSTANCE.getContentElement(), e.eClass()) || EcoreUtil2.isAssignableFrom(SpeadlPackage.eINSTANCE.getSpecies(), e.eClass())));
    };
    final Consumer<EObject> _function_1 = (EObject e) -> {
      this.createNode(parentNode, e);
    };
    IterableExtensions.<EObject>filter(modelElement.eContents(), _function).forEach(_function_1);
  }
  
  public void _createChildren(final IOutlineNode parentNode, final Species modelElement) {
    final Function1<EObject, Boolean> _function = (EObject e) -> {
      return Boolean.valueOf(EcoreUtil2.isAssignableFrom(SpeadlPackage.eINSTANCE.getContentElement(), e.eClass()));
    };
    final Consumer<EObject> _function_1 = (EObject e) -> {
      this.createNode(parentNode, e);
    };
    IterableExtensions.<EObject>filter(modelElement.eContents(), _function).forEach(_function_1);
  }
  
  public boolean _isLeaf(final Port p) {
    return true;
  }
  
  public boolean _isLeaf(final Part p) {
    return true;
  }
}
