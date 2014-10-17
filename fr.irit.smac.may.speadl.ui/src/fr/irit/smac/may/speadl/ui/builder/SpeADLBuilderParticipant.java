package fr.irit.smac.may.speadl.ui.builder;

import static com.google.common.collect.Maps.newHashMap;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IStorage;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.IPackageFragmentRoot;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jdt.internal.core.JavaProject;
import org.eclipse.xtext.builder.BuilderParticipant;
import org.eclipse.xtext.builder.EclipseResourceFileSystemAccess2;
import org.eclipse.xtext.generator.OutputConfiguration;
import org.eclipse.xtext.resource.IResourceDescription.Delta;
import org.eclipse.xtext.ui.resource.IStorage2UriMapper;
import org.eclipse.xtext.util.Pair;
import org.eclipse.xtext.xbase.compiler.ElementIssueProvider;

import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.inject.Inject;

/**
 * copied from XtendBuilderParticipant to attach the element issue provider
 * (see MyJvmModelGenerator for the use of this data)
 * and not listen to the shouldGenerate method
 */
public class SpeADLBuilderParticipant extends BuilderParticipant {

	private static Logger LOGGER = Logger.getLogger(SpeADLBuilderParticipant.class);

	@Inject
	private IStorage2UriMapper mapper;

	@Inject
	private ElementIssueProvider.Factory elementIssueProviderFactory;

	@Override
	protected void handleChangedContents(Delta delta, IBuildContext context,
			EclipseResourceFileSystemAccess2 fileSystemAccess) throws CoreException {
		if (!getResourceServiceProvider().canHandle(delta.getUri()))
			return;
		final Resource resource = context.getResourceSet().getResource(delta.getUri(), true);
		final IFile file = getFile(resource, context);
		if (file != null) {
			try {
				registerCurrentSourceFolder(context, delta, fileSystemAccess);
				try {
					elementIssueProviderFactory.attachData(resource);
					getGenerator().doGenerate(resource, fileSystemAccess);
				} finally {
					elementIssueProviderFactory.detachData(resource);
				}
			} catch (OperationCanceledException e) {
				throw e;
			} catch (RuntimeException e) {
				if (e.getCause() instanceof CoreException) {
					throw (CoreException) e.getCause();
				}
				throw e;
			}
		}
	}

	protected IFile getFile(Resource resource, IBuildContext context) {
		Iterable<Pair<IStorage, IProject>> storages = mapper.getStorages(resource.getURI());
		for (Pair<IStorage, IProject> pair : storages) {
			if (pair.getFirst() instanceof IFile && pair.getSecond().equals(context.getBuiltProject())) {
				return (IFile) pair.getFirst();
			}
		}
		return null;
	}

	/**
	 * @since 2.4
	 */
	protected List<IPath> getSourceFolderPathes(IProject project){
		List<IPath> sourceFolder = Lists.newArrayList();
		try {
			if (project.isOpen() && JavaProject.hasJavaNature(project)) {
				IJavaProject javaProject = JavaCore.create(project);
				List<IPackageFragmentRoot> packageFragmentRoots = Arrays.asList(javaProject.getPackageFragmentRoots());
				for(IPackageFragmentRoot packageFragmentRoot : packageFragmentRoots){
					if(packageFragmentRoot.getKind() == IPackageFragmentRoot.K_SOURCE){
						IPath path = packageFragmentRoot.getPath();
						sourceFolder.add(path);
					}
				}
			}
		} catch (JavaModelException e) {
			LOGGER.error(e.getMessage(), e);
		}
		return sourceFolder;
	}

	@Override
	protected Map<OutputConfiguration, Iterable<IMarker>> getGeneratorMarkers(IProject builtProject, Collection<OutputConfiguration> outputConfigurations) throws CoreException{
		Map<OutputConfiguration, Iterable<IMarker>> generatorMarkers = newHashMap();
		 List<IPath> sourcePath = getSourceFolderPathes(builtProject);
		 for (OutputConfiguration config : outputConfigurations) {
			 if (config.isCleanUpDerivedResources()) {
				List<IContainer> containerToSearchIn = Lists.newArrayList();
				for(IPath sourceFolder : sourcePath){
					if (sourceFolder.segmentCount() == 1) {
						containerToSearchIn.add(builtProject);
					} else {
						IContainer sourcePathBasedContainer = builtProject.getWorkspace().getRoot().getFolder(sourceFolder);
						containerToSearchIn.add(sourcePathBasedContainer);
					}
				}
				Collection<IMarker> markers = Lists.newArrayList();
				for(IContainer container : containerToSearchIn){
					Iterables.addAll(markers, getDerivedResourceMarkers().findDerivedResourceMarkers(container, getGeneratorIdProvider().getGeneratorIdentifier()));
				}
				generatorMarkers.put(config, markers);
			 }
		 }
		 return generatorMarkers;
	}
}
