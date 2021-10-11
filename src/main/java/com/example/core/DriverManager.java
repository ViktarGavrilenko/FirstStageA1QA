package com.example.core;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

public class DriverManager {
    private static final Logger LOG = Logger.getLogger(DriverManager.class);
    private static WebDriver driver;

    private DriverManager() {
    }

    public static WebDriver getDriver() {
        if (driver == null) {
            driver = DriverFactory.createDriver();
        }
        return driver;
    }

    public static void close() {
        LOG.info("Close the browser and WebDriver");
        getDriver().quit();
        driver = null;
    }
}
