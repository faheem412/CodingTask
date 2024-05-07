/*
 * Driver.java
 *
 * This class initializes and quits the WebDriver instance using the DriverManager class.
 * It provides methods to initialize the driver instance and quit the driver instance.
 */

package com.driver;

import com.enums.ConfigProperties;
import com.utils.ReadConfig;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Objects;

public final class Driver {

    // Private constructor to prevent instantiation of the class
    private Driver() {
    }

    // Method to initialize the WebDriver instance
    public static void initDriver() {
        if (Objects.isNull(DriverManager.getDriver())) {
            // If driver instance is null, create a new ChromeDriver instance
            DriverManager.setDriver(new ChromeDriver());
            // Navigate to the URL specified in the configuration properties
            DriverManager.getDriver().get(ReadConfig.getValue(ConfigProperties.URL));
            // Maximize the browser window
            DriverManager.getDriver().manage().window().fullscreen();
        }
    }

    // Method to quit the WebDriver instance
    public static void quitDriver() {
        if (Objects.nonNull(DriverManager.getDriver())) {
            // If driver instance is not null, quit the driver and unload it from the DriverManager
            DriverManager.getDriver().quit();
            DriverManager.unload();
        }
    }
}
