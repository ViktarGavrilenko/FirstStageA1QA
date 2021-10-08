package com.example.elements;

import org.openqa.selenium.By;

public class Input extends BaseElement {

    public Input(By locator, String name) {
        super(locator, name);
    }

    public void sendText(String data) {
        findElement().sendKeys(data);
    }
}
