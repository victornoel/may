/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package fr.irit.smac.may.speadl.ui.builder;

import java.util.Collection;
import java.util.Set;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.emf.common.util.URI;
import org.eclipse.xtext.builder.JDTAwareEclipseResourceFileSystemAccess2;
import org.eclipse.xtext.generator.OutputConfiguration;
import org.eclipse.xtext.util.RuntimeIOException;

import com.google.common.collect.Multimap;

/**
 * @author Sven Efftinge - Initial contribution and API
 * @author Holger Schill
 * 
 * Copied from xtend (in order to avoid it to be a dependency)
 * Used in SpeADLBuilderParticipant
 */
public class SourceRelativeFileSystemAccess extends JDTAwareEclipseResourceFileSystemAccess2 {

	private IFolder currentSource = null;

	public void setCurrentSource(IFolder currentSource) {
		this.currentSource = currentSource;
	}

	@Override
	protected boolean ensureOutputConfigurationDirectoryExists(OutputConfiguration outputConfig) {
		IContainer container = getContainer(outputConfig);
		if (container.exists()) {
			// Add as source folder even if the directory already exists
			try {
				createContainer(container);
				return true;
			} catch (CoreException e) {
				throw new RuntimeIOException(e);
			}
		}
		return super.ensureOutputConfigurationDirectoryExists(outputConfig);
	}

	@Override
	protected IContainer getContainer(OutputConfiguration outputConfig) {
		if (currentSource != null) {
			String directory = outputConfig.getOutputDirectory();
			IPath path = currentSource.getFullPath().append("../" + directory);
			IFolder folder = currentSource.getWorkspace().getRoot().getFolder(path);
			return folder;
		}
		return super.getContainer(outputConfig);
	}

	/**
	 * Since sourceTraces are relative the URI has to be computed with the currentSource as context
	 */
	@Override
	public void flushSourceTraces(String generatorName) throws CoreException {
		Multimap<URI, IPath> sourceTraces = getSourceTraces();
		if (sourceTraces != null) {
			Set<URI> keys = sourceTraces.keySet();
			for (URI uri : keys) {
				if (uri != null && currentSource != null) {
					Collection<IPath> paths = sourceTraces.get(uri);
					IFile sourceFile = currentSource.getFile(uri.toFileString());
					if (sourceFile.exists()) {
						IPath[] tracePathArray = paths.toArray(new IPath[paths.size()]);
						getTraceMarkers().installMarker(sourceFile, generatorName, tracePathArray);
					}
				}
			}
		}
		resetSourceTraces();
	}

}
