/*******************************************************************************
 * Copyright (c) 2010, 2018 SAP AG and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   Axel Uhl - Initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.ecore.parser;

import org.eclipse.ocl.ecore.OppositePropertyCallExp;
import org.eclipse.ocl.ecore.utilities.OCLFactoryWithHiddenOpposite;
import org.eclipse.ocl.utilities.OCLFactory;


/**
 * @since 3.1
 */
public class OCLFactoryWithHistory
		extends org.eclipse.ocl.parser.OCLFactoryWithHistory
		implements OCLFactoryWithHiddenOpposite {

	public OCLFactoryWithHistory(OCLFactory delegate) {
		super(delegate);
	}

    public OppositePropertyCallExp createOppositePropertyCallExp() {
    	if (delegate instanceof OCLFactoryWithHiddenOpposite) {
    		return record(((OCLFactoryWithHiddenOpposite) delegate).createOppositePropertyCallExp());
    	} else {
    		return null;
    	}
    }

}
