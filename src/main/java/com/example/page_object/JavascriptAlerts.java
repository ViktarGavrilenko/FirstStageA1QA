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

    private static Form form = new Form(By.xpath("//div[@id='content']"), "JavascriptAlerts");
    private static Button btnJsAlert = new Button(By.xpath("//button[@onclick='jsAlert()']"), "BtnJsAlert");
    private static Button btnJsConfirm = new Button(By.xpath("//button[@onclick='jsConfirm()']"), "BtnJsConfirm");
    private static Button btnJsPrompt = new Button(By.xpath("//button[@onclick='jsPrompt()']"), "BtnJsPrompt");
    private static TextField resultText = new TextField(By.xpath("//p[@id='result']"), "resultText");


    public JavascriptAlerts() {
        super(form, "JavascriptAlertsForm");
    }

    public void clickBtnJsAlert() {
        btnJsAlert.click();
    }

    public void clickBtnJsConfirm() {
        btnJsConfirm.click();
    }

    public void clickBtnJsPrompt() {
        btnJsPrompt.click();
    }

    public String resultText(){
        return resultText.getText();
    }

    protected Alert waitAlert(){
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

    public void printText(String text){
        Alert alert = waitAlert();
        alert.sendKeys(text);
        alert.accept();
    }
}
