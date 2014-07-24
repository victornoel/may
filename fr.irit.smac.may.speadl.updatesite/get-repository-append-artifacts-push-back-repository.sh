#!/bin/bash

# get the repository on the website in case we don't have it yet
rsync -azv -e "ssh vnoel@sash.irit.fr ssh" vnoel@bali:~/update-may-3/ ./update-may-3/

# append the new artifacts to it
java -jar ~/code/eclipse/eclipse-kepler/plugins/org.eclipse.equinox.launcher_1.3.0.v20130327-1440.jar -application org.eclipse.equinox.p2.publisher.FeaturesAndBundlesPublisher -metadataRepository "file:/`pwd`/update-may-3" -artifactRepository "file:/`pwd`/update-may-3" -source target/repository -compress -publishArtifacts -append

# re-generate the category (FeaturesAndBundlesPublisher don't keep them)
java -jar ~/code/eclipse/eclipse-kepler/plugins/org.eclipse.equinox.launcher_1.3.0.v20130327-1440.jar -console -consolelog -application org.eclipse.equinox.p2.publisher.CategoryPublisher -metadataRepository "file:/`pwd`/update-may-3" -categoryDefinition "file:/`pwd`/category.xml" -categoryQualifier -compress

# push back the new repository
rsync -azv -e "ssh vnoel@sash.irit.fr ssh" ./update-may-3/ vnoel@bali:~/update-may-3/

