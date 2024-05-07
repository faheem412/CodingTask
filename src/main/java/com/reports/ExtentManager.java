/*
 * ExtentManager.java
 *
 * This class manages the ExtentTest instances using ThreadLocal to ensure thread safety.
 * It provides methods to get, set, and unload the ExtentTest instance.
 */

package com.reports;

import com.aventstack.extentreports.ExtentTest;

public final class ExtentManager {

    // ThreadLocal instance to store ExtentTest objects for each thread
    private static ThreadLocal<ExtentTest> extTest = new ThreadLocal<>();

    // Private constructor to prevent instantiation of the class
    private ExtentManager() {
    }

    // Method to get the ExtentTest instance
    static ExtentTest getExtentTest() {
        return extTest.get();
    }

    // Method to set the ExtentTest instance
    static void setExtentTest(ExtentTest test) {
        extTest.set(test);
    }

    // Method to unload the ExtentTest instance
    static void unload() {
        extTest.remove();
    }
}
