package com.example.page_object;

import com.example.elements.PanelWithButtons;
import org.openqa.selenium.By;

public class PanelFormattingForm extends BaseForm {

    private static final PanelWithButtons PANEL_NAME =
            new PanelWithButtons(By.xpath("//div[@title='formatting']"), "PanelFormatting");
    private static final By BUTTONS = By.xpath("//div[@title='formatting']//button");

    PanelFormattingForm() {
        super(PANEL_NAME, "PanelFormatting");
    }

    public boolean isAllButtonDisable() {
        return PANEL_NAME.isAllButtonsDisable(PANEL_NAME.getButtonsFromPanel(BUTTONS));
    }
}