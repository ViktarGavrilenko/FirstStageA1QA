package com.example.pageobject;

import com.example.elements.Form;
import com.example.elements.Image;
import com.example.elements.TextField;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;

import java.util.NoSuchElementException;

public class HoversForm extends BaseForm {
    private static final Logger LOG = Logger.getLogger(HoversForm.class);

    private static final Form FORM = new Form(By.xpath("//div[@id='content']"), "HoversForm");

    public HoversForm() {
        super(FORM, "HoversForm");
    }

    private static Image createImageObject(int userIndex) {
        return new Image(By.xpath(String.format("//div[@class='figure'][%s]//img", userIndex)),
                "Image" + userIndex);
    }

    private static TextField createTextObject(int userIndex) {
        return new TextField(By.xpath(String.format("//div[@class='figure'][%s]//h5", userIndex)),
                "Text" + userIndex);
    }

    private TextField createTextFieldObject(int userIndex) {
        return new TextField(By.xpath(String.format("//div[@class='figure'][%s]//a", userIndex)),
                "Url" + userIndex);
    }

    public String getTextUser(int userIndex) {
        Image image = createImageObject(userIndex);
        TextField text = createTextObject(userIndex);
        image.moveToElement();
        LOG.info("Move to element with index " + userIndex);
        if (text.isDisplayed()) {
            return text.getText();
        } else {
            throw new NoSuchElementException("Element not found on page");
        }
    }

    public boolean isUrlProfile(int userIndex) {
        return createTextFieldObject(userIndex).isDisplayed();
    }

    public void clickUrl(int userIndex) {
        createTextFieldObject(userIndex).click();
    }

    public String getUrl(int userIndex) {
        return createTextFieldObject(userIndex).getAttribute("href");
    }
}