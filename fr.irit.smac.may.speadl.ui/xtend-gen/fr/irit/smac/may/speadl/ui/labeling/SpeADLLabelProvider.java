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
import fr.irit.smac.may.speadl.ui.labeling.SpeADLImages;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.resource.ImageDescriptor;
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
    String _simpleName = p.getTypeReference().getSimpleName();
    return (_plus + _simpleName);
  }
  
  public String text(final ComponentPart p) {
    String _name = p.getName();
    String _plus = (_name + ": ");
    String _simpleName = p.getComponentReference().getType().getSimpleName();
    return (_plus + _simpleName);
  }
  
  public String text(final SpeciesPart p) {
    String _xblockexpression = null;
    {
      String _name = p.getName();
      /* (_name + ": "); */
      String _name_1 = p.getSpeciesReference().getPart().getName();
      String _plus = (_name_1 + ".");
      String _name_2 = p.getSpeciesReference().getSpecies().getName();
      _xblockexpression = (_plus + _name_2);
    }
    return _xblockexpression;
  }
}
