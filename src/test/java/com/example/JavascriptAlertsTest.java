package com.example;

import com.example.core.DriverUtilities;
import com.example.page_object.JavascriptButtons;
import org.apache.log4j.Logger;
import org.testng.annotations.Test;

public class JavascriptAlertsTest extends BaseTest {

    private static final Logger LOG = Logger.getLogger(JavascriptAlertsTest.class);

    @Test(description = "Тест формы JavascriptAlerts")
    public void testJavascriptAlerts() {
        LOG.info("Navigate to URL" + testDataProperties.getProperty("main.page") +
                testDataProperties.getProperty("javascript.alerts.page"));
        DriverUtilities.goToUrl(testDataProperties.getProperty("main.page") +
                testDataProperties.getProperty("javascript.alerts.page"));
        JavascriptButtons javascriptAlerts = new JavascriptButtons();

        assertTrue(javascriptAlerts.isDisplayed(), "Проверяем загрузилась ли страница JavascriptAlerts");
        LOG.info("Click Click for JS Alert button");
        javascriptAlerts.clickBtnJsAlert();
        assertEquals(DriverUtilities.getTextAlert(), "I am a JS Alert",
                "Проверяем текст на соответствие: I am a JS Alert");
        LOG.info("Click OK button");
        DriverUtilities.clickBtnOkOnAlert();
        assertFalse(DriverUtilities.isAlertPresent(), "Проверяем закрыто ли оповещение");
        assertEquals(javascriptAlerts.resultText(), "You successfully clicked an alert",
                "Проверяем текст после закрытия оповещения JS Alert");
        LOG.info("Click Click for JS Confirm button");
        javascriptAlerts.clickBtnJsConfirm();
        assertEquals(DriverUtilities.getTextAlert(), "I am a JS Confirm",
                "Проверяем текст на соответствие: I am a JS Confirm");
        LOG.info("Click OK button");
        DriverUtilities.clickBtnOkOnAlert();
        assertFalse(DriverUtilities.isAlertPresent(), "Проверяем закрыто ли оповещение");
        assertEquals(javascriptAlerts.resultText(), "You clicked: Ok",
                "Проверяем текст после закрытия оповещения JS Confirm");
        LOG.info("Click Click for JS Prompt button");
        javascriptAlerts.clickBtnJsPrompt();
        assertEquals(DriverUtilities.getTextAlert(), "I am a JS prompt",
                "Проверяем текст на соответствие: I am a JS prompt");
        LOG.info("Input random text and press OK button");
        DriverUtilities.printText("Hello Selenium");
        assertEquals(javascriptAlerts.resultText(), "You entered: Hello Selenium",
                "Проверяем текст после закрытия оповещения JS prompt");
    }
}
