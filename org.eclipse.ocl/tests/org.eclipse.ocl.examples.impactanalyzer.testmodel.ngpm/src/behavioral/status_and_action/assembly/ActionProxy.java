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
package behavioral.status_and_action.assembly;

import behavioral.status_and_action.design.AbstractAction;
import behavioral.status_and_action.design.Action;

import data.classes.Signature;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Action Proxy</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link behavioral.status_and_action.assembly.ActionProxy#getAction <em>Action</em>}</li>
 * </ul>
 * </p>
 *
 * @see behavioral.status_and_action.assembly.AssemblyPackage#getActionProxy()
 * @model
 * @generated
 */
public interface ActionProxy extends AbstractAction, Action, ConnectableElement {
	/**
	 * Returns the value of the '<em><b>Action</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Action</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Action</em>' reference.
	 * @see #setAction(Signature)
	 * @see behavioral.status_and_action.assembly.AssemblyPackage#getActionProxy_Action()
	 * @model annotation="http://schema.omg.org/spec/MOF/2.0/emof.xml Property.oppositeRoleName='proxy'"
	 * @generated
	 */
	Signature getAction();

	/**
	 * Sets the value of the '{@link behavioral.status_and_action.assembly.ActionProxy#getAction <em>Action</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Action</em>' reference.
	 * @see #getAction()
	 * @generated
	 */
	void setAction(Signature value);

} // ActionProxy
