/*
 * ExtentReport.java
 *
 * This class manages the ExtentReports instance and initializes the Extent report.
 * It includes methods to initialize the Extent report, flush the report, and create tests within the report.
 */

package com.reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.constants.FrameworkConstants;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.Objects;

public final class ExtentReport {

    // Static instance of ExtentReports
    private static ExtentReports extent;

    // Private constructor to prevent instantiation of the class
    private ExtentReport() {
    }

    // Method to initialize the Extent report
    public static void initReport() {
        if (Objects.isNull(extent)) {
            extent = new ExtentReports();
            ExtentSparkReporter spark = new ExtentSparkReporter(FrameworkConstants.getExtentReportFilePath());
            extent.attachReporter(spark);
            spark.config().setTheme(Theme.STANDARD);
            spark.config().setReportName("Verify User Registration");
        }
    }

    // Method to flush the Extent report and open the report file
    public static void flushReport() {
        if (Objects.nonNull(extent)) {
            extent.flush();
            try {
                Desktop.getDesktop().browse(new File(FrameworkConstants.getExtentReportFilePath()).toURI());
            } catch (IOException e) {
                throw new IllegalArgumentException(e);
            }
            ExtentManager.unload();
        }
    }

    // Method to create a new test within the Extent report
    public static void createTest(String testName) {
        ExtentManager.setExtentTest(extent.createTest(testName));
    }
}
