package com.example.elements;

import com.example.core.DriverManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.NoSuchElementException;

public abstract class BaseElement {
    private static final Logger LOG = Logger.getLogger(BaseElement.class);

    private By locator;
    private String name;

    BaseElement(By locator, String name) {
        this.locator = locator;
        this.name = name;
    }

    public boolean isDisplayed() {
        return findElement().isDisplayed();
    }

    public void click() {
        LOG.info("Click to " + name);
        findElement().click();
    }

    public void click(int x, int y) {
        Actions action = new Actions(DriverManager.getDriver());
        action.moveToElement(findElement(), x, y).click().build().perform();
        LOG.info("Click to " + name);
    }

    public void moveToElement() {
        Actions actions = new Actions(DriverManager.getDriver());
        actions.moveToElement(findElement()).build().perform();
        LOG.info("Move to " + name);
    }

    public String getAttribute(String name) {
        LOG.info("Get attribute " + name + " of element " + this.name);
        return findElement().getAttribute(name);
    }

    public int getSizeHeight() {
        LOG.info("Get size height of element");
        return findElement().getSize().height;
    }

    public int getSizeWidth() {
        LOG.info("Get size width of element");
        return findElement().getSize().width;
    }

    protected WebElement findElement() {
        LOG.info("Find element " + name);
        WebElement element = null;
        try {
            element = DriverManager.getDriver().findElement(locator);
        } catch (NoSuchElementException e) {
            LOG.error("Element with name " + name + " not found on page");
        }
        return element;
    }

    public boolean isElementOnPage() {
        return !DriverManager.getDriver().findElements(locator).isEmpty();
    }
}