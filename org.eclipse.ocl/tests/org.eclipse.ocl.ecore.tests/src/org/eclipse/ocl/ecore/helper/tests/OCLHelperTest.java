/*******************************************************************************
 * Copyright (c) 2005, 2018 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   IBM - Initial API and implementation
 *******************************************************************************/

package org.eclipse.ocl.ecore.helper.tests;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.ocl.ecore.Constraint;
import org.eclipse.ocl.ecore.EcoreEnvironmentFactory;
import org.eclipse.ocl.ecore.OCL;
import org.eclipse.ocl.helper.OCLHelper;

/**
 * Tests the OCL Helper API.
 * 
 * @author Chris McGee (cmcgee)
 */
public class OCLHelperTest
	extends AbstractTestSuite {
	
	public void testHelperCreation() {
		OCLHelper<EClassifier, EOperation, EStructuralFeature, Constraint> helper1 =
			OCL.newInstance().createOCLHelper();
		assertNotNull(helper1);
		
		
		OCLHelper<EClassifier, EOperation, EStructuralFeature, Constraint> helper2 =
			OCL.newInstance(EcoreEnvironmentFactory.INSTANCE).createOCLHelper();
		assertNotNull(helper2);
		
		assertNotSame(helper1, helper2);
	}
}
