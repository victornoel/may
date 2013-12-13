package fr.irit.smac.may.speadl.ui.labeling;

import org.eclipse.jdt.internal.ui.JavaPluginImages;
import org.eclipse.jdt.ui.JavaElementImageDescriptor;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.xtext.common.types.JvmVisibility;
import org.eclipse.xtext.xbase.ui.labeling.XbaseImages2;

public class SpeADLImages extends XbaseImages2 {

	public ImageDescriptor forPackage() {
		return JavaPluginImages.DESC_OBJS_PACKDECL;
	}
	
	public ImageDescriptor forSpecies() {
		return forClass(JvmVisibility.PUBLIC, JavaElementImageDescriptor.STATIC);
	}
	
	public ImageDescriptor forEcosystem() {
		return forClass(JvmVisibility.PUBLIC, 0);
	}

}
