package com.example.elements;

import org.openqa.selenium.By;

public class HorizontalSlider extends BaseElement {
    public HorizontalSlider(By locator, String name) {
        super(locator, name);
    }

    public int getSizeHeight() {
        return findElement().getSize().height;
    }

    public int getSizeWidth() {
        return findElement().getSize().width;
    }
}
