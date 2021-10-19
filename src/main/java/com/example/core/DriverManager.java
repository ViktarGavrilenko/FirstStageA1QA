package com.example.core;

import com.example.config.ConfigurationProperties;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import java.util.Properties;

public class DriverManager {
    private static final Logger LOG = Logger.getLogger(DriverManager.class);
    private static final Properties CONFIG_PROPERTIES =
            ConfigurationProperties.createProperties("configuration.properties");
    private static final int TIME_OUT = Integer.parseInt(CONFIG_PROPERTIES.getProperty("timeout"));
    private static WebDriver driver;

    private DriverManager() {
    }

    public static WebDriver createDriver() {
        LOG.info("Create WebDriver");
        if (driver == null) {
            driver = DriverFactory.createDriver();
            DriverUtilities.maximize();
            DriverUtilities.manageTimeout(TIME_OUT);
        }
        return driver;
    }

    public static WebDriver getDriver() {
        LOG.info("Get WebDriver");
        return driver;
    }

    public static void close() {
        LOG.info("Close the browser and WebDriver");
        getDriver().quit();
        driver = null;
    }
}