// CHECKSTYLE:OFF Just examples
package org.fuin.utils4maven;

import java.io.File;
import java.io.IOException;

import org.jboss.shrinkwrap.resolver.api.maven.Maven;
import org.jboss.shrinkwrap.resolver.api.maven.MavenVersionRangeResult;
import org.jboss.shrinkwrap.resolver.api.maven.coordinate.MavenCoordinate;

/**
 * Some examples how to use JBoss ShrinkWrap resolver classes.
 */
public class ResolverExamples {

    public static void main(String[] args) throws IOException {

        // Read all available versions
        
        final MavenVersionRangeResult versionRangeResult = Maven.resolver()
                .resolveVersionRange("org.fuin:utils4j:[0.1.0,)");

        System.out.println("------------------------------");

        for (final MavenCoordinate coord : versionRangeResult.getVersions()) {
            System.out.println(coord);
        }

        // Resolve the JAR
        
        System.out.println("------------------------------");
        
        final File[] files = Maven.resolver().resolve("org.fuin:utils4j:0.7.0")
                .withTransitivity().asFile();
        for (final File file : files) {
            System.out.println(file);
        }

        System.out.println("------------------------------");


    }

}
//CHECKSTYLE:ON
