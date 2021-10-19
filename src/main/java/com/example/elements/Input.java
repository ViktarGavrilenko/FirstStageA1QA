package com.example.elements;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;

public class Input extends BaseElement {
    private static final Logger LOG = Logger.getLogger(TextField.class);

    public Input(By locator, String name) {
        super(locator, name);
    }

    public void sendText(String data) {
        LOG.info("Send text in the input");
        findElement().sendKeys(data);
    }
}