package com.example.core;

import com.example.config.ConfigurationProperties;

import java.util.concurrent.TimeUnit;

public class DriverUtilities {

    public static void manageTimeout(int seconds) {
        DriverManager.getDriver().manage().timeouts().implicitlyWait(seconds, TimeUnit.SECONDS);
    }

    public static void goToUrl() {
        DriverManager.getDriver().get(ConfigurationProperties.getInstance().getMainPage());
    }

    public static void close() {
        DriverManager.getDriver().close();
        DriverManager.getDriver().quit();
    }


}
