/*******************************************************************************
 * Copyright (c) 2009, 2018 SAP AG and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 * 
 * Contributors:
 *     SAP AG - initial API and implementation
 ******************************************************************************/
package org.eclipse.ocl.examples.eventmanager.tests.filters;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.ocl.examples.eventmanager.filters.AbstractEventFilter;

public abstract class LogicalEventFilterTest extends EventFilterTest {
    protected AbstractEventFilter trueFilter;
    protected AbstractEventFilter falseFilter;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see junit.framework.TestCase#setUp()
     */
    @Override
    public void setUp() throws Exception{
        super.setUp();
        this.trueFilter = new TrueFilter();
        this.falseFilter = new FalseFilter();
    }
    @Override
    public Notification[] giveMatchingNotifications() {
    	throw new UnsupportedOperationException("Not applicable for this filter type");
    }
    @Override
    public Notification giveNotMatchingNotifcation() {
    	throw new UnsupportedOperationException("Not applicable for this filter type");
    }
    @Override
    public AbstractEventFilter giveTestFilter() {
    	throw new UnsupportedOperationException("Not applicable for this filter type");
    }
   /**
    * negation not supported by {@link LogicalEventFilter}
    */
    @Override
    public void testNegatedForEqualsAndHashCode() {
    	
    }
}
