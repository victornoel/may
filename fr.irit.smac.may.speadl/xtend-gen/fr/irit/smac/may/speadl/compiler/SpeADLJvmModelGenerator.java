package fr.irit.smac.may.speadl.compiler;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import fr.irit.smac.may.speadl.SpeADLUtils;
import fr.irit.smac.may.speadl.speadl.Ecosystem;
import java.util.Arrays;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.diagnostics.Severity;
import org.eclipse.xtext.generator.IFileSystemAccess;
import org.eclipse.xtext.validation.Issue;
import org.eclipse.xtext.xbase.compiler.IElementIssueProvider;
import org.eclipse.xtext.xbase.compiler.JvmModelGenerator;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

@SuppressWarnings("all")
public class SpeADLJvmModelGenerator extends JvmModelGenerator {
  @Inject
  @Extension
  private SpeADLUtils _speADLUtils;
  
  @Inject
  private IElementIssueProvider.Factory issueProviderFactory;
  
  @Override
  protected void _internalDoGenerate(final JvmDeclaredType type, final IFileSystemAccess fsa) {
    final Ecosystem eco = this._speADLUtils.associatedEcosystem(type);
    if (((eco != null) && (!this.modelElementHasError(eco)))) {
      super._internalDoGenerate(type, fsa);
    }
  }
  
  private boolean modelElementHasError(final EObject e) {
    boolean _xblockexpression = false;
    {
      final IElementIssueProvider issueProvider = this.issueProviderFactory.get(e.eResource());
      _xblockexpression = (IterableExtensions.<Issue>exists(issueProvider.getIssues(e), ((Function1<Issue, Boolean>) (Issue it) -> {
        Severity _severity = it.getSeverity();
        return Boolean.valueOf(Objects.equal(_severity, Severity.ERROR));
      })) || IterableExtensions.<EObject>exists(e.eContents(), ((Function1<EObject, Boolean>) (EObject it) -> {
        return Boolean.valueOf(this.modelElementHasError(it));
      })));
    }
    return _xblockexpression;
  }
  
  @Override
  public void internalDoGenerate(final EObject type, final IFileSystemAccess fsa) {
    if (type instanceof JvmDeclaredType) {
      _internalDoGenerate((JvmDeclaredType)type, fsa);
      return;
    } else if (type != null) {
      _internalDoGenerate(type, fsa);
      return;
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(type, fsa).toString());
    }
  }
}
