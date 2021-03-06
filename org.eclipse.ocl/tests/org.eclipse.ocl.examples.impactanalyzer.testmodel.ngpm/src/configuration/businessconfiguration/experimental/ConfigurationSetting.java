/*******************************************************************************
 * Copyright (c) 2009, 2018 SAP AG and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 * 
 * Contributors:
 *     SAP AG - initial API and implementation
 ******************************************************************************
 */
package configuration.businessconfiguration.experimental;

import dataaccess.expressions.Expression;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Configuration Setting</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link configuration.businessconfiguration.experimental.ConfigurationSetting#getEntity <em>Entity</em>}</li>
 *   <li>{@link configuration.businessconfiguration.experimental.ConfigurationSetting#getValue <em>Value</em>}</li>
 * </ul>
 * </p>
 *
 * @see configuration.businessconfiguration.experimental.ExperimentalPackage#getConfigurationSetting()
 * @model
 * @generated
 */
public interface ConfigurationSetting extends EObject {
	/**
	 * Returns the value of the '<em><b>Entity</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Entity</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Entity</em>' reference.
	 * @see #setEntity(ConfigurationEntity)
	 * @see configuration.businessconfiguration.experimental.ExperimentalPackage#getConfigurationSetting_Entity()
	 * @model required="true"
	 * @generated
	 */
	ConfigurationEntity getEntity();

	/**
	 * Sets the value of the '{@link configuration.businessconfiguration.experimental.ConfigurationSetting#getEntity <em>Entity</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Entity</em>' reference.
	 * @see #getEntity()
	 * @generated
	 */
	void setEntity(ConfigurationEntity value);

	/**
	 * Returns the value of the '<em><b>Value</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Value</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Value</em>' reference.
	 * @see #setValue(Expression)
	 * @see configuration.businessconfiguration.experimental.ExperimentalPackage#getConfigurationSetting_Value()
	 * @model required="true"
	 * @generated
	 */
	Expression getValue();

	/**
	 * Sets the value of the '{@link configuration.businessconfiguration.experimental.ConfigurationSetting#getValue <em>Value</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value</em>' reference.
	 * @see #getValue()
	 * @generated
	 */
	void setValue(Expression value);

} // ConfigurationSetting
