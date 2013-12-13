package fr.irit.smac.may.speadl.jvmmodel;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jdt.annotation.Nullable;
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
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.util.Pair;
import org.eclipse.xtext.xbase.jvmmodel.JvmModelAssociator;
import org.eclipse.xtext.xbase.jvmmodel.JvmTypesBuilder;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

import com.google.inject.Inject;

public class SpeADLJvmTypesBuilder extends JvmTypesBuilder {

	@Inject
	private TypesFactory typesFactory;
	
	@Nullable 
	public JvmGenericType newClass(@Nullable QualifiedName name, @Nullable Procedure1<? super JvmGenericType> initializer) {
		return newClass(name != null ? name.toString() : null, initializer);
	}
	
	/**
	 * Creates a public class declaration, associated to the given sourceElement. It sets the given name, which might be
	 * fully qualified using the standard Java notation.
	 * 
	 * @param sourceElement
	 *            the sourceElement the resulting element is associated with.
	 * @param name
	 *            the qualified name of the resulting class.
	 * @param initializer
	 *            the initializer to apply on the created class element. If <code>null</code>, the class won't be initialized.
	 * 
	 * @return a {@link JvmGenericType} representing a Java class of the given name, <code>null</code> 
	 *            if sourceElement or name are <code>null</code>.
	 */
	@Nullable 
	public JvmGenericType newClass(@Nullable String name, @Nullable Procedure1<? super JvmGenericType> initializer) {
		final JvmGenericType result = createJvmGenericType(name);
		if (result == null)
			return null;
		return initializeSafely(result, initializer);
	}
	
	
	/**
	 * Creates a public interface declaration, associated to the given sourceElement. It sets the given name, which might be
	 * fully qualified using the standard Java notation.
	 * 
	 * @param sourceElement
	 *            the sourceElement the resulting element is associated with.
	 * @param name
	 *            the qualified name of the resulting class.
	 * @param initializer
	 *            the initializer to apply on the created interface element. If <code>null</code>, the interface won't be initialized.
	 * 
	 * @return a {@link JvmGenericType} representing a Java class of the given name, <code>null</code> 
	 *            if sourceElement or name are <code>null</code>.
	 */
	@Nullable 
	public JvmGenericType newInterface(@Nullable String name, @Nullable Procedure1<? super JvmGenericType> initializer) {
		final JvmGenericType result = createJvmGenericType(name);
		if (result == null)
			return null;
		result.setInterface(true);
		return initializeSafely(result, initializer);
	}
	
