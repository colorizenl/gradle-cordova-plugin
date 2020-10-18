//-----------------------------------------------------------------------------
// Gradle Cordova Plugin
// Copyright 2010-2020 Colorize
// Apache license (http://www.apache.org/licenses/LICENSE-2.0)
//-----------------------------------------------------------------------------

package nl.colorize.gradle.cordova;

import org.gradle.api.Plugin;
import org.gradle.api.Project;
import org.gradle.api.plugins.ExtensionContainer;
import org.gradle.api.tasks.TaskContainer;

public class CordovaPlugin implements Plugin<Project> {

    @Override
    public void apply(Project project) {
        ExtensionContainer ext = project.getExtensions();
        ext.create("cordova", CordovaExt.class);

        TaskContainer tasks = project.getTasks();
        tasks.create("buildCordova", BuildCordovaTask.class);
        tasks.create("simulateIOS", SimulateIOSTask.class);
        tasks.create("simulateAndroid", SimulateAndroidTask.class);
    }
}
