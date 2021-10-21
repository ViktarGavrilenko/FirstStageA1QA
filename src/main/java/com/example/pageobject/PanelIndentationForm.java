package com.example.pageobject;

import com.example.elements.PanelWithButtons;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class PanelIndentationForm extends BaseForm {
    private static final PanelWithButtons PANEL_NAME =
            new PanelWithButtons(By.xpath("//div[@title='indentation']"), "PanelIndentation");
    private static final By BUTTONS = By.xpath("//div[@title='indentation']//button");

    PanelIndentationForm() {
        super(PANEL_NAME, "PanelIndentation");
    }

    public boolean isStateButtonDefault() {
        List<WebElement> buttons = PANEL_NAME.getButtonsFromPanel(BUTTONS);
        if (buttons.size() == 2) {
            if (!Boolean.parseBoolean(buttons.get(0).getAttribute("aria-disabled"))) {
                return false;
            }
            return !Boolean.parseBoolean(buttons.get(1).getAttribute("aria-disabled"));
        } else {
            throw new IllegalArgumentException("Invalid number of buttons on the panel indentation");
        }
    }
}