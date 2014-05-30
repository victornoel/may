package fr.irit.smac.may.speadl.compiler;

import com.google.common.collect.Sets;
import java.util.Collections;
import java.util.Set;
import org.eclipse.xtext.generator.IFileSystemAccess;
import org.eclipse.xtext.generator.OutputConfiguration;
import org.eclipse.xtext.generator.OutputConfigurationProvider;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

@SuppressWarnings("all")
public class SpeADLOutputConfigurationProvider extends OutputConfigurationProvider {
  public Set<OutputConfiguration> getOutputConfigurations() {
    OutputConfiguration _outputConfiguration = new OutputConfiguration(IFileSystemAccess.DEFAULT_OUTPUT);
    final Procedure1<OutputConfiguration> _function = new Procedure1<OutputConfiguration>() {
      public void apply(final OutputConfiguration it) {
        it.setDescription("Output folder for generated Java files");
        it.setOutputDirectory("speadl-gen");
        it.setOverrideExistingResources(true);
        it.setCreateOutputDirectory(true);
        it.setCanClearOutputDirectory(true);
        it.setCleanUpDerivedResources(true);
        it.setKeepLocalHistory(Boolean.valueOf(false));
        it.setSetDerivedProperty(true);
      }
    };
    OutputConfiguration _doubleArrow = ObjectExtensions.<OutputConfiguration>operator_doubleArrow(_outputConfiguration, _function);
    return Collections.<OutputConfiguration>unmodifiableSet(Sets.<OutputConfiguration>newHashSet(_doubleArrow));
  }
}
