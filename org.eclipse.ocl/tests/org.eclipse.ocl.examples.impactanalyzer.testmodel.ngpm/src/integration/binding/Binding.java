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
package integration.binding;

import dataaccess.expressions.Expression;

import modelmanagement.NamedElement;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Binding</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link integration.binding.Binding#getFunction <em>Function</em>}</li>
 * </ul>
 * </p>
 *
 * @see integration.binding.BindingPackage#getBinding()
 * @model abstract="true"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL FunctionExpressionHasFunctionType='self.function.getType().oclIsKindOf(data::classes::FunctionSignatureTypeDefinition)'"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore constraints='FunctionExpressionHasFunctionType'"
 * @generated
 */
public interface Binding extends NamedElement {
	/**
	 * Returns the value of the '<em><b>Function</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Function</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Function</em>' containment reference.
	 * @see #setFunction(Expression)
	 * @see integration.binding.BindingPackage#getBinding_Function()
	 * @model containment="true" resolveProxies="true" required="true"
	 * @generated
	 */
	Expression getFunction();

	/**
	 * Sets the value of the '{@link integration.binding.Binding#getFunction <em>Function</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Function</em>' containment reference.
	 * @see #getFunction()
	 * @generated
	 */
	void setFunction(Expression value);

} // Binding
