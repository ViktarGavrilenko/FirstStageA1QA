package com.example;

import com.example.config.TestDataProperties;
import com.example.core.DriverUtilities;
import com.example.page_object.JavascriptButtons;
import org.apache.log4j.Logger;
import org.testng.annotations.Test;

public class JavascriptAlertsTest extends BaseTest {

    @Test(description = "Тест формы JavascriptAlerts")
    public void testJavascriptAlerts() {
        DriverUtilities.goToUrl(TestDataProperties.getInstance().getMainPage() +
                TestDataProperties.getInstance().getJavascriptAlertsPage());
        JavascriptButtons javascriptAlerts = new JavascriptButtons();

        assertTrue(javascriptAlerts.isDisplayed(), "Проверяем загрузилась ли страница JavascriptAlerts");
        javascriptAlerts.clickBtnJsAlert();
        assertEquals(DriverUtilities.getTextAlert(), "I am a JS Alert",
                "Проверяем текст на соответствие: I am a JS Alert");
        DriverUtilities.clickBtnOkOnAlert();
        assertFalse(DriverUtilities.isAlertPresent(), "Проверяем закрыто ли оповещение");
        assertEquals(javascriptAlerts.resultText(), "You successfully clicked an alert",
                "Проверяем текст после закрытия оповещения JS Alert");
        javascriptAlerts.clickBtnJsConfirm();
        assertEquals(DriverUtilities.getTextAlert(), "I am a JS Confirm",
                "Проверяем текст на соответствие: I am a JS Confirm");
        DriverUtilities.clickBtnOkOnAlert();
        assertFalse(DriverUtilities.isAlertPresent(), "Проверяем закрыто ли оповещение");
        assertEquals(javascriptAlerts.resultText(), "You clicked: Ok",
                "Проверяем текст после закрытия оповещения JS Confirm");
        javascriptAlerts.clickBtnJsPrompt();
        assertEquals(DriverUtilities.getTextAlert(), "I am a JS prompt",
                "Проверяем текст на соответствие: I am a JS prompt");
        DriverUtilities.printText("Hello Selenium");
        assertEquals(javascriptAlerts.resultText(), "You entered: Hello Selenium",
                "Проверяем текст после закрытия оповещения JS prompt");
    }
}
