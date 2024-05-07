/*
 * FrameworkConstants.java
 *
 * This class provides constants used throughout the framework.
 * It includes wait duration, paths for configuration files and extent report,
 * and methods to access these constants.
 */

package com.constants;

import java.time.Duration;

public final class FrameworkConstants {

    // Default wait duration for waiting actions
    private static final Duration WAIT = Duration.ofSeconds(10);
    // Path to the resources directory
    private static final String RESOURCESPATH = System.getProperty("user.dir") + "/src/main/resources";
    // Path to the configuration properties file
    private static final String CONFIGFILEPATH = RESOURCESPATH + "/config.properties";
    // Path to the extent report file generated
    private static final String EXTENTREPORTPATH = System.getProperty("user.dir") + "/target/sparkReport.html";

    // Private constructor to prevent instantiation of the class
    private FrameworkConstants() {
    }

    // Method to get the path of the configuration properties file
    public static String getConfigPath() {
        return CONFIGFILEPATH;
    }

    // Method to get the default wait duration
    public static Duration getWait() {
        return WAIT;
    }

    // Method to get the path of the extent report file
    public static String getExtentReportFilePath() {
        return EXTENTREPORTPATH;
    }
}
