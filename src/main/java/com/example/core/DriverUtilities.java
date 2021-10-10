package com.example.core;

import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class DriverUtilities {

    private static final Logger LOG = Logger.getLogger(DriverUtilities.class);

    public static void manageTimeout(int seconds) {
        DriverManager.getDriver().manage().timeouts().implicitlyWait(seconds, TimeUnit.SECONDS);
    }

    public static void goToUrl(String url) {
        DriverManager.getDriver().get(url);
        LOG.info("Opening the URL " + url);
    }

    public static String getCurrentUrl() {
        return DriverManager.getDriver().getCurrentUrl();
    }

    public static void goToBack() {
        DriverManager.getDriver().navigate().back();
    }

    protected static Alert waitAlert() {
        return (new WebDriverWait(DriverManager.getDriver(), 5)).until(ExpectedConditions.alertIsPresent());
    }

    public static String getTextAlert() {
        return waitAlert().getText();
    }

    public static void clickBtnOkOnAlert() {
        waitAlert().accept();
    }

    public static boolean isAlertPresent() {
        try {
            DriverManager.getDriver().switchTo().alert();
            return true;
        } catch (NoAlertPresentException Ex) {
            return false;
        }
    }

    public static void printText(String text) {
        Alert alert = waitAlert();
        alert.sendKeys(text);
        alert.accept();
    }

    public static void goToFrame(String frame) {
        DriverManager.getDriver().switchTo().frame(frame);
    }

    public static void goToDefaultFrame() {
        DriverManager.getDriver().switchTo().defaultContent();
    }
}
