/*
 * ExtentLogger.java
 *
 * This class provides methods to log pass, fail, and info messages to the Extent report.
 */

package com.reports;

public final class ExtentLogger {

    // Private constructor to prevent instantiation of the class
    private ExtentLogger() {
    }

    // Method to log pass message
    public static void pass(String message) {
        ExtentManager.getExtentTest().pass(message);
    }

    // Method to log fail message
    public static void fail(String message) {
        ExtentManager.getExtentTest().fail(message);
    }

    // Method to log info message
    public static void info(String message) {
        ExtentManager.getExtentTest().info(message);
    }
}
