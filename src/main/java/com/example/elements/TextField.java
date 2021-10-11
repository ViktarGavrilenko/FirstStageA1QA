package com.example.elements;

import org.openqa.selenium.By;

public class TextField extends BaseElement {
    public TextField(By locator, String name) {
        super(locator, name);
    }

    public String getText() {
        return findElement().getText();
    }

    public int getSizeHeight() {
        return findElement().getSize().height;
    }

    public int getSizeWidth() {
        return findElement().getSize().width;
    }
}
