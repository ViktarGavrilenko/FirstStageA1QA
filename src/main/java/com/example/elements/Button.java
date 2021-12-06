package com.example.elements;

import org.openqa.selenium.By;

import static com.example.core.DriverUtilities.clickBtnWithJS;

public class Button extends BaseElement {
    public Button(By locator, String name) {
        super(locator, name);
    }

    public void clickJS() {
        clickBtnWithJS(findElement());
    }

    public void uploadFileUseSendKeys(String filePath) {
        findElement().sendKeys(filePath);
    }
}