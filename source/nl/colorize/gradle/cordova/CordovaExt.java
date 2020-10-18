//-----------------------------------------------------------------------------
// Gradle Cordova Plugin
// Copyright 2010-2020 Colorize
// Apache license (http://www.apache.org/licenses/LICENSE-2.0)
//-----------------------------------------------------------------------------

package nl.colorize.gradle.cordova;

import org.gradle.api.Project;

import java.io.File;
import java.util.Arrays;
import java.util.List;

public class CordovaExt {

    private String webAppDir;
    private String outputDir;
    private String platforms;
    private String appId;
    private String appName;
    private String version;
    private String icon;
    private String buildJson;
    private String dist;

    public CordovaExt() {
        outputDir = "cordova";
        platforms = "ios,android,osx";
        dist = "release";
    }

    public String getWebAppDir() {
        return webAppDir;
    }

    public void setWebAppDir(String webAppDir) {
        this.webAppDir = webAppDir;
    }

    public String getOutputDir() {
        return outputDir;
    }

    public void setOutputDir(String outputDir) {
        this.outputDir = outputDir;
    }

    public File prepareOutputDir(Project project) {
        File buildDir = project.getBuildDir();
        File result = new File(buildDir.getAbsolutePath() + "/" + outputDir);
        if (result.getParentFile() != null && !result.getParentFile().exists()) {
            result.getParentFile().mkdir();
        }
        return result;
    }

    public String getPlatforms() {
        return platforms;
    }

    public List<String> getPlatformList() {
        return Arrays.asList(platforms.split(","));
    }

    public void setPlatforms(String platforms) {
        this.platforms = platforms;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getBuildVersion() {
        return System.getProperty("buildversion", version.replace(".", ""));
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getBuildJson() {
        return buildJson;
    }

    public void setBuildJson(String buildJson) {
        this.buildJson = buildJson;
    }

    public String getDist() {
        return dist;
    }

    public void setDist(String dist) {
        this.dist = dist;
    }
}
