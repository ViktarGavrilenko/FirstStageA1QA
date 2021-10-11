package com.example.elements;

import com.example.core.DriverManager;
import com.example.core.DriverUtilities;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;
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
        findElement().click();
        LOG.info("Click to " + name);
    }

    public void click(int x, int y) {
        Actions action = new Actions(DriverManager.getDriver());
        action.moveToElement(findElement(), x, y).click().build().perform();
        LOG.info("Click to " + name);

    }

    public void moveToElement(){
        Actions actions = new Actions(DriverManager.getDriver());
        actions.moveToElement(findElement()).build().perform();
        LOG.info("Move to " + name);
    }

    public void selectText(int count) {
        findElement().sendKeys(Keys.SHIFT);
        findElement().sendKeys();
    }




    public String getAttribute(String name) {
        return findElement().getAttribute(name);
    }

    protected WebElement findElement() {
        WebElement element = null;
        List<WebElement> elements = DriverManager.getDriver().findElements(locator);
        if (elements.isEmpty()) {
            throw new NoSuchElementException(String.format("Element with name '%s' not found on page", name));
        } else {
            element = elements.get(0);
        }
        return element;
    }

}
