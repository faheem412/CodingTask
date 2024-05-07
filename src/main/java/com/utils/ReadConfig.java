/*
 * ReadConfig.java
 *
 * This class reads configuration properties from a properties file.
 * It includes a static block to load properties from the configuration file and a method to get property values.
 */

package com.utils;

import com.constants.FrameworkConstants;
import com.enums.ConfigProperties;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public final class ReadConfig {

    // Properties object to store configuration properties
    private static final Properties properties = new Properties();

    // Static block to load properties from the configuration file
    static {
        InputStream inputStream = null;
        try {
            inputStream = new FileInputStream(FrameworkConstants.getConfigPath());
        } catch (FileNotFoundException e) {
            throw new IllegalArgumentException(e);
        }
        try {
            properties.load(inputStream);
        } catch (IOException e) {
            throw new IllegalArgumentException(e);
        }
    }

    // Private constructor to prevent instantiation of the class
    private ReadConfig() {
    }

    // Method to get property value based on the key
    public static String getValue(ConfigProperties key) {
        return properties.getProperty(String.valueOf(key).toLowerCase());
    }
}
