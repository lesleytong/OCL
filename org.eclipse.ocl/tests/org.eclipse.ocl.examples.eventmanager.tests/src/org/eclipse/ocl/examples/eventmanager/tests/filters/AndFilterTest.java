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

import junit.textui.TestRunner;

import org.eclipse.ocl.examples.eventmanager.EventFilter;
import org.eclipse.ocl.examples.eventmanager.EventManagerFactory;

/**
 * <!-- begin-user-doc --> A test case for the model object '<em><b>And Filter</b></em>'. <!-- end-user-doc -->
 * 
 */
public class AndFilterTest extends LogicalEventFilterTest {

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     */
    public static void main(String[] args) {
        TestRunner.run(AndFilterTest.class);
    }

    /**
     * Constructs a new And Filter test case with the given name. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     */
    public AndFilterTest() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see junit.framework.TestCase#setUp()
     */
    @Override
    public void setUp() throws Exception {
        super.setUp();
        setFixture(EventManagerFactory.eINSTANCE.createAndFilterFor(trueFilter, trueFilter));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see junit.framework.TestCase#tearDown()
     */
    @Override
    public void tearDown() throws Exception{
    	super.tearDown();
        setFixture(null);
        this.falseFilter = null;
        this.trueFilter = null;
    }

    /**
     * Tests the '
     * {@link org.eclipse.ocl.examples.eventmanager.filters.AbstractEventFilter#matchesFor(org.eclipse.emf.common.notify.Notification)
     * <em>Matches For</em>}' operation. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see org.eclipse.ocl.examples.eventmanager.filters.AbstractEventFilter#matchesFor(org.eclipse.emf.common.notify.Notification)
     */
    public void testMatchesFor__NotificationTwoTrue() {
        EventFilter andFilter = EventManagerFactory.eINSTANCE.createAndFilterFor(trueFilter, trueFilter);
        assertTrue("Two true is true", andFilter.matchesFor(null));
    }

    public void testMatchesFor__NotificationTwoFalse() {
        EventFilter andFilter = EventManagerFactory.eINSTANCE.createAndFilterFor(falseFilter, falseFilter);
        assertFalse("Two false is false", andFilter.matchesFor(null));
    }

    public void testMatchesFor__Notification() {
        EventFilter andFilter = EventManagerFactory.eINSTANCE.createAndFilterFor(falseFilter, trueFilter);
        assertFalse("Two true/false is false",andFilter.matchesFor(null));
    }



	@Override
	Object getFilterCriterion1() {
		return 1;
	}

	@Override
	Object getFilterCriterion2() {
		return 2;
	}

	@Override
	EventFilter getFilterFor(Object f) {
		if(f==null){
			return EventManagerFactory.eINSTANCE.createAndFilterFor(trueFilter, trueFilter);
		}else if((Integer)f==1){
			return EventManagerFactory.eINSTANCE.createAndFilterFor(falseFilter, trueFilter);
		}else{
			return EventManagerFactory.eINSTANCE.createAndFilterFor(falseFilter, falseFilter);
		}

	}

} // AndFilterTest
