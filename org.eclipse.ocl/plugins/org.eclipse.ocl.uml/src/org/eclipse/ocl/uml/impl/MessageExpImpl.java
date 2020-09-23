/*******************************************************************************
 * Copyright (c) 2007, 2018 IBM Corporation, Zeligsoft Inc., and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 * 
 * Contributors:
 *   IBM - Initial API and implementation
 *   Zeligsoft - Bug 207365
 *******************************************************************************/
package org.eclipse.ocl.uml.impl;

import java.util.Collection;
import java.util.Map;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.ocl.expressions.ExpressionsPackage;
import org.eclipse.ocl.expressions.OCLExpression;
import org.eclipse.ocl.expressions.operations.MessageExpOperations;
import org.eclipse.ocl.uml.MessageExp;
import org.eclipse.ocl.uml.UMLPackage;
import org.eclipse.ocl.utilities.CallingASTNode;
import org.eclipse.ocl.utilities.UtilitiesPackage;
import org.eclipse.ocl.utilities.Visitor;
import org.eclipse.uml2.uml.CallOperationAction;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.SendSignalAction;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Message Exp</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.ocl.uml.impl.MessageExpImpl#getPropertyStartPosition <em>Property Start Position</em>}</li>
 *   <li>{@link org.eclipse.ocl.uml.impl.MessageExpImpl#getPropertyEndPosition <em>Property End Position</em>}</li>
 *   <li>{@link org.eclipse.ocl.uml.impl.MessageExpImpl#getTarget <em>Target</em>}</li>
 *   <li>{@link org.eclipse.ocl.uml.impl.MessageExpImpl#getArgument <em>Argument</em>}</li>
 *   <li>{@link org.eclipse.ocl.uml.impl.MessageExpImpl#getCalledOperation <em>Called Operation</em>}</li>
 *   <li>{@link org.eclipse.ocl.uml.impl.MessageExpImpl#getSentSignal <em>Sent Signal</em>}</li>
 * </ul>
 *
 * @generated
 */
@SuppressWarnings("restriction")
public class MessageExpImpl
		extends OCLExpressionImpl
		implements MessageExp {

	/**
	 * The default value of the '{@link #getPropertyStartPosition() <em>Property Start Position</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPropertyStartPosition()
	 * @generated
	 * @ordered
	 */
	protected static final int PROPERTY_START_POSITION_EDEFAULT = -1;

	/**
	 * The cached value of the '{@link #getPropertyStartPosition() <em>Property Start Position</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPropertyStartPosition()
	 * @generated
	 * @ordered
	 */
	protected int propertyStartPosition = PROPERTY_START_POSITION_EDEFAULT;

	/**
	 * The default value of the '{@link #getPropertyEndPosition() <em>Property End Position</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPropertyEndPosition()
	 * @generated
	 * @ordered
	 */
	protected static final int PROPERTY_END_POSITION_EDEFAULT = -1;

	/**
	 * The cached value of the '{@link #getPropertyEndPosition() <em>Property End Position</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPropertyEndPosition()
	 * @generated
	 * @ordered
	 */
	protected int propertyEndPosition = PROPERTY_END_POSITION_EDEFAULT;

	/**
	 * The cached value of the '{@link #getTarget() <em>Target</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTarget()
	 * @generated
	 * @ordered
	 */
	protected OCLExpression<Classifier> target;

	/**
	 * The cached value of the '{@link #getArgument() <em>Argument</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getArgument()
	 * @generated
	 * @ordered
	 */
	protected EList<OCLExpression<Classifier>> argument;

	/**
	 * The cached value of the '{@link #getCalledOperation() <em>Called Operation</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCalledOperation()
	 * @generated
	 * @ordered
	 */
	protected CallOperationAction calledOperation;

	/**
	 * The cached value of the '{@link #getSentSignal() <em>Sent Signal</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSentSignal()
	 * @generated
	 * @ordered
	 */
	protected SendSignalAction sentSignal;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MessageExpImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return UMLPackage.Literals.MESSAGE_EXP;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getPropertyStartPosition() {
		return propertyStartPosition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPropertyStartPosition(int newPropertyStartPosition) {
		int oldPropertyStartPosition = propertyStartPosition;
		propertyStartPosition = newPropertyStartPosition;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
				UMLPackage.MESSAGE_EXP__PROPERTY_START_POSITION,
				oldPropertyStartPosition, propertyStartPosition));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getPropertyEndPosition() {
		return propertyEndPosition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPropertyEndPosition(int newPropertyEndPosition) {
		int oldPropertyEndPosition = propertyEndPosition;
		propertyEndPosition = newPropertyEndPosition;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
				UMLPackage.MESSAGE_EXP__PROPERTY_END_POSITION,
				oldPropertyEndPosition, propertyEndPosition));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OCLExpression<Classifier> getTarget() {
		return target;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetTarget(OCLExpression<Classifier> newTarget,
			NotificationChain msgs) {
		OCLExpression<Classifier> oldTarget = target;
		target = newTarget;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this,
				Notification.SET, UMLPackage.MESSAGE_EXP__TARGET, oldTarget,
				newTarget);
			if (msgs == null)
				msgs = notification;
			else
				msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTarget(OCLExpression<Classifier> newTarget) {
		if (newTarget != target) {
			NotificationChain msgs = null;
			if (target != null)
				msgs = ((InternalEObject) target).eInverseRemove(this,
					EOPPOSITE_FEATURE_BASE - UMLPackage.MESSAGE_EXP__TARGET,
					null, msgs);
			if (newTarget != null)
				msgs = ((InternalEObject) newTarget).eInverseAdd(this,
					EOPPOSITE_FEATURE_BASE - UMLPackage.MESSAGE_EXP__TARGET,
					null, msgs);
			msgs = basicSetTarget(newTarget, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
				UMLPackage.MESSAGE_EXP__TARGET, newTarget, newTarget));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<OCLExpression<Classifier>> getArgument() {
		if (argument == null) {
			argument = new EObjectContainmentEList<OCLExpression<Classifier>>(
				OCLExpression.class, this, UMLPackage.MESSAGE_EXP__ARGUMENT);
		}
		return argument;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CallOperationAction getCalledOperation() {
		return calledOperation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */

	public NotificationChain basicSetCalledOperation(
			CallOperationAction newCalledOperation, NotificationChain msgs) {
		CallOperationAction oldCalledOperation = calledOperation;
		calledOperation = newCalledOperation;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this,
				Notification.SET, UMLPackage.MESSAGE_EXP__CALLED_OPERATION,
				oldCalledOperation, newCalledOperation);
			if (msgs == null)
				msgs = notification;
			else
				msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */

	public void setCalledOperation(CallOperationAction newCalledOperation) {
		if (newCalledOperation != calledOperation) {
			NotificationChain msgs = null;
			if (calledOperation != null)
				msgs = ((InternalEObject) calledOperation)
					.eInverseRemove(this,
						EOPPOSITE_FEATURE_BASE
							- UMLPackage.MESSAGE_EXP__CALLED_OPERATION,
						null, msgs);
			if (newCalledOperation != null)
				msgs = ((InternalEObject) newCalledOperation)
					.eInverseAdd(this,
						EOPPOSITE_FEATURE_BASE
							- UMLPackage.MESSAGE_EXP__CALLED_OPERATION,
						null, msgs);
			msgs = basicSetCalledOperation(newCalledOperation, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
				UMLPackage.MESSAGE_EXP__CALLED_OPERATION, newCalledOperation,
				newCalledOperation));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SendSignalAction getSentSignal() {
		return sentSignal;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */

	public NotificationChain basicSetSentSignal(SendSignalAction newSentSignal,
			NotificationChain msgs) {
		SendSignalAction oldSentSignal = sentSignal;
		sentSignal = newSentSignal;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this,
				Notification.SET, UMLPackage.MESSAGE_EXP__SENT_SIGNAL,
				oldSentSignal, newSentSignal);
			if (msgs == null)
				msgs = notification;
			else
				msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */

	public void setSentSignal(SendSignalAction newSentSignal) {
		if (newSentSignal != sentSignal) {
			NotificationChain msgs = null;
			if (sentSignal != null)
				msgs = ((InternalEObject) sentSignal).eInverseRemove(this,
					EOPPOSITE_FEATURE_BASE
						- UMLPackage.MESSAGE_EXP__SENT_SIGNAL,
					null, msgs);
			if (newSentSignal != null)
				msgs = ((InternalEObject) newSentSignal).eInverseAdd(this,
					EOPPOSITE_FEATURE_BASE
						- UMLPackage.MESSAGE_EXP__SENT_SIGNAL,
					null, msgs);
			msgs = basicSetSentSignal(newSentSignal, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
				UMLPackage.MESSAGE_EXP__SENT_SIGNAL, newSentSignal,
				newSentSignal));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean checkOperationArguments(DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		return MessageExpOperations.checkOperationArguments(this, diagnostics,
			context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean checkSignalArguments(DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		return MessageExpOperations.checkSignalArguments(this, diagnostics,
			context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean checkTargetDefinesOperation(DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		return MessageExpOperations.checkTargetDefinesOperation(this,
			diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean checkHasOperationOrSignal(DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		return MessageExpOperations.checkHasOperationOrSignal(this, diagnostics,
			context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean checkTargetNotCollection(DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		return MessageExpOperations.checkTargetNotCollection(this, diagnostics,
			context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd,
			int featureID, NotificationChain msgs) {
		switch (featureID) {
			case UMLPackage.MESSAGE_EXP__TARGET :
				return basicSetTarget(null, msgs);
			case UMLPackage.MESSAGE_EXP__ARGUMENT :
				return ((InternalEList<?>) getArgument()).basicRemove(otherEnd,
					msgs);
			case UMLPackage.MESSAGE_EXP__CALLED_OPERATION :
				return basicSetCalledOperation(null, msgs);
			case UMLPackage.MESSAGE_EXP__SENT_SIGNAL :
				return basicSetSentSignal(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case UMLPackage.MESSAGE_EXP__PROPERTY_START_POSITION :
				return getPropertyStartPosition();
			case UMLPackage.MESSAGE_EXP__PROPERTY_END_POSITION :
				return getPropertyEndPosition();
			case UMLPackage.MESSAGE_EXP__TARGET :
				return getTarget();
			case UMLPackage.MESSAGE_EXP__ARGUMENT :
				return getArgument();
			case UMLPackage.MESSAGE_EXP__CALLED_OPERATION :
				return getCalledOperation();
			case UMLPackage.MESSAGE_EXP__SENT_SIGNAL :
				return getSentSignal();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case UMLPackage.MESSAGE_EXP__PROPERTY_START_POSITION :
				setPropertyStartPosition((Integer) newValue);
				return;
			case UMLPackage.MESSAGE_EXP__PROPERTY_END_POSITION :
				setPropertyEndPosition((Integer) newValue);
				return;
			case UMLPackage.MESSAGE_EXP__TARGET :
				setTarget((OCLExpression<Classifier>) newValue);
				return;
			case UMLPackage.MESSAGE_EXP__ARGUMENT :
				getArgument().clear();
				getArgument().addAll(
					(Collection<? extends OCLExpression<Classifier>>) newValue);
				return;
			case UMLPackage.MESSAGE_EXP__CALLED_OPERATION :
				setCalledOperation((CallOperationAction) newValue);
				return;
			case UMLPackage.MESSAGE_EXP__SENT_SIGNAL :
				setSentSignal((SendSignalAction) newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case UMLPackage.MESSAGE_EXP__PROPERTY_START_POSITION :
				setPropertyStartPosition(PROPERTY_START_POSITION_EDEFAULT);
				return;
			case UMLPackage.MESSAGE_EXP__PROPERTY_END_POSITION :
				setPropertyEndPosition(PROPERTY_END_POSITION_EDEFAULT);
				return;
			case UMLPackage.MESSAGE_EXP__TARGET :
				setTarget((OCLExpression<Classifier>) null);
				return;
			case UMLPackage.MESSAGE_EXP__ARGUMENT :
				getArgument().clear();
				return;
			case UMLPackage.MESSAGE_EXP__CALLED_OPERATION :
				setCalledOperation((CallOperationAction) null);
				return;
			case UMLPackage.MESSAGE_EXP__SENT_SIGNAL :
				setSentSignal((SendSignalAction) null);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case UMLPackage.MESSAGE_EXP__PROPERTY_START_POSITION :
				return propertyStartPosition != PROPERTY_START_POSITION_EDEFAULT;
			case UMLPackage.MESSAGE_EXP__PROPERTY_END_POSITION :
				return propertyEndPosition != PROPERTY_END_POSITION_EDEFAULT;
			case UMLPackage.MESSAGE_EXP__TARGET :
				return target != null;
			case UMLPackage.MESSAGE_EXP__ARGUMENT :
				return argument != null && !argument.isEmpty();
			case UMLPackage.MESSAGE_EXP__CALLED_OPERATION :
				return calledOperation != null;
			case UMLPackage.MESSAGE_EXP__SENT_SIGNAL :
				return sentSignal != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eBaseStructuralFeatureID(int derivedFeatureID,
			Class<?> baseClass) {
		if (baseClass == CallingASTNode.class) {
			switch (derivedFeatureID) {
				case UMLPackage.MESSAGE_EXP__PROPERTY_START_POSITION :
					return UtilitiesPackage.CALLING_AST_NODE__PROPERTY_START_POSITION;
				case UMLPackage.MESSAGE_EXP__PROPERTY_END_POSITION :
					return UtilitiesPackage.CALLING_AST_NODE__PROPERTY_END_POSITION;
				default :
					return -1;
			}
		}
		if (baseClass == org.eclipse.ocl.expressions.MessageExp.class) {
			switch (derivedFeatureID) {
				case UMLPackage.MESSAGE_EXP__TARGET :
					return ExpressionsPackage.MESSAGE_EXP__TARGET;
				case UMLPackage.MESSAGE_EXP__ARGUMENT :
					return ExpressionsPackage.MESSAGE_EXP__ARGUMENT;
				case UMLPackage.MESSAGE_EXP__CALLED_OPERATION :
					return ExpressionsPackage.MESSAGE_EXP__CALLED_OPERATION;
				case UMLPackage.MESSAGE_EXP__SENT_SIGNAL :
					return ExpressionsPackage.MESSAGE_EXP__SENT_SIGNAL;
				default :
					return -1;
			}
		}
		return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eDerivedStructuralFeatureID(int baseFeatureID,
			Class<?> baseClass) {
		if (baseClass == CallingASTNode.class) {
			switch (baseFeatureID) {
				case UtilitiesPackage.CALLING_AST_NODE__PROPERTY_START_POSITION :
					return UMLPackage.MESSAGE_EXP__PROPERTY_START_POSITION;
				case UtilitiesPackage.CALLING_AST_NODE__PROPERTY_END_POSITION :
					return UMLPackage.MESSAGE_EXP__PROPERTY_END_POSITION;
				default :
					return -1;
			}
		}
		if (baseClass == org.eclipse.ocl.expressions.MessageExp.class) {
			switch (baseFeatureID) {
				case ExpressionsPackage.MESSAGE_EXP__TARGET :
					return UMLPackage.MESSAGE_EXP__TARGET;
				case ExpressionsPackage.MESSAGE_EXP__ARGUMENT :
					return UMLPackage.MESSAGE_EXP__ARGUMENT;
				case ExpressionsPackage.MESSAGE_EXP__CALLED_OPERATION :
					return UMLPackage.MESSAGE_EXP__CALLED_OPERATION;
				case ExpressionsPackage.MESSAGE_EXP__SENT_SIGNAL :
					return UMLPackage.MESSAGE_EXP__SENT_SIGNAL;
				default :
					return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public String toString() {
		return super.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	@SuppressWarnings("unchecked")
	public <T, U extends Visitor<T, ?, ?, ?, ?, ?, ?, ?, ?, ?>> T accept(U v) {
		return ((Visitor<T, Classifier, ?, ?, ?, ?, ?, CallOperationAction, SendSignalAction, ?>) v)
			.visitMessageExp(this);
	}

} //MessageExpImpl
