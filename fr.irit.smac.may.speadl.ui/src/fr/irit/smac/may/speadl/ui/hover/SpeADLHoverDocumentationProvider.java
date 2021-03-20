package fr.irit.smac.may.speadl.ui.hover;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.xbase.ui.hover.XbaseHoverDocumentationProvider;

public class SpeADLHoverDocumentationProvider extends XbaseHoverDocumentationProvider {
	/**
	 * Remove any extra information about the derived java elements
	 */
	@Override
	public String getDerivedOrOriginalDeclarationInformation(EObject object) {
		return "";
	}
	
}
