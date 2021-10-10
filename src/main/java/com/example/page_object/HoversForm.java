package com.example.page_object;

import com.example.elements.Form;
import com.example.elements.Image;
import com.example.elements.TextField;
import com.example.elements.Url;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;

import java.util.NoSuchElementException;

public class HoversForm extends BaseForm {
    private static final Logger LOG = Logger.getLogger(HoversForm.class);

    private static final String IMAGE_PATTERN = "//div[@class='figure'][%s]//img";
    private static final String TEXT_PATTERN = "//div[@class='figure'][%s]//h5";
    private static final String URL_PROFILE_PATTERN = "//div[@class='figure'][%s]//a";
    private static final Form FORM = new Form(By.xpath("//div[@id='content']"), "HoversForm");

    public HoversForm() {
        super(FORM, "HoversForm");
    }

    private static String getImageLocator(int name) {
        return String.format(IMAGE_PATTERN, name);
    }

    private static String getTextLocator(int name) {
        return String.format(TEXT_PATTERN, name);
    }

    private static String getUrlProfileLocator(int name) {
        return String.format(URL_PROFILE_PATTERN, name);
    }

    public String getTextUser(int userIndex) {
        Image image = new Image(By.xpath(getImageLocator(userIndex)), "Image" + userIndex);
        TextField text = new TextField(By.xpath(getTextLocator(userIndex)), "Text" + userIndex);
        image.moveToElement();
        LOG.info("Move to element with index " + userIndex);
        if (text.isDisplayed()) {
            return text.getText();
        } else {
            throw new NoSuchElementException("Element not found on page");
        }
    }

    public boolean isUrlProfile(int userIndex) {
        return createUrlObject(userIndex).isDisplayed();
    }

    public void clickUrl(int userIndex) {
        createUrlObject(userIndex).click();
    }

    public String getUrl(int userIndex) {
        return createUrlObject(userIndex).getAttribute("href");
    }

    private Url createUrlObject(int userIndex) {
        return new Url(By.xpath(getUrlProfileLocator(userIndex)), "Url" + userIndex);
    }
}
