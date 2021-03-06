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
package org.eclipse.ocl.examples.eventmanager.filters;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.ocl.examples.eventmanager.framework.EventManagerTableBased;

/**
 * The Containment filter matches a notification if its
 * {@link Notification#getFeature()} is an {@link EReference} and
 * {@link EReference#isContainment()} is true, or if the
 * {@link Notification#getNotifier()} is not an {@link EObject}, so it might be
 * a {@link ResourceSet} or a {@link Resource}.
 * 
 * @author Philipp Berger, Axel Uhl
 * 
 */
public class ContainmentFilter extends AbstractEventFilter {

    public ContainmentFilter(boolean negated) {
        super(negated);
    }
    
    public boolean matchesFor(Notification event) {
        if (event.getFeature() instanceof EReference) {
            return ((EReference) event.getFeature()).isContainment();
        } else if (!(event.getNotifier() instanceof EObject)) {
            return true;
        }
        return false;

    }

    @Override
    public int hashCode() {
        return "ContainmentFilterImpl".hashCode() + 31*(isNegated() ? 43 : 0);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        return isNegated() == ((AbstractEventFilter) obj).isNegated();
    }

    @Override
    public ContainmentFilter clone() {
        return new ContainmentFilter(isNegated());

    }

    /**
     * This method will only returns true, the logic is moved to the {@link EventManagerTableBased}
     * @see org.eclipse.ocl.examples.eventmanager.filters.AbstractEventFilter#getFilterCriterion()
     */
    @Override
    public Object getFilterCriterion() {
        return true;
    }
    @Override
    public String toString() {
    	return (isNegated()?"negated ":"") + "containment";
    }
} // ContainmentFilterImpl
