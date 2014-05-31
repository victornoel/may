package fr.irit.smac.may.speadl.compiler;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import fr.irit.smac.may.speadl.SpeADLUtils;
import fr.irit.smac.may.speadl.speadl.Ecosystem;
import java.util.Arrays;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
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
public class MyJvmModelGenerator extends JvmModelGenerator {
  @Inject
  @Extension
  private SpeADLUtils _speADLUtils;
  
  @Inject
  private IElementIssueProvider.Factory issueProviderFactory;
  
  protected void _internalDoGenerate(final JvmDeclaredType type, final IFileSystemAccess fsa) {
    final Ecosystem eco = this._speADLUtils.associatedEcosystem(type);
    boolean _and = false;
    boolean _tripleNotEquals = (eco != null);
    if (!_tripleNotEquals) {
      _and = false;
    } else {
      boolean _modelElementHasError = this.modelElementHasError(eco);
      boolean _not = (!_modelElementHasError);
      _and = _not;
    }
    if (_and) {
      super._internalDoGenerate(type, fsa);
    }
  }
  
  private boolean modelElementHasError(final EObject e) {
    boolean _xblockexpression = false;
    {
      Resource _eResource = e.eResource();
      final IElementIssueProvider issueProvider = this.issueProviderFactory.get(_eResource);
      boolean _or = false;
      Iterable<Issue> _issues = issueProvider.getIssues(e);
      final Function1<Issue, Boolean> _function = new Function1<Issue, Boolean>() {
        public Boolean apply(final Issue it) {
          Severity _severity = it.getSeverity();
          return Boolean.valueOf(Objects.equal(_severity, Severity.ERROR));
        }
      };
      boolean _exists = IterableExtensions.<Issue>exists(_issues, _function);
      if (_exists) {
        _or = true;
      } else {
        EList<EObject> _eContents = e.eContents();
        final Function1<EObject, Boolean> _function_1 = new Function1<EObject, Boolean>() {
          public Boolean apply(final EObject it) {
            return Boolean.valueOf(MyJvmModelGenerator.this.modelElementHasError(it));
          }
        };
        boolean _exists_1 = IterableExtensions.<EObject>exists(_eContents, _function_1);
        _or = _exists_1;
      }
      _xblockexpression = _or;
    }
    return _xblockexpression;
  }
  
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
