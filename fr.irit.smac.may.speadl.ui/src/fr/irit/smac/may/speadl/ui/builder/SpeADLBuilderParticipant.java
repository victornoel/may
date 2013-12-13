package fr.irit.smac.may.speadl.ui.builder;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.builder.BuilderParticipant;

public class SpeADLBuilderParticipant extends BuilderParticipant {

	@Override
	protected boolean shouldGenerate(Resource resource, IBuildContext context) {
		// TODO allow generation even when there is error
		// see MyJvmModelGenerator which disable generation for elements with errors
		return super.shouldGenerate(resource, context);
		//return true;
	}
	
}
