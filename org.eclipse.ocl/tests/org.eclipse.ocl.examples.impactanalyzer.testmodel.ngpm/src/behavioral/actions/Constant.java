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
package behavioral.actions;

import dataaccess.expressions.collectionexpressions.Iterate;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Constant</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A constant always has an initial value defined and cannot be changed after that initial assignment anymore.
 * 
 * If a constant has no initExpression assigned, it's type needs to support a lower multiplicity of 0, and the value of the constant will be an empty multi-object.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link behavioral.actions.Constant#getIterate <em>Iterate</em>}</li>
 * </ul>
 * </p>
 *
 * @see behavioral.actions.ActionsPackage#getConstant()
 * @model annotation="http://www.eclipse.org/emf/2002/Ecore/OCL InitExpressionTypeMustMatchVariableType='self.initExpression->notEmpty() implies self.initExpression.getType().conformsTo(self.getType())'"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore constraints='InitExpressionTypeMustMatchVariableType'"
 * @generated
 */
public interface Constant extends NamedValueWithOptionalInitExpression {
	/**
	 * Returns the value of the '<em><b>Iterate</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link dataaccess.expressions.collectionexpressions.Iterate#getAccumulator <em>Accumulator</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Iterate</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Iterate</em>' container reference.
	 * @see #setIterate(Iterate)
	 * @see behavioral.actions.ActionsPackage#getConstant_Iterate()
	 * @see dataaccess.expressions.collectionexpressions.Iterate#getAccumulator
	 * @model opposite="accumulator"
	 * @generated
	 */
	Iterate getIterate();

	/**
	 * Sets the value of the '{@link behavioral.actions.Constant#getIterate <em>Iterate</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Iterate</em>' container reference.
	 * @see #getIterate()
	 * @generated
	 */
	void setIterate(Iterate value);

} // Constant
