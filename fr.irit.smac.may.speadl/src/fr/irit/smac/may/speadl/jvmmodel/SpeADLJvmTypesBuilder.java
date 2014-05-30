package fr.irit.smac.may.speadl.jvmmodel;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.common.types.JvmConstructor;
import org.eclipse.xtext.common.types.JvmField;
import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.common.types.JvmGenericType;
import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.JvmParameterizedTypeReference;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmTypeConstraint;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.JvmUnknownTypeReference;
import org.eclipse.xtext.common.types.JvmUpperBound;
import org.eclipse.xtext.common.types.JvmVisibility;
import org.eclipse.xtext.common.types.JvmWildcardTypeReference;
import org.eclipse.xtext.common.types.TypesFactory;
import org.eclipse.xtext.common.types.TypesPackage;
import org.eclipse.xtext.common.types.access.impl.ClassURIHelper;
import org.eclipse.xtext.util.Pair;
import org.eclipse.xtext.xbase.jvmmodel.JvmTypesBuilder;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

import com.google.inject.Inject;

public class SpeADLJvmTypesBuilder extends JvmTypesBuilder {

	@Inject
	private TypesFactory typesFactory;
	
	public JvmGenericType newClass(String name, Procedure1<? super JvmGenericType> initializer) {
		final JvmGenericType result = createJvmGenericType(name);
		if (result == null)
			return null;
		return initializeSafely(result, initializer);
	}
	
	public JvmGenericType newInterface(String name, Procedure1<? super JvmGenericType> initializer) {
		final JvmGenericType result = createJvmGenericType(name);
		if (result == null)
			return null;
		result.setInterface(true);
		return initializeSafely(result, initializer);
	}
	
	protected JvmGenericType createJvmGenericType(String name) {
		if (name == null)
			return null;
		Pair<String, String> fullName = splitQualifiedName(name);
		final JvmGenericType result = typesFactory.createJvmGenericType();
		result.setSimpleName(fullName.getSecond());
		if (fullName.getFirst() != null)
			result.setPackageName(fullName.getFirst());
		result.setVisibility(JvmVisibility.PUBLIC);
		return result;
	}

	public JvmFormalParameter newParameter(String name, JvmTypeReference typeRef) {
		if(name == null)
			return null;
		JvmFormalParameter result = typesFactory.createJvmFormalParameter();
		result.setName(name);
		result.setParameterType(cloneEObjectWithProxies(typeRef));
		return result;
	}
	
	public JvmConstructor newConstructor(Procedure1<? super JvmConstructor> initializer) {
		JvmConstructor constructor = typesFactory.createJvmConstructor();
		constructor.setVisibility(JvmVisibility.PUBLIC);
		return initializeSafely(constructor, initializer);
	}
	
	public JvmOperation newMethod(String name, JvmTypeReference returnType,
			Procedure1<? super JvmOperation> initializer) {
		if(name == null) 
			return null;
		JvmOperation result = typesFactory.createJvmOperation();
		result.setSimpleName(name);
		result.setVisibility(JvmVisibility.PUBLIC);
		result.setReturnType(cloneEObjectWithProxies(returnType));
		return initializeSafely(result, initializer);
	}
	
	public JvmOperation newMethod(String name, Procedure1<? super JvmOperation> initializer) {
		if(name == null) 
			return null;
		JvmOperation result = typesFactory.createJvmOperation();
		result.setSimpleName(name);
		result.setVisibility(JvmVisibility.PUBLIC);
		return initializeSafely(result, initializer);
	}
	
	public JvmField newField(String name, JvmTypeReference typeRef, 
			Procedure1<? super JvmField> initializer) {
		if(name == null) 
			return null;
		JvmField result = typesFactory.createJvmField();
		result.setSimpleName(name);
		result.setVisibility(JvmVisibility.PRIVATE);
		result.setType(cloneEObjectWithProxies(typeRef));
		return initializeSafely(result, initializer);
	}
	
	protected <T extends EObject> T cloneEObject(T original) {
		EcoreUtil.Copier copier = new EcoreUtil.Copier(false);
		@SuppressWarnings("unchecked")
		T copy = (T) copier.copy(original);
		copier.copyReferences();
		return copy;
	}
	
	protected <T extends JvmTypeReference> T cloneEObject(T original) {
		EcoreUtil.Copier copier = new EcoreUtil.Copier(false) {
			private static final long serialVersionUID = 1L;
			
			@Override
			public EObject copy(EObject eObject) {
				EObject result = super.copy(eObject);
				if (result instanceof JvmWildcardTypeReference) {
					boolean upperBoundSeen = false;
					for(JvmTypeConstraint constraint: ((JvmWildcardTypeReference) result).getConstraints()) {
						if (constraint instanceof JvmUpperBound) {
							upperBoundSeen = true;
							break;
						}
					}
					if (!upperBoundSeen) {
						// no upper bound found - seems to be an invalid - assume object as upper bound
						JvmTypeReference object = newObjectReference();
						JvmUpperBound upperBound = typesFactory.createJvmUpperBound();
						upperBound.setTypeReference(object);
						((JvmWildcardTypeReference) result).getConstraints().add(0, upperBound);
					}
				}
				return result;
			}
		};
		@SuppressWarnings("unchecked")
		T copy = (T) copier.copy(original);
		copier.copyReferences();
		return copy;
	}
	
	private JvmTypeReference newObjectReference() {
		URI objectURI = new ClassURIHelper().getFullURI(Object.class);
		JvmType objectType = typesFactory.createJvmGenericType();
		((InternalEObject)objectType).eSetProxyURI(objectURI);
		JvmParameterizedTypeReference result = typesFactory.createJvmParameterizedTypeReference();
		result.setType(objectType);
		return result;
	}
	
	public <T extends JvmIdentifiableElement> T cloneEObjectWithProxies(T original) {
		if(original == null)
			return null;
		return cloneEObject(original);
	}
	
	public JvmTypeReference cloneEObjectWithProxies(JvmTypeReference typeRef) {
		if(typeRef == null)
			return null;
		if (typeRef instanceof JvmParameterizedTypeReference && !typeRef.eIsProxy()
				&& !typeRef.eIsSet(TypesPackage.Literals.JVM_PARAMETERIZED_TYPE_REFERENCE__TYPE)) {
			JvmUnknownTypeReference unknownTypeReference = typesFactory.createJvmUnknownTypeReference();
			return unknownTypeReference;
		}
		return cloneEObject(typeRef);
	}
}
