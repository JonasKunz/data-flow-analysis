/**
 */
package edu.kit.ipd.sdq.dataflow.systemmodel.impl;

import edu.kit.ipd.sdq.dataflow.systemmodel.Property;
import edu.kit.ipd.sdq.dataflow.systemmodel.PropertyDefinition;
import edu.kit.ipd.sdq.dataflow.systemmodel.SystemModelPackage;
import edu.kit.ipd.sdq.dataflow.systemmodel.Value;

import java.lang.reflect.InvocationTargetException;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.WrappedException;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Property Definition</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link edu.kit.ipd.sdq.dataflow.systemmodel.impl.PropertyDefinitionImpl#getProperty <em>Property</em>}</li>
 *   <li>{@link edu.kit.ipd.sdq.dataflow.systemmodel.impl.PropertyDefinitionImpl#getPresentValues <em>Present Values</em>}</li>
 * </ul>
 *
 * @generated
 */
public class PropertyDefinitionImpl extends MinimalEObjectImpl.Container implements PropertyDefinition {
	/**
	 * The cached value of the '{@link #getProperty() <em>Property</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProperty()
	 * @generated
	 * @ordered
	 */
	protected Property property;

	/**
	 * The cached value of the '{@link #getPresentValues() <em>Present Values</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPresentValues()
	 * @generated
	 * @ordered
	 */
	protected EList<Value> presentValues;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PropertyDefinitionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SystemModelPackage.Literals.PROPERTY_DEFINITION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Property getProperty() {
		if (property != null && property.eIsProxy()) {
			InternalEObject oldProperty = (InternalEObject) property;
			property = (Property) eResolveProxy(oldProperty);
			if (property != oldProperty) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE,
							SystemModelPackage.PROPERTY_DEFINITION__PROPERTY, oldProperty, property));
			}
		}
		return property;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Property basicGetProperty() {
		return property;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setProperty(Property newProperty) {
		Property oldProperty = property;
		property = newProperty;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SystemModelPackage.PROPERTY_DEFINITION__PROPERTY,
					oldProperty, property));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Value> getPresentValues() {
		if (presentValues == null) {
			presentValues = new EObjectResolvingEList<Value>(Value.class, this,
					SystemModelPackage.PROPERTY_DEFINITION__PRESENT_VALUES);
		}
		return presentValues;
	}

	/**
	 * The cached invocation delegate for the '{@link #getPossibleValues() <em>Get Possible Values</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPossibleValues()
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate GET_POSSIBLE_VALUES__EINVOCATION_DELEGATE = ((EOperation.Internal) SystemModelPackage.Literals.PROPERTY_DEFINITION___GET_POSSIBLE_VALUES)
			.getInvocationDelegate();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<Value> getPossibleValues() {
		try {
			return (EList<Value>) GET_POSSIBLE_VALUES__EINVOCATION_DELEGATE.dynamicInvoke(this, null);
		} catch (InvocationTargetException ite) {
			throw new WrappedException(ite);
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case SystemModelPackage.PROPERTY_DEFINITION__PROPERTY:
			if (resolve)
				return getProperty();
			return basicGetProperty();
		case SystemModelPackage.PROPERTY_DEFINITION__PRESENT_VALUES:
			return getPresentValues();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
		case SystemModelPackage.PROPERTY_DEFINITION__PROPERTY:
			setProperty((Property) newValue);
			return;
		case SystemModelPackage.PROPERTY_DEFINITION__PRESENT_VALUES:
			getPresentValues().clear();
			getPresentValues().addAll((Collection<? extends Value>) newValue);
			return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
		case SystemModelPackage.PROPERTY_DEFINITION__PROPERTY:
			setProperty((Property) null);
			return;
		case SystemModelPackage.PROPERTY_DEFINITION__PRESENT_VALUES:
			getPresentValues().clear();
			return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
		case SystemModelPackage.PROPERTY_DEFINITION__PROPERTY:
			return property != null;
		case SystemModelPackage.PROPERTY_DEFINITION__PRESENT_VALUES:
			return presentValues != null && !presentValues.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
		switch (operationID) {
		case SystemModelPackage.PROPERTY_DEFINITION___GET_POSSIBLE_VALUES:
			return getPossibleValues();
		}
		return super.eInvoke(operationID, arguments);
	}

} //PropertyDefinitionImpl
