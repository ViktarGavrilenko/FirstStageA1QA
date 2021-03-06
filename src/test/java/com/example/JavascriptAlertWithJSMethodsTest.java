package com.example;

import com.example.core.DriverUtilities;
import com.example.pageobject.JavascriptButtons;
import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class JavascriptAlertWithJSMethodsTest extends BaseTest {
    private static final Logger LOG = Logger.getLogger(JavascriptAlertsTest.class);
    private static final String URL = CONFIGURATION_PROPERTIES.getProperty("main.page") +
            TEST_DATA_PROPERTIES.getProperty("javascript.alerts.page");

    @Test(description = "Тест формы JavascriptAlerts с использованием методов JavaScript")
    public void testJavascriptAlertsWithJSMethods() {
        LOG.info("Navigate to URL " + URL);
        DriverUtilities.goToUrl(URL);
        JavascriptButtons javascriptAlerts = new JavascriptButtons();
        assertTrue(javascriptAlerts.isDisplayed(), "Страница JavascriptAlerts не загрузилась");
        LOG.info("Click Click for JS Alert button using JavaScript methods");
        javascriptAlerts.clickBtnJSAlertWithJS();
        assertEquals(DriverUtilities.getTextAlert(), "I am a JS Alert",
                "Текст не соответствует: I am a JS Alert");
        LOG.info("Click OK button");
        DriverUtilities.clickBtnOkOnAlert();
        assertFalse(DriverUtilities.isAlertPresent(), "Оповещение не закрыто");
        assertEquals(javascriptAlerts.resultText(), "You successfully clicked an alert",
                "Текст после закрытия оповещения JS Alert не соответствует ожидаемому");
        LOG.info("Click Click for JS Confirm button using JavaScript methods");
        javascriptAlerts.clickBtnJSConfirmWithJS();
        assertEquals(DriverUtilities.getTextAlert(), "I am a JS Confirm",
                "Текст не соответствует: I am a JS Confirm");
        LOG.info("Click OK button");
        DriverUtilities.clickBtnOkOnAlert();
        assertFalse(DriverUtilities.isAlertPresent(), "Оповещение не закрыто");
        assertEquals(javascriptAlerts.resultText(), "You clicked: Ok",
                "Текст после закрытия оповещения JS Confirm не соответствует ожидаемому");
        LOG.info("Click Click for JS Prompt button using JavaScript methods");
        javascriptAlerts.clickBtnJSPromptWithJS();
        assertEquals(DriverUtilities.getTextAlert(), "I am a JS prompt",
                "Текст не соответствует: I am a JS prompt");
        LOG.info("Input random text and press OK button");
        DriverUtilities.printTextToAlert("Hello Selenium");
        assertEquals(javascriptAlerts.resultText(), "You entered: Hello Selenium",
                "Текст после закрытия оповещения JS prompt не соответствует ожидаемому");
    }
}