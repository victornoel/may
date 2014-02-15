package fr.irit.smac.may.speadl.ui.labeling;

import com.google.inject.Inject;
import fr.irit.smac.may.speadl.speadl.ComponentPart;
import fr.irit.smac.may.speadl.speadl.Ecosystem;
import fr.irit.smac.may.speadl.speadl.Namespace;
import fr.irit.smac.may.speadl.speadl.Part;
import fr.irit.smac.may.speadl.speadl.Port;
import fr.irit.smac.may.speadl.speadl.ProvidedPort;
import fr.irit.smac.may.speadl.speadl.RequiredPort;
import fr.irit.smac.may.speadl.speadl.Species;
import fr.irit.smac.may.speadl.speadl.SpeciesPart;
import fr.irit.smac.may.speadl.speadl.SpeciesReference;
import fr.irit.smac.may.speadl.ui.labeling.SpeADLImages;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.xtext.common.types.JvmParameterizedTypeReference;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmVisibility;
import org.eclipse.xtext.xbase.ui.labeling.XbaseLabelProvider;

/**
 * Provides labels for a EObjects.
 * 
 * see http://www.eclipse.org/Xtext/documentation.html#labelProvider
 */
@SuppressWarnings("all")
public class SpeADLLabelProvider extends XbaseLabelProvider {
  @Inject
  private SpeADLImages images;
  
  @Inject
  public SpeADLLabelProvider(final AdapterFactoryLabelProvider delegate) {
    super(delegate);
  }
  
  public ImageDescriptor image(final Namespace ns) {
    return this.images.forPackage();
  }
  
  public ImageDescriptor image(final Ecosystem e) {
    return this.images.forEcosystem();
  }
  
  public ImageDescriptor image(final Species e) {
    return this.images.forSpecies();
  }
  
  public ImageDescriptor image(final ProvidedPort p) {
    return this.images.forOperation(JvmVisibility.PUBLIC, 0);
  }
  
  public ImageDescriptor image(final RequiredPort p) {
    return this.images.forOperation(JvmVisibility.PROTECTED, 0);
  }
  
  public ImageDescriptor image(final Part p) {
    return this.images.forField(JvmVisibility.PROTECTED, 0);
  }
  
  public String text(final Port p) {
    String _name = p.getName();
    String _plus = (_name + ": ");
    JvmParameterizedTypeReference _typeReference = p.getTypeReference();
    String _simpleName = _typeReference.getSimpleName();
    return (_plus + _simpleName);
  }
  
  public String text(final ComponentPart p) {
    String _name = p.getName();
    String _plus = (_name + ": ");
    JvmParameterizedTypeReference _componentReference = p.getComponentReference();
    JvmType _type = _componentReference.getType();
    String _simpleName = _type.getSimpleName();
    return (_plus + _simpleName);
  }
  
  public String text(final SpeciesPart p) {
    String _xblockexpression = null;
    {
      String _name = p.getName();
      /* (_name + ": "); */
      SpeciesReference _speciesReference = p.getSpeciesReference();
      ComponentPart _part = _speciesReference.getPart();
      String _name_1 = _part.getName();
      String _plus = (_name_1 + ".");
      SpeciesReference _speciesReference_1 = p.getSpeciesReference();
      Species _species = _speciesReference_1.getSpecies();
      String _name_2 = _species.getName();
      _xblockexpression = (_plus + _name_2);
    }
    return _xblockexpression;
  }
}
