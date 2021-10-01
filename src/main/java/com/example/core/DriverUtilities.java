package com.example.core;

import com.example.config.ConfigurationProperties;
import com.example.page_object.MainPage;

import java.util.concurrent.TimeUnit;

public class DriverUtilities {

    public static void manageTimeout(int seconds) {
        DriverManager.getDriver().manage().timeouts().implicitlyWait(seconds, TimeUnit.SECONDS);
    }

    public static MainPage goToUrl() {
        DriverManager.getDriver().get(ConfigurationProperties.getInstance().getMainPage());
        return new MainPage();
    }

    public static void close() {
        DriverManager.getDriver().close();
        DriverManager.getDriver().quit();
    }


}
