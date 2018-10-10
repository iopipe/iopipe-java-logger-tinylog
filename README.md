# IOpipe Logger Adapter for TinyLog (Java)

[![Download](https://api.bintray.com/packages/iopipe/iopipe-logger-tinylog/iopipe-logger-tinylog/images/download.svg) ](https://bintray.com/iopipe/iopipe-logger-tinylog/iopipe-logger-tinylog/_latestVersion)[![CircleCI](https://circleci.com/gh/iopipe/iopipe-java-logger-tinylog.svg?style=svg&circle-token=b9a08049964f555f38ab316ba535369aa5fe8252)](https://circleci.com/gh/iopipe/iopipe-java-logger-tinylog)[![Javadocs](https://www.javadoc.io/badge/com.iopipe/iopipe-logger-tinylog.svg)](https://www.javadoc.io/doc/com.iopipe/iopipe-logger-tinylog)

Support for [TinyLog](https://www.tinylog.org/) using the
[IOpipe](https://www.iopipe.com/) Logger Plugin. This plugin is to be used
with the [IOpipe Java Agent](https://github.com/iopipe/iopipe-java).

It is licensed under the Apache 2.0.

# Building With The Adapter

Your `pom.xml` file may be modified to include the following dependency:

```xml
<dependency>
  <groupId>com.iopipe</groupId>
  <artifactId>iopipe-logger-tinylog</artifactId>
</dependency>
```

Note that if you are using multiple TinyLog plugins from multiple repositories
you will need to merge the services, this can be done by following the
[service resource transformer for shading](https://maven.apache.org/plugins/maven-shade-plugin/examples/resource-transformers.html#ServicesResourceTransformer) documentation.

# Configuration

The adapter is configured using the same method as the documentation for
[Configuring TinyLog](https://tinylog.org/configuration).

## `tinylog.properties` Resource

This resource will exist at the base of the JAR and it should contain the
following:

```
tinylog.writer = iopipe
```

This is the recommended way to use the logger.

## System properties

If you are able to set system properties for the Java virtual machine you may
use the following, note that this will likely not work if properties are set
at run-time:

```
-Dtinylog.writer=iopipe
```

## Manual Initialization From Java Code

If you wish to manually initialize the logger from your Java code, you may
use the following imports:

```java
import com.iopipe.logger.tinylog.IOpipeWriter;
import org.pmw.tinylog.Configurator;
```

Then in a static initializer or appropriate method you may then use:

```java
Configurator.currentConfig().writer(new IOpipeWriter()).activate();
```

