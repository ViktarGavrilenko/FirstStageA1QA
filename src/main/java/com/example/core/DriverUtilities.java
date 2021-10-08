package com.example.core;

import org.apache.log4j.Logger;

import java.util.concurrent.TimeUnit;

public class DriverUtilities {

    private static final Logger log = Logger.getLogger(DriverUtilities.class);

    public static void manageTimeout(int seconds) {
        DriverManager.getDriver().manage().timeouts().implicitlyWait(seconds, TimeUnit.SECONDS);
    }

    public static void goToUrl(String url) {
        DriverManager.getDriver().get(url);
        log.info("Opening the URL " + url );
    }

    public static void close() {
        DriverManager.getDriver().close();
        DriverManager.getDriver().quit();
        log.info("Close the browser and WebDriver");
    }


}
