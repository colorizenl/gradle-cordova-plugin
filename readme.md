Cordova plugin for Gradle
=========================

Plugin to create [Cordova](https://cordova.apache.org) applications for iOS, Android, and Mac from
a Gradle build. The applications are generated from scratch, the intended usage is that the Cordova
applications are not added to the repository, and are instead treated like build artefacts.

Prerequisites
-------------

- [Java JDK](http://java.oracle.com) both 8 and 11+
- [Cordova](https://cordova.apache.org)
- [Xcode](https://developer.apple.com/xcode/)
- [Android SDK](https://developer.android.com/sdk/index.html)

Cordova *only* supports Java 8, it does not support newer versions. The plugin will use the
environment variable `JAVA8_HOME` to locate the Java 8 JDK. This allows a newer Java version to
be used for the build itself, while still supporting Cordova Java 8.

Usage
-----

The plugin is available from the [Gradle plugin registry](https://plugins.gradle.org). Adding the
plugin to the build is done by adding the following to `build.gradle`:

    plugins {
        id "nl.colorize.gradle.cordova" version "2020.1.7"
    }
    
The plugin adds a `buildCordova` task that will generate the applications based on the 
configuration. Note that this task is *not* added to any standard tasks such as `assemble` by
default.

The plugin can be configured using the `cordova` block:

    cordova {
        webAppDir = "src"
        appId = "nl.colorize.test"
        appName = "Example"
        version = "1.0.0"
        icon = "icon.png"
        buildJson = "/shared/cordova-config/build.json"
    } 

The following configuration options are available:

| Name      | Required | Description                                                          |
|-----------|----------|----------------------------------------------------------------------|
| webAppDir | yes      | Directory containing the web application files.                      |
| outputDir | no       | Output directory for the generated apps, default is `build/cordova`. |
| platforms | no       | Comma-separated list of platforms, default is `ios,android,osx`.     |
| appId     | yes      | Application identifier, e.g. `nl.colorize.test`.                     |
| appName   | yes      | Application display name.                                            |
| version   | yes      | Application version in the format x.y.z.                             |
| icon      | yes      | Application icon, should be a 1024x1024 PNG image.                   |
| buildJson | yes      | Location of the Cordova `build.json` configuration file.             |
| dist      | no       | Build distribution type, either 'release' (default) or 'debug'.      |

In addition to the actual build, the plugin also adds two convenience tasks, `simulateIOS` and
`simulateAndroid`, to start an iOS/Android simulator for the generated Cordova apps.

Build instructions
------------------

Building the plugin itself can only be done on Mac OS. It also requires the following:

- [Java JDK](http://java.oracle.com) 11+
- [Gradle](http://gradle.org)

The following Gradle build tasks are available:

- `gradle clean` cleans the build directory
- `gradle assemble` creates the JAR file for distribution
- `gradle test` runs all unit tests
- `gradle coverage` runs all unit tests and reports on test coverage
- `gradle publishPlugins` publishes the plugin to the Gradle plugin portal (requires account)
  
License
-------

Copyright 2010-2020 Colorize

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

        http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
