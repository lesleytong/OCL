/*******************************************************************************
 * Copyright (c) 2010, 2018 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.pivot;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Feature Call Exp</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.ocl.pivot.FeatureCallExp#isIsPre <em>Is Pre</em>}</li>
 * </ul>
 *
 * @see org.eclipse.ocl.pivot.PivotPackage#getFeatureCallExp()
 * @generated
 */
public interface FeatureCallExp
		extends CallExp {

	/**
	 * Returns the value of the '<em><b>Is Pre</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Pre</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Pre</em>' attribute.
	 * @see #setIsPre(boolean)
	 * @see org.eclipse.ocl.pivot.PivotPackage#getFeatureCallExp_IsPre()
	 * @generated
	 */
	boolean isIsPre();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.pivot.FeatureCallExp#isIsPre <em>Is Pre</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Pre</em>' attribute.
	 * @see #isIsPre()
	 * @generated
	 */
	void setIsPre(boolean value);
} // FeatureCallExp
