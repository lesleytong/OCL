/*******************************************************************************
 * Copyright (c) 2013, 2019 CEA LIST and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 * 
 * Contributors:
 *   E.D.Willink(CEA LIST) - Initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.examples.codegen.cgmodel;

import org.eclipse.emf.ecore.EOperation;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>CG Ecore Operation Call Exp</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A call of an operation using the Ecore Operation calling convention; Collections are passed as EList.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.ocl.examples.codegen.cgmodel.CGEcoreOperationCallExp#getEOperation <em>EOperation</em>}</li>
 * </ul>
 *
 * @see org.eclipse.ocl.examples.codegen.cgmodel.CGModelPackage#getCGEcoreOperationCallExp()
 * @generated
 */
public interface CGEcoreOperationCallExp extends CGOperationCallExp {
	/**
	 * Returns the value of the '<em><b>EOperation</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>EOperation</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>EOperation</em>' reference.
	 * @see #setEOperation(EOperation)
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.CGModelPackage#getCGEcoreOperationCallExp_EOperation()
	 * @generated
	 */
	EOperation getEOperation();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.examples.codegen.cgmodel.CGEcoreOperationCallExp#getEOperation <em>EOperation</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>EOperation</em>' reference.
	 * @see #getEOperation()
	 * @generated
	 */
	void setEOperation(EOperation value);

} // CGEcoreOperationCallExp
