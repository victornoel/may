package fr.irit.smac.may.speadl.ui.hover;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.xbase.ui.hover.XbaseHoverDocumentationProvider;

public class SpeADLHoverDocumentationProvider extends XbaseHoverDocumentationProvider {

	@Override
	public String getDerivedOrOriginalDeclarationInformation(EObject object) {
		return "";
	}
	
}
