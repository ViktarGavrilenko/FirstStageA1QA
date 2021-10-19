package com.example.elements;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class PanelWithButtons extends BaseElement {
    private static final Logger LOG = Logger.getLogger(TextField.class);
    public PanelWithButtons(By locator, String name) {
        super(locator, name);
    }

    public List<WebElement> getButtonsFromPanel(By locator) {
        LOG.info("Get buttons from panel");
        return findElement().findElements(locator);
    }

    public boolean isAllButtonsDisable(List<WebElement> buttonsWithPanel) {
        LOG.info("Check if all buttons are off");
        for (WebElement webElement : buttonsWithPanel) {
            if (Boolean.parseBoolean(webElement.getAttribute("aria-pressed"))) {
                return false;
            }
        }
        return true;
    }
}