	@Nullable 
	protected JvmGenericType createJvmGenericType(@Nullable String name) {
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
	
	/**
	 * Creates and returns a formal parameter for the given name and type, which is associated to the given source
	 * element.
	 * 
	 * @return a Java parameter given name, <code>null</code> if sourceElement or name are <code>null</code>.
	 */
	@Nullable 
	public JvmFormalParameter newParameter(@Nullable String name, @Nullable JvmTypeReference typeRef) {
		if(name == null)
			return null;
		JvmFormalParameter result = typesFactory.createJvmFormalParameter();
		result.setName(name);
		result.setParameterType(cloneEObjectWithProxies(typeRef));
		return result;
	}
	
	/**
	 * Creates and returns a constructor with the given simple name associated to the given source element. By default
	 * the constructor will have an empty body and no arguments, hence the Java default constructor.
	 *
	 * @param sourceElement 
	 * 		      the sourceElement the constructor should be associated with.
	 * @param initializer
	 *            the initializer to apply on the created constructor. If <code>null</code>, the method won't be initialized.
	 * 
	 * @return a result representing a Java constructor with the given name, <code>null</code> if sourceElement is <code>null</code>.
	 */
	@Nullable 
	public JvmConstructor newConstructor(@Nullable Procedure1<? super JvmConstructor> initializer) {
		JvmConstructor constructor = typesFactory.createJvmConstructor();
		constructor.setVisibility(JvmVisibility.PUBLIC);
		return initializeSafely(constructor, initializer);
	}
	
	/**
	 * Creates a public method with the given name and the given return type and associates it with the given
	 * sourceElement.
	 * 
	 * @param sourceElement 
	 * 		the sourceElement the method should be associated with.
	 * @param name
	 * 		the simple name of the method to be created.
	 * @param returnType
	 * 		the return type of the created method.
	 * @param initializer
	 *            the initializer to apply on the created method. If <code>null</code>, the method won't be initialized.
	 * 
	 * @return a result representing a Java method with the given name, <code>null</code> if sourceElement or name are <code>null</code>.
	 */
	@Nullable
	public JvmOperation newMethod(@Nullable String name, @Nullable JvmTypeReference returnType,
			@Nullable Procedure1<? super JvmOperation> initializer) {
		if(name == null) 
			return null;
		JvmOperation result = typesFactory.createJvmOperation();
		result.setSimpleName(name);
		result.setVisibility(JvmVisibility.PUBLIC);
		result.setReturnType(cloneEObjectWithProxies(returnType));
		return initializeSafely(result, initializer);
	}
	
	@Nullable
	public JvmOperation newMethod(@Nullable String name, @Nullable Procedure1<? super JvmOperation> initializer) {
		if(name == null) 
			return null;
		JvmOperation result = typesFactory.createJvmOperation();
		result.setSimpleName(name);
		result.setVisibility(JvmVisibility.PUBLIC);
		return initializeSafely(result, initializer);
	}
	
	/**
	 * Same as {@link #toField(EObject, String, JvmTypeReference)} but with an initializer passed as the last argument.
	 */
	@Nullable	
	public JvmField newField(@Nullable String name, @Nullable JvmTypeReference typeRef, 
			@Nullable Procedure1<? super JvmField> initializer) {
		if(name == null) 
			return null;
		JvmField result = typesFactory.createJvmField();
		result.setSimpleName(name);
		result.setVisibility(JvmVisibility.PRIVATE);
		result.setType(cloneEObjectWithProxies(typeRef));
		return initializeSafely(result, initializer);
	}
	
	/**
	 * Creates a deep copy of the given object and associates each copied instance with the
	 * clone. Does not resolve any proxies.
	 *	
	 * @param original the root element to be cloned.
	 * @return a clone of tree rooted in original associated with the original, <code>null</code> if original is <code>null</code>. 
	 */
	protected <T extends EObject> T cloneEObject(T original) {
		EcoreUtil.Copier copier = new EcoreUtil.Copier(false);
		@SuppressWarnings("unchecked")
		T copy = (T) copier.copy(original);
		copier.copyReferences();
		return copy;
	}
	
	/**
	 * Creates a deep copy of the given object and associates each copied instance with the
	 * clone. Does not resolve any proxies.
	 *	
	 * @param original the root element to be cloned.
	 * @return a clone of tree rooted in original associated with the original, <code>null</code> if original is <code>null</code>. 
	 */
	protected <T extends JvmTypeReference> T cloneEObject(T original) {
		EcoreUtil.Copier copier = new EcoreUtil.Copier(false) {
			private static final long serialVersionUID = 1L;
			
			@Override
			public EObject copy(@Nullable EObject eObject) {
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
	
	/**
	 * Creates a clone of the given {@link JvmIdentifiableElement} without resolving any proxies.
	 * The clone will be associated with the original element by means of {@link JvmModelAssociator associations}.
	 * 
 	 * @param original the element to be cloned.
	 * @return a clone of original associated with the original, <code>null</code> if original is <code>null</code>. 
	 */
	@Nullable 
	public <T extends JvmIdentifiableElement> T cloneEObjectWithProxies(@Nullable T original) {
		if(original == null)
			return null;
		return cloneEObject(original);
	}
	
	/**
	 * Creates a clone of the given {@link JvmTypeReference} without resolving any proxies.
	 * The clone will be associated with the original element by means of {@link JvmModelAssociator associations}.
	 * 
	 * @param typeRef the type reference to be cloned.
	 * @return a clone of typeRef, <code>null</code> if typeRef is <code>null</code> or a {@link JvmUnknownTypeReference} 
	 *     if there is a problem with the typeRef. 
	 */
	@Nullable 
	public JvmTypeReference cloneEObjectWithProxies(@Nullable JvmTypeReference typeRef) {
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
