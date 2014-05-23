package fr.irit.smac.may.speadl.compiler;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import fr.irit.smac.may.speadl.SpeADLUtils;
import fr.irit.smac.may.speadl.speadl.Ecosystem;
import java.util.Arrays;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.generator.IFileSystemAccess;
import org.eclipse.xtext.validation.CheckType;
import org.eclipse.xtext.validation.Issue;
import org.eclipse.xtext.xbase.compiler.JvmModelGenerator;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;

@SuppressWarnings("all")
public class MyJvmModelGenerator extends JvmModelGenerator {
  @Inject
  @Extension
  private SpeADLUtils _speADLUtils;
  
  protected void _internalDoGenerate(final JvmDeclaredType type, final IFileSystemAccess fsa) {
    final Ecosystem eco = this._speADLUtils.associatedEcosystem(type);
    final Function1<Issue, Boolean> _function = new Function1<Issue, Boolean>() {
      public Boolean apply(final Issue it) {
        CheckType _type = it.getType();
        return Boolean.valueOf(Objects.equal(_type, CheckType.NORMAL));
      }
    };
    boolean _modelElementHasError = this._speADLUtils.modelElementHasError(eco, false, _function, true);
    boolean _not = (!_modelElementHasError);
    if (_not) {
      super._internalDoGenerate(type, fsa);
    }
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
