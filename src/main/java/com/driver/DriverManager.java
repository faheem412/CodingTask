/*
 * DriverManager.java
 *
 * This class manages the WebDriver instances using ThreadLocal to ensure thread safety.
 * It provides methods to get, set, and unload the WebDriver instance.
 */

package com.driver;

import org.openqa.selenium.WebDriver;

import java.util.Objects;

public class DriverManager {

    // ThreadLocal instance to store WebDriver objects for each thread
    private static ThreadLocal<WebDriver> dr = new ThreadLocal<>();

    // Private constructor to prevent instantiation of the class
    private DriverManager() {
    }

    // Method to get the WebDriver instance
    public static WebDriver getDriver() {
        return dr.get();
    }

    // Method to set the WebDriver instance
    static void setDriver(WebDriver driver) {
        if (Objects.nonNull(driver)) {
            dr.set(driver);
        }
    }

    // Method to unload the WebDriver instance
    static void unload() {
        dr.remove();
    }
}
