# utils4maven
Utilities for Maven development

The library does not contain much content yet - Except:

| Content | Description |
| ------------- | ----------- |
| [MavenPomReader](https://github.com/fuinorg/utils4maven/blob/master/src/main/java/org/fuin/utils4maven/MavenPomReader.java) | Loads the Maven POMs for an artifact and merges the content with all parent POMs. See [Example](https://github.com/fuinorg/utils4maven/blob/master/src/test/java/org/fuin/utils4maven/MavenPomReaderTest.java).|
| [MavenLogger*](https://github.com/fuinorg/utils4maven/tree/master/src/main/java/org/slf4j/impl) | Implementation of [org.slf4j.Logger](http://www.slf4j.org/api/org/slf4j/Logger.html) transforming SLF4J messages to Maven log messages. Credits: Yegor Bugayenko |

###Snapshots

Snapshots can be found on the [OSS Sonatype Snapshots Repository](http://oss.sonatype.org/content/repositories/snapshots/org/fuin "Snapshot Repository"). 

Add the following to your [.m2/settings.xml](http://maven.apache.org/ref/3.2.1/maven-settings/settings.html "Reference configuration") to enable snapshots in your Maven build:

```xml
<repository>
    <id>sonatype.oss.snapshots</id>
    <name>Sonatype OSS Snapshot Repository</name>
    <url>http://oss.sonatype.org/content/repositories/snapshots</url>
    <releases>
        <enabled>false</enabled>
    </releases>
    <snapshots>
        <enabled>true</enabled>
    </snapshots>
</repository>
```
