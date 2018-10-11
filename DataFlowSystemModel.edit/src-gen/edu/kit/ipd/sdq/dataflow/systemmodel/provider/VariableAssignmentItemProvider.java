/**
 */
package edu.kit.ipd.sdq.dataflow.systemmodel.provider;

import edu.kit.ipd.sdq.dataflow.systemmodel.Attribute;
import edu.kit.ipd.sdq.dataflow.systemmodel.SystemModelFactory;
import edu.kit.ipd.sdq.dataflow.systemmodel.SystemModelPackage;
import edu.kit.ipd.sdq.dataflow.systemmodel.Value;
import edu.kit.ipd.sdq.dataflow.systemmodel.Variable;
import edu.kit.ipd.sdq.dataflow.systemmodel.VariableAssignment;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.ResourceLocator;

import org.eclipse.emf.ecore.EStructuralFeature;

import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ItemProviderAdapter;
import org.eclipse.emf.edit.provider.ViewerNotification;

/**
 * This is the item provider adapter for a {@link edu.kit.ipd.sdq.dataflow.systemmodel.VariableAssignment} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class VariableAssignmentItemProvider extends ItemProviderAdapter implements IEditingDomainItemProvider,
		IStructuredItemContentProvider, ITreeItemContentProvider, IItemLabelProvider, IItemPropertySource {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VariableAssignmentItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	/**
	 * This returns the property descriptors for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public List<IItemPropertyDescriptor> getPropertyDescriptors(Object object) {
		if (itemPropertyDescriptors == null) {
			super.getPropertyDescriptors(object);

			addVariablePropertyDescriptor(object);
			addAttributePropertyDescriptor(object);
			addValuePropertyDescriptor(object);
			addIsAttributeWildcardPropertyDescriptor(object);
			addIsValueWildcardPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Variable feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	protected void addVariablePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(new ItemPropertyDescriptor(
				((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(), getResourceLocator(),
				getString("_UI_VariableAssignment_variable_feature"),
				getString("_UI_PropertyDescriptor_description", "_UI_VariableAssignment_variable_feature",
						"_UI_VariableAssignment_type"),
				SystemModelPackage.Literals.VARIABLE_ASSIGNMENT__VARIABLE, true, false, true, null, null, null) {

			@Override
			public Collection<?> getChoiceOfValues(Object thisObject) {
				return ((VariableAssignment) thisObject).getPossibleVariables();
			}

		});
	}

	/**
	 * This adds a property descriptor for the Attribute feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	protected void addAttributePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(new ItemPropertyDescriptor(
				((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(), getResourceLocator(),
				getString("_UI_VariableAssignment_attribute_feature"),
				getString("_UI_PropertyDescriptor_description", "_UI_VariableAssignment_attribute_feature",
						"_UI_VariableAssignment_type"),
				SystemModelPackage.Literals.VARIABLE_ASSIGNMENT__ATTRIBUTE, true, false, true, null, null, null) {

			@Override
			public Collection<?> getChoiceOfValues(Object thisObject) {
				return ((VariableAssignment) thisObject).getPossibleAttributes();
			}
		});
	}

	/**
	 * This adds a property descriptor for the Value feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	protected void addValuePropertyDescriptor(Object object) {
		itemPropertyDescriptors
				.add(new ItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
						getResourceLocator(), getString("_UI_VariableAssignment_value_feature"),
						getString("_UI_PropertyDescriptor_description", "_UI_VariableAssignment_value_feature",
								"_UI_VariableAssignment_type"),
						SystemModelPackage.Literals.VARIABLE_ASSIGNMENT__VALUE, true, false, true, null, null, null) {

					@Override
					public Collection<?> getChoiceOfValues(Object thisObject) {
						return ((VariableAssignment) thisObject).getPossibleValues();
					}
				});
	}

	/**
	 * This adds a property descriptor for the Is Attribute Wildcard feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addIsAttributeWildcardPropertyDescriptor(Object object) {
		itemPropertyDescriptors
				.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
						getResourceLocator(), getString("_UI_VariableAssignment_isAttributeWildcard_feature"),
						getString("_UI_PropertyDescriptor_description",
								"_UI_VariableAssignment_isAttributeWildcard_feature", "_UI_VariableAssignment_type"),
						SystemModelPackage.Literals.VARIABLE_ASSIGNMENT__IS_ATTRIBUTE_WILDCARD, false, false, false,
						ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null));
	}

	/**
	 * This adds a property descriptor for the Is Value Wildcard feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addIsValueWildcardPropertyDescriptor(Object object) {
		itemPropertyDescriptors
				.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
						getResourceLocator(), getString("_UI_VariableAssignment_isValueWildcard_feature"),
						getString("_UI_PropertyDescriptor_description",
								"_UI_VariableAssignment_isValueWildcard_feature", "_UI_VariableAssignment_type"),
						SystemModelPackage.Literals.VARIABLE_ASSIGNMENT__IS_VALUE_WILDCARD, false, false, false,
						ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null));
	}

	/**
	 * This specifies how to implement {@link #getChildren} and is used to deduce an appropriate feature for an
	 * {@link org.eclipse.emf.edit.command.AddCommand}, {@link org.eclipse.emf.edit.command.RemoveCommand} or
	 * {@link org.eclipse.emf.edit.command.MoveCommand} in {@link #createCommand}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Collection<? extends EStructuralFeature> getChildrenFeatures(Object object) {
		if (childrenFeatures == null) {
			super.getChildrenFeatures(object);
			childrenFeatures.add(SystemModelPackage.Literals.VARIABLE_ASSIGNMENT__TERM);
		}
		return childrenFeatures;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EStructuralFeature getChildFeature(Object object, Object child) {
		// Check the type of the specified child object and return the proper feature to use for
		// adding (see {@link AddCommand}) it as a child.

		return super.getChildFeature(object, child);
	}

	/**
	 * This returns VariableAssignment.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/VariableAssignment"));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected boolean shouldComposeCreationImage() {
		return true;
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public String getText(Object object) {
		Optional<VariableAssignment> assignment = Util.tryCast(VariableAssignment.class, object);
		Optional<Variable> var = assignment.map(VariableAssignment::getVariable);
		String varName = var.map(Variable::getName).orElse("");
		String attribName = assignment.map(VariableAssignment::getAttribute).map(Attribute::getName).orElse("*");
		String valueName = assignment.map(VariableAssignment::getValue).map(Value::getName).orElse("*");
		return getString("_UI_VariableAssignment_type") + ": " + varName + "." + attribName + "." + valueName;
	}

	/**
	 * This handles model notifications by calling {@link #updateChildren} to update any cached
	 * children and by creating a viewer notification, which it passes to {@link #fireNotifyChanged}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void notifyChanged(Notification notification) {
		updateChildren(notification);

		switch (notification.getFeatureID(VariableAssignment.class)) {
		case SystemModelPackage.VARIABLE_ASSIGNMENT__VARIABLE:
		case SystemModelPackage.VARIABLE_ASSIGNMENT__ATTRIBUTE:
		case SystemModelPackage.VARIABLE_ASSIGNMENT__VALUE:
		case SystemModelPackage.VARIABLE_ASSIGNMENT__IS_ATTRIBUTE_WILDCARD:
		case SystemModelPackage.VARIABLE_ASSIGNMENT__IS_VALUE_WILDCARD:
			fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
			return;
		case SystemModelPackage.VARIABLE_ASSIGNMENT__TERM:
			fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), true, false));
			return;
		}
		super.notifyChanged(notification);
	}

	/**
	 * This adds {@link org.eclipse.emf.edit.command.CommandParameter}s describing the children
	 * that can be created under this object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected void collectNewChildDescriptors(Collection<Object> newChildDescriptors, Object object) {
		super.collectNewChildDescriptors(newChildDescriptors, object);

		newChildDescriptors.add(createChildParameter(SystemModelPackage.Literals.VARIABLE_ASSIGNMENT__TERM,
				SystemModelFactory.eINSTANCE.createTrue()));

		newChildDescriptors.add(createChildParameter(SystemModelPackage.Literals.VARIABLE_ASSIGNMENT__TERM,
				SystemModelFactory.eINSTANCE.createFalse()));

		newChildDescriptors.add(createChildParameter(SystemModelPackage.Literals.VARIABLE_ASSIGNMENT__TERM,
				SystemModelFactory.eINSTANCE.createAnd()));

		newChildDescriptors.add(createChildParameter(SystemModelPackage.Literals.VARIABLE_ASSIGNMENT__TERM,
				SystemModelFactory.eINSTANCE.createOr()));

		newChildDescriptors.add(createChildParameter(SystemModelPackage.Literals.VARIABLE_ASSIGNMENT__TERM,
				SystemModelFactory.eINSTANCE.createNot()));

		newChildDescriptors.add(createChildParameter(SystemModelPackage.Literals.VARIABLE_ASSIGNMENT__TERM,
				SystemModelFactory.eINSTANCE.createParameterRef()));

		newChildDescriptors.add(createChildParameter(SystemModelPackage.Literals.VARIABLE_ASSIGNMENT__TERM,
				SystemModelFactory.eINSTANCE.createPropertyRef()));

		newChildDescriptors.add(createChildParameter(SystemModelPackage.Literals.VARIABLE_ASSIGNMENT__TERM,
				SystemModelFactory.eINSTANCE.createReturnValueRef()));

		newChildDescriptors.add(createChildParameter(SystemModelPackage.Literals.VARIABLE_ASSIGNMENT__TERM,
				SystemModelFactory.eINSTANCE.createStateRef()));

		newChildDescriptors.add(createChildParameter(SystemModelPackage.Literals.VARIABLE_ASSIGNMENT__TERM,
				SystemModelFactory.eINSTANCE.createDefaultStateRef()));
	}

	/**
	 * Return the resource locator for this item provider's resources.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ResourceLocator getResourceLocator() {
		return DataflowsystemEditPlugin.INSTANCE;
	}

}
