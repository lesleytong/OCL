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
package data.classes;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Platform Specific Implementation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link data.classes.PlatformSpecificImplementation#getTargetPlatform <em>Target Platform</em>}</li>
 *   <li>{@link data.classes.PlatformSpecificImplementation#getImplementation <em>Implementation</em>}</li>
 * </ul>
 * </p>
 *
 * @see data.classes.ClassesPackage#getPlatformSpecificImplementation()
 * @model
 * @generated
 */
public interface PlatformSpecificImplementation extends EObject {
	/**
	 * Returns the value of the '<em><b>Target Platform</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target Platform</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target Platform</em>' attribute.
	 * @see #setTargetPlatform(String)
	 * @see data.classes.ClassesPackage#getPlatformSpecificImplementation_TargetPlatform()
	 * @model unique="false" required="true" ordered="false"
	 * @generated
	 */
	String getTargetPlatform();

	/**
	 * Sets the value of the '{@link data.classes.PlatformSpecificImplementation#getTargetPlatform <em>Target Platform</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target Platform</em>' attribute.
	 * @see #getTargetPlatform()
	 * @generated
	 */
	void setTargetPlatform(String value);

	/**
	 * Returns the value of the '<em><b>Implementation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Implementation</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Implementation</em>' attribute.
	 * @see #setImplementation(String)
	 * @see data.classes.ClassesPackage#getPlatformSpecificImplementation_Implementation()
	 * @model unique="false" required="true" ordered="false"
	 * @generated
	 */
	String getImplementation();

	/**
	 * Sets the value of the '{@link data.classes.PlatformSpecificImplementation#getImplementation <em>Implementation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Implementation</em>' attribute.
	 * @see #getImplementation()
	 * @generated
	 */
	void setImplementation(String value);

} // PlatformSpecificImplementation
