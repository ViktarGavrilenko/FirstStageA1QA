package com.example.elements;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;

public class TextField extends BaseElement {
    private static final Logger LOG = Logger.getLogger(TextField.class);

    public TextField(By locator, String name) {
        super(locator, name);
    }

    public String getText() {
        LOG.info("Get text from element");
        return findElement().getText();
    }
}