package com.example.elements;

import com.example.core.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public abstract class BaseElement {
    private By locator;
    private String name;

    public BaseElement() {
    }

    BaseElement(By locator, String name) {
        this.locator = locator;
        this.name = name;
    }

    public boolean isDisplayed() {
        return findElement().isDisplayed();
    }

    public void click() {
        findElement().click();
    }

    public String getAttribute(String name) {
        return findElement().getAttribute(name);
    }

    protected WebElement findElement() {
        return DriverManager.getDriver().findElement(locator);
    }

}
