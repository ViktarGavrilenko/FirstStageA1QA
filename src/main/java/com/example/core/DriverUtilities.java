package com.example.core;

import com.example.config.ConfigurationProperties;
import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class DriverUtilities {
    private static final Logger LOG = Logger.getLogger(DriverUtilities.class);
    private static final Properties CONFIG_PROPERTIES =
            ConfigurationProperties.createProperties("configuration.properties");
    private static final int TIME_OUT = Integer.parseInt(CONFIG_PROPERTIES.getProperty("timeout"));
    private static final JavascriptExecutor JS = (JavascriptExecutor) DriverManager.getDriver();

    public static void manageTimeout(int milliSecond) {
        LOG.info("Establishing expectation " + milliSecond + " milliseconds");
        DriverManager.getDriver().manage().timeouts().implicitlyWait(milliSecond, TimeUnit.MILLISECONDS);
    }

    public static void maximize() {
        LOG.info("Maximizing the browser window");
        DriverManager.getDriver().manage().window().maximize();
    }

    public static void goToUrl(String url) {
        LOG.info("Opening the URL " + url);
        DriverManager.getDriver().get(url);
    }

    public static String getCurrentUrl() {
        LOG.info("Get current URL");
        return DriverManager.getDriver().getCurrentUrl();
    }

    public static void goToBack() {
        LOG.info("Go to back page");
        DriverManager.getDriver().navigate().back();
    }

    protected static Alert waitAlert() {
        LOG.info("Wait alert");
        return (new WebDriverWait(DriverManager.getDriver(), TIME_OUT)).until(ExpectedConditions.alertIsPresent());
    }

    public static String getTextAlert() {
        LOG.info("Get text from the alert");
        return waitAlert().getText();
    }

    public static void clickBtnOkOnAlert() {
        LOG.info("Click the OK button on the alert");
        waitAlert().accept();
    }

    public static boolean isAlertPresent() {
        LOG.info("Checking if there is an alert");
        try {
            DriverManager.getDriver().switchTo().alert();
            return true;
        } catch (NoAlertPresentException Ex) {
            return false;
        }
    }

    public static void printTextToAlert(String text) {
        LOG.info("Print text " + text + " to Alert");
        Alert alert = waitAlert();
        alert.sendKeys(text);
        alert.accept();
    }

    public static void goToFrame(String frame) {
        LOG.info("Go to the frame " + frame);
        DriverManager.getDriver().switchTo().frame(frame);
    }

    public static void goToDefaultFrame() {
        LOG.info("Return to the main frame");
        DriverManager.getDriver().switchTo().defaultContent();
    }

    public static void userAuthorization(String login, String password, String url) {
        LOG.info("Enter your username and password");
        String logData = login + ":" + password + "@";
        url = new StringBuilder(url).insert(url.indexOf("//") + 2, logData).toString();
        DriverUtilities.goToUrl(url);
    }

    public static void clickBtnWithJS(WebElement element) {
        LOG.info("Clicking the button using the javascript method");
        JS.executeScript("arguments[0].click();", element);
    }

    public static void scrollDownPageJS() {
        LOG.info("Scrolling the page using the javascript method");
        JS.executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }
}