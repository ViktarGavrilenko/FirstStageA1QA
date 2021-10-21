package com.example.pageobject;

import com.example.elements.Button;
import com.example.elements.Form;
import com.example.elements.TextField;
import org.openqa.selenium.By;

public class JavascriptButtons extends BaseForm {

    private static final String BTN_PATTERN = "//button[@onclick='%s']";
    private static final Form FORM = new Form(By.xpath("//div[@id='content']"), "JavascriptAlertsForm");
    private static final Button BTN_JS_ALERT =
            new Button(By.xpath(getBtnLocator("jsAlert()")), "BtnJsAlert");
    private static final Button BTN_JS_CONFIRM =
            new Button(By.xpath(getBtnLocator("jsConfirm()")), "BtnJsConfirm");
    private static final Button BTN_JS_PROMPT =
            new Button(By.xpath(getBtnLocator("jsPrompt()")), "BtnJsPrompt");
    private static final TextField RESULT_TEXT = new TextField(By.xpath("//p[@id='result']"), "resultText");

    public JavascriptButtons() {
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
}