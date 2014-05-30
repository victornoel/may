package fr.irit.smac.may.speadl.scoping;

import static java.util.Collections.singletonList;

import java.util.List;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.common.types.JvmTypeParameterDeclarator;
import org.eclipse.xtext.naming.IQualifiedNameConverter;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.EObjectDescription;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.ISelectable;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.impl.ImportNormalizer;
import org.eclipse.xtext.scoping.impl.MapBasedScope;
import org.eclipse.xtext.scoping.impl.ScopeBasedSelectable;
import org.eclipse.xtext.util.Strings;
import org.eclipse.xtext.xbase.jvmmodel.IJvmModelAssociations;
import org.eclipse.xtext.xbase.scoping.XImportSectionNamespaceScopeProvider;

import com.google.common.collect.Lists;
import com.google.inject.Inject;

import fr.irit.smac.may.speadl.speadl.Ecosystem;

public class SpeADLImportSectionNamespaceScopeProvider extends XImportSectionNamespaceScopeProvider {
	
	@Inject private SpeADLDeclarativeScopeProvider myScopeProvider;
	@Inject private IQualifiedNameConverter qualifiedNameConverter;
	@Inject private IJvmModelAssociations associations;
	
	@Override
	public IScope getScope(EObject context, EReference reference) {
		IScope scope = null;
		
		if(scope == null && reference.getEContainingClass() != null) {
			// the second test prevent the declarative scope to be called
			// on an incomplete reference... (because we use them in fr.irit.smac.may.juno.spead.ui.contentassist.SpeADLProposalProvider)
			scope = myScopeProvider.getScope(context, reference);
		}
		
		if(scope == null){
			scope = super.getScope(context, reference);
		}
		return scope;
	}
	
	@Override
	protected List<ImportNormalizer> getImplicitImports(boolean ignoreCase) {
		// only import java lang by default
		return Lists.newArrayList(new ImportNormalizer(JAVA_LANG, true, false));
	}
	
	
	
	protected IScope getLocalElementsScope(IScope parent, IScope globalScope, EObject context, EReference reference) {
		IScope result = parent;
		QualifiedName name = getQualifiedNameOfLocalElement(context);
		boolean ignoreCase = isIgnoreCase(reference);
		ISelectable resourceOnlySelectable = getAllDescriptions(context.eResource());
		ISelectable globalScopeSelectable = new ScopeBasedSelectable(globalScope);
		
		// imports
		// used for exploiting import section
		List<ImportNormalizer> explicitImports = getImportedNamespaceResolvers(context, ignoreCase);
		if (!explicitImports.isEmpty()) {
			result = createImportScope(result, explicitImports, globalScopeSelectable, reference.getEReferenceType(), ignoreCase);
		}
		
		// local element
		// used for identifying features 
		if (name!=null) {
			ImportNormalizer localNormalizer = doCreateImportNormalizer(name, true, ignoreCase); 
			result = createImportScope(result, singletonList(localNormalizer), resourceOnlySelectable, reference.getEReferenceType(), ignoreCase);
		}
		
		if (context instanceof Ecosystem) {
			// scope for jvm elements
			Set<EObject> elements = associations.getJvmElements(context);
			if (!elements.isEmpty()) {
				// TODO be sure it is the correct one
				EObject derivedJvmElement = elements.iterator().next();
				// scope for JvmDeclaredTypes
				if (derivedJvmElement instanceof JvmDeclaredType) {
					// used for refering to java types in the same package
					JvmDeclaredType declaredType = (JvmDeclaredType) derivedJvmElement;
					QualifiedName jvmTypeName = getQualifiedNameOfLocalElement(declaredType);
					if (declaredType.getDeclaringType() == null && !Strings.isEmpty(declaredType.getPackageName())) {
						QualifiedName packageName = this.qualifiedNameConverter.toQualifiedName(declaredType.getPackageName());
						ImportNormalizer normalizer = doCreateImportNormalizer(packageName, true, ignoreCase);
						result = createImportScope(result, singletonList(normalizer), globalScopeSelectable, reference.getEReferenceType(), ignoreCase);
					}
					if (jvmTypeName != null && !jvmTypeName.equals(name)) {
						ImportNormalizer localNormalizer = doCreateImportNormalizer(jvmTypeName, true, ignoreCase); 
						result = createImportScope(result, singletonList(localNormalizer), resourceOnlySelectable, reference.getEReferenceType(), ignoreCase);
					}
				}
				// scope for JvmTypeParameterDeclarator
				if (derivedJvmElement instanceof JvmTypeParameterDeclarator) {
					JvmTypeParameterDeclarator parameterDeclarator = (JvmTypeParameterDeclarator) derivedJvmElement;
					List<IEObjectDescription> descriptions = null;
					for (JvmTypeParameter param : parameterDeclarator.getTypeParameters()) {
						if (param.getSimpleName() != null) {
							if (descriptions == null)
								descriptions = Lists.newArrayList();
							QualifiedName paramName = QualifiedName.create(param.getSimpleName());
							descriptions.add(EObjectDescription.create(paramName, param));
						}
					}
					if (descriptions != null && !descriptions.isEmpty())
						result = MapBasedScope.createScope(result, descriptions);
				}
			}
		}
		
		return result;
	}
	
}
