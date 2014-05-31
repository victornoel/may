package fr.irit.smac.may.speadl.ui.outline;

import com.google.inject.Inject;
import fr.irit.smac.may.speadl.speadl.Ecosystem;
import fr.irit.smac.may.speadl.speadl.Model;
import fr.irit.smac.may.speadl.speadl.Namespace;
import fr.irit.smac.may.speadl.speadl.Part;
import fr.irit.smac.may.speadl.speadl.Port;
import fr.irit.smac.may.speadl.speadl.SpeadlPackage;
import fr.irit.smac.may.speadl.speadl.Species;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.ui.editor.outline.IOutlineNode;
import org.eclipse.xtext.ui.editor.outline.impl.DefaultOutlineTreeProvider;
import org.eclipse.xtext.ui.editor.outline.impl.DocumentRootNode;
import org.eclipse.xtext.ui.editor.outline.impl.OutlineNodeFactory;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xbase.ui.labeling.XbaseImages2;
import org.eclipse.xtext.xtype.XImportDeclaration;
import org.eclipse.xtext.xtype.XImportSection;
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
    boolean _and = false;
    XImportSection _imports = modelElement.getImports();
    boolean _tripleNotEquals = (_imports != null);
    if (!_tripleNotEquals) {
      _and = false;
    } else {
      XImportSection _imports_1 = modelElement.getImports();
      EList<XImportDeclaration> _importDeclarations = _imports_1.getImportDeclarations();
      boolean _isEmpty = _importDeclarations.isEmpty();
      boolean _not = (!_isEmpty);
      _and = _not;
    }
    if (_and) {
      XImportSection _imports_2 = modelElement.getImports();
      ImageDescriptor _forImportContainer = this.images.forImportContainer();
      this.factory.createEStructuralFeatureNode(parentNode, _imports_2, 
        XtypePackage.Literals.XIMPORT_SECTION__IMPORT_DECLARATIONS, _forImportContainer, 
        "import declarations", false);
    }
    EList<Namespace> _elements = modelElement.getElements();
    final Procedure1<Namespace> _function = new Procedure1<Namespace>() {
      public void apply(final Namespace e) {
        SpeADLOutlineTreeProvider.this.createNode(parentNode, e);
      }
    };
    IterableExtensions.<Namespace>forEach(_elements, _function);
  }
  
  public void _createChildren(final IOutlineNode parentNode, final Ecosystem modelElement) {
    EList<EObject> _eContents = modelElement.eContents();
    final Function1<EObject, Boolean> _function = new Function1<EObject, Boolean>() {
      public Boolean apply(final EObject e) {
        boolean _or = false;
        EClass _contentElement = SpeadlPackage.eINSTANCE.getContentElement();
        EClass _eClass = e.eClass();
        boolean _isAssignableFrom = EcoreUtil2.isAssignableFrom(_contentElement, _eClass);
        if (_isAssignableFrom) {
          _or = true;
        } else {
          EClass _species = SpeadlPackage.eINSTANCE.getSpecies();
          EClass _eClass_1 = e.eClass();
          boolean _isAssignableFrom_1 = EcoreUtil2.isAssignableFrom(_species, _eClass_1);
          _or = _isAssignableFrom_1;
        }
        return Boolean.valueOf(_or);
      }
    };
    Iterable<EObject> _filter = IterableExtensions.<EObject>filter(_eContents, _function);
    final Procedure1<EObject> _function_1 = new Procedure1<EObject>() {
      public void apply(final EObject e) {
        SpeADLOutlineTreeProvider.this.createNode(parentNode, e);
      }
    };
    IterableExtensions.<EObject>forEach(_filter, _function_1);
  }
  
  public void _createChildren(final IOutlineNode parentNode, final Species modelElement) {
    EList<EObject> _eContents = modelElement.eContents();
    final Function1<EObject, Boolean> _function = new Function1<EObject, Boolean>() {
      public Boolean apply(final EObject e) {
        EClass _contentElement = SpeadlPackage.eINSTANCE.getContentElement();
        EClass _eClass = e.eClass();
        return Boolean.valueOf(EcoreUtil2.isAssignableFrom(_contentElement, _eClass));
      }
    };
    Iterable<EObject> _filter = IterableExtensions.<EObject>filter(_eContents, _function);
    final Procedure1<EObject> _function_1 = new Procedure1<EObject>() {
      public void apply(final EObject e) {
        SpeADLOutlineTreeProvider.this.createNode(parentNode, e);
      }
    };
    IterableExtensions.<EObject>forEach(_filter, _function_1);
  }
  
  public boolean _isLeaf(final Port p) {
    return true;
  }
  
  public boolean _isLeaf(final Part p) {
    return true;
  }
}
