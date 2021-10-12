package com.example.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class PanelWithButtons extends BaseElement {
    public PanelWithButtons(By locator, String name) {
        super(locator, name);
    }

    public List<WebElement> getButtonWithPanel(By locator) {
        return findElement().findElements(locator);
    }

    public boolean isAllButtonsDisable(List<WebElement> buttonsWithPanel) {
        for (WebElement webElement : buttonsWithPanel) {
            if (Boolean.parseBoolean(webElement.getAttribute("aria-pressed"))) {
                return false;
            }
        }
        return true;
    }
}
