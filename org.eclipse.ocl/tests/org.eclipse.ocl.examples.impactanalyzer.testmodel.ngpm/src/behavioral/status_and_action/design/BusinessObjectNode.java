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
package behavioral.status_and_action.design;

import modelmanagement.NamedElement;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Business Object Node</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link behavioral.status_and_action.design.BusinessObjectNode#getVariables <em>Variables</em>}</li>
 *   <li>{@link behavioral.status_and_action.design.BusinessObjectNode#getActions <em>Actions</em>}</li>
 * </ul>
 * </p>
 *
 * @see behavioral.status_and_action.design.DesignPackage#getBusinessObjectNode()
 * @model
 * @generated
 */
public interface BusinessObjectNode extends NamedElement {
	/**
	 * Returns the value of the '<em><b>Variables</b></em>' containment reference list.
	 * The list contents are of type {@link behavioral.status_and_action.design.StatusVariable}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Variables</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Variables</em>' containment reference list.
	 * @see behavioral.status_and_action.design.DesignPackage#getBusinessObjectNode_Variables()
	 * @model containment="true" resolveProxies="true"
	 *        annotation="http://schema.omg.org/spec/MOF/2.0/emof.xml Property.oppositeRoleName='node'"
	 * @generated
	 */
	EList<StatusVariable> getVariables();

	/**
	 * Returns the value of the '<em><b>Actions</b></em>' containment reference list.
	 * The list contents are of type {@link behavioral.status_and_action.design.Action}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Actions</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Actions</em>' containment reference list.
	 * @see behavioral.status_and_action.design.DesignPackage#getBusinessObjectNode_Actions()
	 * @model containment="true" resolveProxies="true"
	 *        annotation="http://schema.omg.org/spec/MOF/2.0/emof.xml Property.oppositeRoleName='node'"
	 * @generated
	 */
	EList<Action> getActions();

} // BusinessObjectNode
