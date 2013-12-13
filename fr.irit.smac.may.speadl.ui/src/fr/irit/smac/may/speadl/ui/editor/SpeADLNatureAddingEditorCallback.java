package fr.irit.smac.may.speadl.ui.editor;

import org.eclipse.core.resources.IResource;
import org.eclipse.xtext.builder.nature.ToggleXtextNatureAction;
import org.eclipse.xtext.ui.editor.AbstractDirtyStateAwareEditorCallback;
import org.eclipse.xtext.ui.editor.XtextEditor;

import com.google.inject.Inject;

/**
 * Copied from org.eclipse.xtend.ide.editor.XtendNatureAddingEditorCallback
 *
 */
public class SpeADLNatureAddingEditorCallback extends AbstractDirtyStateAwareEditorCallback {

	@Inject
	private ToggleXtextNatureAction toggleNature;

	@Override
	public void afterCreatePartControl(XtextEditor editor) {
		super.afterCreatePartControl(editor);
		IResource resource = editor.getResource();
		if (resource!=null && !toggleNature.hasNature(resource.getProject()) && resource.getProject().isAccessible() && !resource.getProject().isHidden()) {
			toggleNature.toggleNature(resource.getProject());
		}
	}
}