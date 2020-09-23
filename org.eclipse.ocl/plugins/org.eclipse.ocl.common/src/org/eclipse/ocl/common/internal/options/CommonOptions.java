/*******************************************************************************
 * Copyright (c) 2012, 2018 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.common.internal.options;

import org.eclipse.ocl.common.OCLCommon;
import org.eclipse.ocl.common.OCLConstants;
import org.eclipse.ocl.common.delegate.VirtualDelegateMapping;
import org.eclipse.ocl.common.internal.preferences.EnumerationPreference;

public class CommonOptions {

    public static final EnumerationPreference<CodeGenerationMode> CODE_GENERATION_MODE = new EnumerationPreference<CodeGenerationMode>(
    		OCLConstants.PLUGIN_ID, "code.generation.mode", CodeGenerationMode.DELEGATED, CodeGenerationMode.class); //$NON-NLS-1$

    public static final VirtualDelegateMapping DEFAULT_DELEGATION_MODE = new VirtualDelegateMapping(
    		OCLConstants.PLUGIN_ID, "default.delegation.mode", OCLCommon.getDefaultDefaultDelegationMode()); //$NON-NLS-1$

    /**
     * Not instantiable by clients.
     */
    private CommonOptions() {
        super();
    }
}
