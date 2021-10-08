package com.example.page_object;

import com.example.core.DriverManager;
import com.example.elements.Button;
import com.example.elements.Form;
import com.example.elements.TextField;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class JavascriptAlerts extends BaseForm {

    private static final String BTN_PATTERN = "//button[@onclick='%s']";

    private static final Form FORM = new Form(By.xpath("//div[@id='content']"), "JavascriptAlerts");
    private static final Button BTN_JS_ALERT = new Button(By.xpath(getBtnLocator("jsAlert()")), "BtnJsAlert");
    private static final Button BTN_JS_CONFIRM = new Button(By.xpath(getBtnLocator("jsConfirm()")), "BtnJsConfirm");
    private static final Button BTN_JS_PROMPT = new Button(By.xpath(getBtnLocator("jsPrompt()")), "BtnJsPrompt");
    private static final TextField RESULT_TEXT = new TextField(By.xpath("//p[@id='result']"), "resultText");

    public JavascriptAlerts() {
        super(FORM, "JavascriptAlertsForm");
    }

    public String resultText() {
        return RESULT_TEXT.getText();
    }

    public void clickBtnJsAlert() {
        BTN_JS_ALERT.click();
    }

    public void clickBtnJsConfirm() {
        BTN_JS_CONFIRM.click();
    }

    public void clickBtnJsPrompt() {
        BTN_JS_PROMPT.click();
    }

    private static String getBtnLocator(String name) {
        return String.format(BTN_PATTERN, name);
    }

    protected Alert waitAlert() {
        return (new WebDriverWait(DriverManager.getDriver(), 5)).until(ExpectedConditions.alertIsPresent());
    }

    public String getTextAlert() {
        return waitAlert().getText();
    }

    public void clickBtnOkOnAlert() {
        waitAlert().accept();
    }

    public boolean isAlertPresent() {
        try {
            DriverManager.getDriver().switchTo().alert();
            return true;
        } catch (NoAlertPresentException Ex) {
            return false;
        }
    }

    public void printText(String text) {
        Alert alert = waitAlert();
        alert.sendKeys(text);
        alert.accept();
    }
}
