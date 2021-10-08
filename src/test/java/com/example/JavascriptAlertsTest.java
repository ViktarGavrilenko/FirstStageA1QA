package com.example;

import com.example.config.TestDataProperties;
import com.example.core.DriverFactory;
import com.example.core.DriverUtilities;
import com.example.page_object.JavascriptAlerts;
import org.apache.log4j.Logger;
import org.testng.annotations.Test;

public class JavascriptAlertsTest extends BaseTest {

    private static final Logger log = Logger.getLogger(JavascriptAlertsTest.class);

    @Test(description = "Тест формы авторизации")
    public void testJavascriptAlerts() {
        log.info("Run the test");
        DriverUtilities.goToUrl(TestDataProperties.getInstance().getMainPage() +
                TestDataProperties.getInstance().getJavascriptAlertsPage());
        JavascriptAlerts javascriptAlerts = new JavascriptAlerts();

        assertTrue(javascriptAlerts.isDisplayed(), "Проверяем загрузилась ли страница JavascriptAlerts");
        javascriptAlerts.clickBtnJsAlert();
        assertEquals(javascriptAlerts.getTextAlert(), "I am a JS Alert",
                "Проверяем текст на соответствие: I am a JS Alert");
        javascriptAlerts.clickBtnOkOnAlert();
        assertFalse(javascriptAlerts.isAlertPresent(), "Проверяем закрыто ли оповещение");
        assertEquals(javascriptAlerts.resultText(), "You successfully clicked an alert",
                "Проверяем текст после закрытия оповещения JS Alert");
        javascriptAlerts.clickBtnJsConfirm();
        assertEquals(javascriptAlerts.getTextAlert(), "I am a JS Confirm",
                "Проверяем текст на соответствие: I am a JS Confirm");
        javascriptAlerts.clickBtnOkOnAlert();
        assertFalse(javascriptAlerts.isAlertPresent(), "Проверяем закрыто ли оповещение");
        assertEquals(javascriptAlerts.resultText(), "You clicked: Ok",
                "Проверяем текст после закрытия оповещения JS Confirm");
        javascriptAlerts.clickBtnJsPrompt();
        assertEquals(javascriptAlerts.getTextAlert(), "I am a JS prompt",
                "Проверяем текст на соответствие: I am a JS prompt");
        javascriptAlerts.printText("Hello Selenium");
        assertEquals(javascriptAlerts.resultText(), "You entered: Hello Selenium",
                "Проверяем текст после закрытия оповещения JS prompt");
        log.info("Test completed");
    }
}
