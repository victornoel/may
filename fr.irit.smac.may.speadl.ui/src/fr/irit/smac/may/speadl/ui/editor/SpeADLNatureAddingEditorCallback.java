package fr.irit.smac.may.speadl.ui.editor;


import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IStorage;
import org.eclipse.emf.common.util.URI;
import org.eclipse.xtext.builder.nature.ToggleXtextNatureAction;
import org.eclipse.xtext.ui.editor.AbstractDirtyStateAwareEditorCallback;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.eclipse.xtext.ui.resource.IStorage2UriMapper;
import org.eclipse.xtext.ui.resource.UriValidator;

import com.google.inject.Inject;

/**
 * Copied from org.eclipse.xtend.ide.editor.XtendNatureAddingEditorCallback
 *
 */
public class SpeADLNatureAddingEditorCallback extends AbstractDirtyStateAwareEditorCallback {

	@Inject
	private IStorage2UriMapper mapper;
	
	@Inject
	private UriValidator uriValidator;
	
	@Inject
	private ToggleXtextNatureAction toggleNature;

	// so that the xtext nature is added when opening a speadl file
	
	@Override
	public void afterCreatePartControl(XtextEditor editor) {
		super.afterCreatePartControl(editor);
		IResource resource = editor.getResource();
		if (resource!=null && !toggleNature.hasNature(resource.getProject()) 
				&& resource.getProject().isAccessible() && !resource.getProject().isHidden() && canBuild(editor)) {
			toggleNature.toggleNature(resource.getProject());
		}
	}
	
	private boolean canBuild(XtextEditor editor) {
		IResource resource = editor.getResource();
		if (!(resource instanceof IStorage)) {
			return false;
		}
		IStorage storage = (IStorage) resource;
		URI uri = mapper.getUri(storage);
		return uriValidator.canBuild(uri, storage);
	}
}