package com.example.core;

import java.util.concurrent.TimeUnit;

public class DriverUtilities {

    public static void manageTimeout(int seconds) {
        DriverManager.getDriver().manage().timeouts().implicitlyWait(seconds, TimeUnit.SECONDS);
    }

    public static void goToUrl(String url) {
        DriverManager.getDriver().get(url);
    }

    public static void close() {
        DriverManager.getDriver().close();
        DriverManager.getDriver().quit();
    }


}
