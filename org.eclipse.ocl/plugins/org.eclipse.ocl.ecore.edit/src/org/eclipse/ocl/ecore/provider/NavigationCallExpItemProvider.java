/*******************************************************************************
 * Copyright (c) 2009, 2018 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   IBM - Initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.ecore.provider;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EStructuralFeature;

import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ViewerNotification;

import org.eclipse.ocl.ecore.EcoreFactory;
import org.eclipse.ocl.ecore.EcorePackage;
import org.eclipse.ocl.ecore.NavigationCallExp;

import org.eclipse.ocl.expressions.ExpressionsFactory;
import org.eclipse.ocl.expressions.ExpressionsPackage;

/**
 * This is the item provider adapter for a {@link org.eclipse.ocl.ecore.NavigationCallExp} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class NavigationCallExpItemProvider
		extends FeatureCallExpItemProvider {

	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NavigationCallExpItemProvider(AdapterFactory adapterFactory) {
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

			addNavigationSourcePropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Navigation Source feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addNavigationSourcePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(
			((ComposeableAdapterFactory) adapterFactory)
				.getRootAdapterFactory(),
			getResourceLocator(),
			getString("_UI_NavigationCallExp_navigationSource_feature"), //$NON-NLS-1$
			getString("_UI_PropertyDescriptor_description", //$NON-NLS-1$
				"_UI_NavigationCallExp_navigationSource_feature", //$NON-NLS-1$
				"_UI_NavigationCallExp_type"), //$NON-NLS-1$
			ExpressionsPackage.Literals.NAVIGATION_CALL_EXP__NAVIGATION_SOURCE,
			true, false, false, null, null, null));
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
	public Collection<? extends EStructuralFeature> getChildrenFeatures(
			Object object) {
		if (childrenFeatures == null) {
			super.getChildrenFeatures(object);
			childrenFeatures.add(
				ExpressionsPackage.Literals.NAVIGATION_CALL_EXP__QUALIFIER);
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
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		String label = ((NavigationCallExp) object).getName();
		return label == null || label.length() == 0
			? getString("_UI_NavigationCallExp_type") //$NON-NLS-1$
			: getString("_UI_NavigationCallExp_type") + " " + label; //$NON-NLS-1$ //$NON-NLS-2$
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

		switch (notification.getFeatureID(NavigationCallExp.class)) {
			case EcorePackage.NAVIGATION_CALL_EXP__QUALIFIER :
				fireNotifyChanged(new ViewerNotification(notification,
					notification.getNotifier(), true, false));
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
	protected void collectNewChildDescriptors(
			Collection<Object> newChildDescriptors, Object object) {
		super.collectNewChildDescriptors(newChildDescriptors, object);

		newChildDescriptors.add(createChildParameter(
			ExpressionsPackage.Literals.NAVIGATION_CALL_EXP__QUALIFIER,
			EcoreFactory.eINSTANCE.createAssociationClassCallExp()));

		newChildDescriptors.add(createChildParameter(
			ExpressionsPackage.Literals.NAVIGATION_CALL_EXP__QUALIFIER,
			EcoreFactory.eINSTANCE.createBooleanLiteralExp()));

		newChildDescriptors.add(createChildParameter(
			ExpressionsPackage.Literals.NAVIGATION_CALL_EXP__QUALIFIER,
			EcoreFactory.eINSTANCE.createCollectionLiteralExp()));

		newChildDescriptors.add(createChildParameter(
			ExpressionsPackage.Literals.NAVIGATION_CALL_EXP__QUALIFIER,
			EcoreFactory.eINSTANCE.createEnumLiteralExp()));

		newChildDescriptors.add(createChildParameter(
			ExpressionsPackage.Literals.NAVIGATION_CALL_EXP__QUALIFIER,
			EcoreFactory.eINSTANCE.createIfExp()));

		newChildDescriptors.add(createChildParameter(
			ExpressionsPackage.Literals.NAVIGATION_CALL_EXP__QUALIFIER,
			EcoreFactory.eINSTANCE.createIntegerLiteralExp()));

		newChildDescriptors.add(createChildParameter(
			ExpressionsPackage.Literals.NAVIGATION_CALL_EXP__QUALIFIER,
			EcoreFactory.eINSTANCE.createUnlimitedNaturalLiteralExp()));

		newChildDescriptors.add(createChildParameter(
			ExpressionsPackage.Literals.NAVIGATION_CALL_EXP__QUALIFIER,
			EcoreFactory.eINSTANCE.createInvalidLiteralExp()));

		newChildDescriptors.add(createChildParameter(
			ExpressionsPackage.Literals.NAVIGATION_CALL_EXP__QUALIFIER,
			EcoreFactory.eINSTANCE.createIterateExp()));

		newChildDescriptors.add(createChildParameter(
			ExpressionsPackage.Literals.NAVIGATION_CALL_EXP__QUALIFIER,
			EcoreFactory.eINSTANCE.createIteratorExp()));

		newChildDescriptors.add(createChildParameter(
			ExpressionsPackage.Literals.NAVIGATION_CALL_EXP__QUALIFIER,
			EcoreFactory.eINSTANCE.createLetExp()));

		newChildDescriptors.add(createChildParameter(
			ExpressionsPackage.Literals.NAVIGATION_CALL_EXP__QUALIFIER,
			EcoreFactory.eINSTANCE.createMessageExp()));

		newChildDescriptors.add(createChildParameter(
			ExpressionsPackage.Literals.NAVIGATION_CALL_EXP__QUALIFIER,
			EcoreFactory.eINSTANCE.createNullLiteralExp()));

		newChildDescriptors.add(createChildParameter(
			ExpressionsPackage.Literals.NAVIGATION_CALL_EXP__QUALIFIER,
			EcoreFactory.eINSTANCE.createOperationCallExp()));

		newChildDescriptors.add(createChildParameter(
			ExpressionsPackage.Literals.NAVIGATION_CALL_EXP__QUALIFIER,
			EcoreFactory.eINSTANCE.createPropertyCallExp()));

		newChildDescriptors.add(createChildParameter(
			ExpressionsPackage.Literals.NAVIGATION_CALL_EXP__QUALIFIER,
			EcoreFactory.eINSTANCE.createRealLiteralExp()));

		newChildDescriptors.add(createChildParameter(
			ExpressionsPackage.Literals.NAVIGATION_CALL_EXP__QUALIFIER,
			EcoreFactory.eINSTANCE.createStateExp()));

		newChildDescriptors.add(createChildParameter(
			ExpressionsPackage.Literals.NAVIGATION_CALL_EXP__QUALIFIER,
			EcoreFactory.eINSTANCE.createStringLiteralExp()));

		newChildDescriptors.add(createChildParameter(
			ExpressionsPackage.Literals.NAVIGATION_CALL_EXP__QUALIFIER,
			EcoreFactory.eINSTANCE.createTupleLiteralExp()));

		newChildDescriptors.add(createChildParameter(
			ExpressionsPackage.Literals.NAVIGATION_CALL_EXP__QUALIFIER,
			EcoreFactory.eINSTANCE.createTypeExp()));

		newChildDescriptors.add(createChildParameter(
			ExpressionsPackage.Literals.NAVIGATION_CALL_EXP__QUALIFIER,
			EcoreFactory.eINSTANCE.createUnspecifiedValueExp()));

		newChildDescriptors.add(createChildParameter(
			ExpressionsPackage.Literals.NAVIGATION_CALL_EXP__QUALIFIER,
			EcoreFactory.eINSTANCE.createVariableExp()));

		newChildDescriptors.add(createChildParameter(
			ExpressionsPackage.Literals.NAVIGATION_CALL_EXP__QUALIFIER,
			EcoreFactory.eINSTANCE.createOppositePropertyCallExp()));

		newChildDescriptors.add(createChildParameter(
			ExpressionsPackage.Literals.NAVIGATION_CALL_EXP__QUALIFIER,
			ExpressionsFactory.eINSTANCE.createAssociationClassCallExp()));

		newChildDescriptors.add(createChildParameter(
			ExpressionsPackage.Literals.NAVIGATION_CALL_EXP__QUALIFIER,
			ExpressionsFactory.eINSTANCE.createBooleanLiteralExp()));

		newChildDescriptors.add(createChildParameter(
			ExpressionsPackage.Literals.NAVIGATION_CALL_EXP__QUALIFIER,
			ExpressionsFactory.eINSTANCE.createCollectionLiteralExp()));

		newChildDescriptors.add(createChildParameter(
			ExpressionsPackage.Literals.NAVIGATION_CALL_EXP__QUALIFIER,
			ExpressionsFactory.eINSTANCE.createEnumLiteralExp()));

		newChildDescriptors.add(createChildParameter(
			ExpressionsPackage.Literals.NAVIGATION_CALL_EXP__QUALIFIER,
			ExpressionsFactory.eINSTANCE.createIfExp()));

		newChildDescriptors.add(createChildParameter(
			ExpressionsPackage.Literals.NAVIGATION_CALL_EXP__QUALIFIER,
			ExpressionsFactory.eINSTANCE.createIntegerLiteralExp()));

		newChildDescriptors.add(createChildParameter(
			ExpressionsPackage.Literals.NAVIGATION_CALL_EXP__QUALIFIER,
			ExpressionsFactory.eINSTANCE.createUnlimitedNaturalLiteralExp()));

		newChildDescriptors.add(createChildParameter(
			ExpressionsPackage.Literals.NAVIGATION_CALL_EXP__QUALIFIER,
			ExpressionsFactory.eINSTANCE.createInvalidLiteralExp()));

		newChildDescriptors.add(createChildParameter(
			ExpressionsPackage.Literals.NAVIGATION_CALL_EXP__QUALIFIER,
			ExpressionsFactory.eINSTANCE.createIterateExp()));

		newChildDescriptors.add(createChildParameter(
			ExpressionsPackage.Literals.NAVIGATION_CALL_EXP__QUALIFIER,
			ExpressionsFactory.eINSTANCE.createIteratorExp()));

		newChildDescriptors.add(createChildParameter(
			ExpressionsPackage.Literals.NAVIGATION_CALL_EXP__QUALIFIER,
			ExpressionsFactory.eINSTANCE.createLetExp()));

		newChildDescriptors.add(createChildParameter(
			ExpressionsPackage.Literals.NAVIGATION_CALL_EXP__QUALIFIER,
			ExpressionsFactory.eINSTANCE.createMessageExp()));

		newChildDescriptors.add(createChildParameter(
			ExpressionsPackage.Literals.NAVIGATION_CALL_EXP__QUALIFIER,
			ExpressionsFactory.eINSTANCE.createNullLiteralExp()));

		newChildDescriptors.add(createChildParameter(
			ExpressionsPackage.Literals.NAVIGATION_CALL_EXP__QUALIFIER,
			ExpressionsFactory.eINSTANCE.createOperationCallExp()));

		newChildDescriptors.add(createChildParameter(
			ExpressionsPackage.Literals.NAVIGATION_CALL_EXP__QUALIFIER,
			ExpressionsFactory.eINSTANCE.createPropertyCallExp()));

		newChildDescriptors.add(createChildParameter(
			ExpressionsPackage.Literals.NAVIGATION_CALL_EXP__QUALIFIER,
			ExpressionsFactory.eINSTANCE.createRealLiteralExp()));

		newChildDescriptors.add(createChildParameter(
			ExpressionsPackage.Literals.NAVIGATION_CALL_EXP__QUALIFIER,
			ExpressionsFactory.eINSTANCE.createStateExp()));

		newChildDescriptors.add(createChildParameter(
			ExpressionsPackage.Literals.NAVIGATION_CALL_EXP__QUALIFIER,
			ExpressionsFactory.eINSTANCE.createStringLiteralExp()));

		newChildDescriptors.add(createChildParameter(
			ExpressionsPackage.Literals.NAVIGATION_CALL_EXP__QUALIFIER,
			ExpressionsFactory.eINSTANCE.createTupleLiteralExp()));

		newChildDescriptors.add(createChildParameter(
			ExpressionsPackage.Literals.NAVIGATION_CALL_EXP__QUALIFIER,
			ExpressionsFactory.eINSTANCE.createTypeExp()));

		newChildDescriptors.add(createChildParameter(
			ExpressionsPackage.Literals.NAVIGATION_CALL_EXP__QUALIFIER,
			ExpressionsFactory.eINSTANCE.createUnspecifiedValueExp()));

		newChildDescriptors.add(createChildParameter(
			ExpressionsPackage.Literals.NAVIGATION_CALL_EXP__QUALIFIER,
			ExpressionsFactory.eINSTANCE.createVariableExp()));
	}

	/**
	 * This returns the label text for {@link org.eclipse.emf.edit.command.CreateChildCommand}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getCreateChildText(Object owner, Object feature, Object child,
			Collection<?> selection) {
		Object childFeature = feature;
		Object childObject = child;

		boolean qualify = childFeature == ExpressionsPackage.Literals.CALL_EXP__SOURCE
			|| childFeature == ExpressionsPackage.Literals.NAVIGATION_CALL_EXP__QUALIFIER;

		if (qualify) {
			return getString("_UI_CreateChild_text2", //$NON-NLS-1$
				new Object[]{getTypeText(childObject),
					getFeatureText(childFeature), getTypeText(owner)});
		}
		return super.getCreateChildText(owner, feature, child, selection);
	}

}
