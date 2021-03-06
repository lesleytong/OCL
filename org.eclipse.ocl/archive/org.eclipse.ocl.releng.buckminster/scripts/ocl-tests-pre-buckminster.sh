#*******************************************************************************
# Copyright (c) 2013, 2016 Willink Transformations and others.
# All rights reserved. This program and the accompanying materials
# are made available under the terms of the Eclipse Public License v1.0
# which accompanies this distribution, and is available at
# http://www.eclipse.org/legal/epl-v10.html
#
# Contributors:
#     E.D.Willink - initial API and implementation
#*******************************************************************************
#!/bin/bash

rm -rf buildroot MDT-OCL.*
mkdir buildroot
:
COMPACT_BUILD_ID="${BUILD_ID//[-_]}"
COMPACT_BUILD_ID="${COMPACT_BUILD_ID:0:12}"
:
{
	cat "${WORKSPACE}/org.eclipse.ocl.git/releng/org.eclipse.ocl.releng.buckminster/releng/ocl-build.properties"

	echo
	echo "# Define the Build Type (added by Hudson job definition)"
	echo "build.type=N"

	echo
	echo "# Define the Build ID (added by Hudson job definition)"
	echo "build.id=${BUILD_TYPE}${COMPACT_BUILD_ID}"

	echo
	echo "# Define the timestamp to use for changed components (added by Hudson job definition)"
	echo "buckminster.build.timestamp=${BUILD_ID}"

	echo
	echo "# Define Hudson Build ID (added by Hudson job definition)"
	echo "hudson.build.id=${BUILD_ID}"

	echo
	echo "# Override default locations (added by Hudson job definition)"
	echo "buckminster.output.root=${WORKSPACE}/buildroot/buckminster.output"
	echo "buckminster.temp.root=${WORKSPACE}/buildroot/buckminster.temp"
	echo "eclipse.staging.area=/shared/download-staging.priv/ocl"
	echo "git.ocl.local.repository.location=${WORKSPACE}/org.eclipse.ocl.git"
	echo "git.emf.local.repository.location=${WORKSPACE}/org.eclipse.emf.git"
	echo "git.license.local.repository.location=${WORKSPACE}/org.eclipse.license.git"

	echo
	echo "# Sign the jars (added by Hudson job definition)"    
	echo "site.signing=false"

	echo
	echo "# Eclipse local download area (added by Hudson job definition"
	echo "eclipse.download=file:/home/data/httpd/download.eclipse.org"
	echo
	echo "# Required Properties for Publishing (added by Hudson job definition)"
	echo "packages.base=MDT-OCL.downloads"
	echo "tests.base=MDT-OCL.test.results"
	echo "component.name=tools"
	echo "version=6.4.0"
	echo "downloads.area=/home/data/httpd/download.eclipse.org/modeling/mdt/ocl"
	echo "doc.area=/home/data/httpd/download.eclipse.org/ocl"
	echo "javadoc.area=/home/data/httpd/download.eclipse.org/ocl/javadoc"


} > buildroot/build.properties
:
{
	echo "# Define the Build ID to use for tagging (added by Hudson job definition)"
	echo "build.id=${COMPACT_BUILD_ID}"

} > buildroot/tagging.properties
: