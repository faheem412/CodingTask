/*
 * ListenerClass.java
 *
 * This class implements TestNG listeners to generate Extent reports for test execution.
 * It includes methods to handle test start, test failure, suite start, and suite finish events.
 */

package com.listeners;

import com.enums.ConfigProperties;
import com.reports.ExtentLogger;
import com.reports.ExtentReport;
import com.utils.ReadConfig;
import org.testng.IReporter;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenerClass implements ITestListener, IReporter {

    // Method invoked when a test starts
    @Override
    public void onTestStart(ITestResult result) {
        // Create a new test in the Extent report
        ExtentReport.createTest(result.getName());
        // Log information about the URL being loaded
        ExtentLogger.info(ReadConfig.getValue(ConfigProperties.URL) + " is loaded");
    }

    // Method invoked when a test fails
    @Override
    public void onTestFailure(ITestResult result) {
        // Log failure message and method name in the Extent report
        ExtentLogger.fail(result.getThrowable().getMessage());
        ExtentLogger.fail(result.getMethod().getMethodName());
    }

    // Method invoked before the suite starts
    @Override
    public void onStart(ITestContext context) {
        // Initialize the Extent report
        ExtentReport.initReport();
    }

    // Method invoked after the suite finishes
    @Override
    public void onFinish(ITestContext context) {
        // Flush the Extent report to write logs
        ExtentReport.flushReport();
    }
}
