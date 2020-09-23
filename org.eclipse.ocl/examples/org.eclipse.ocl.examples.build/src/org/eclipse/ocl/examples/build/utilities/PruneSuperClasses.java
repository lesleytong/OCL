/*******************************************************************************
 * Copyright (c) 2010, 2018 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.examples.build.utilities;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.ECollections;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.mwe.core.WorkflowContext;
import org.eclipse.emf.mwe.core.issues.Issues;
import org.eclipse.emf.mwe.core.lib.WorkflowComponentWithModelSlot;
import org.eclipse.emf.mwe.core.monitor.ProgressMonitor;
import org.eclipse.jdt.annotation.NonNull;

/**
 * Alphabeticizes a designated <tt>modelSlot</tt> so that primitive types
 * appear before enumerations before classes before associations, each
 * in alphabetical order.
 */
public class PruneSuperClasses extends WorkflowComponentWithModelSlot
{
	private static class Orderer implements Comparator<EClass>
	{
		private Map<String, @NonNull Integer> ordering = new HashMap<String, @NonNull Integer>();

		public Orderer(List<String> orderedNames, List<EClass> otherClasses) {
			int order = 0;
			for (String orderedName : orderedNames) {
				ordering.put(orderedName, order++);
			}
			for (EClass otherClass : otherClasses) {
				String otherName = otherClass.getName();
				if (!ordering.containsKey(otherName)) {
					ordering.put(otherName, order++);
				}
			}
		}

		@Override
		public int compare(EClass o1, EClass o2) {
			String n1 = o1.getName();
			String n2 = o2.getName();
			Integer i1 = ordering.get(n1);
			Integer i2 = ordering.get(n2);
			assert (i1 !=null) && (i2 != null);
			return i1 - i2;
		}
		
	}
	
	private Logger log = Logger.getLogger(getClass());
	private List<String> orderedNames = new ArrayList<String>();

	@Override
	public void invokeInternal(WorkflowContext ctx, ProgressMonitor arg1, Issues arg2) {
		Resource resource = (Resource) ctx.get(getModelSlot());
		log.info("Pruning Super Classes in '" + resource.getURI() + "'");
		orderedNames.add("Feature");
		orderedNames.add("TypedElement");
		orderedNames.add("Type");
		orderedNames.add("NamedElement");
		orderedNames.add("Namespace");
		orderedNames.add("TemplateableElement");
		pruneSuperClasses(resource.getContents());
	}

	public void pruneSuperClasses(List<? extends EObject> eObjects) {
		for (EObject eObject : eObjects) {
			if (eObject instanceof EPackage) {
				EPackage ePackage = (EPackage) eObject;
				for (EClassifier eClassifier : ePackage.getEClassifiers()) {
					if (eClassifier instanceof EClass) {
						EClass eClass = (EClass) eClassifier;
						EList<EClass> eSuperTypes = eClass.getESuperTypes();
						List<EClass> superTypes = new ArrayList<EClass>(eSuperTypes);
						Set<EClass> superSuperTypes = new HashSet<EClass>();
						for (EClass superType : superTypes) {
							List<EClass> eAllSuperTypes = superType.getEAllSuperTypes();
							assert eAllSuperTypes != null;
							superSuperTypes.addAll(eAllSuperTypes);
						}
						superTypes.removeAll(superSuperTypes);
						Orderer orderer = new Orderer(orderedNames, superTypes);
						Collections.sort(superTypes, orderer);
						ECollections.setEList(eSuperTypes, superTypes);
					}
				}
				pruneSuperClasses(ePackage.getESubpackages());
			}
		}
	}
}
