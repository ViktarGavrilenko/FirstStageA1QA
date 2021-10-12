package com.example.page_object;

import com.example.elements.PanelWithButtons;
import org.openqa.selenium.By;

public class PanelAlignmentForm extends BaseForm {

    private static final PanelWithButtons PANEL_NAME = new PanelWithButtons(By.xpath("//div[@title='alignment']"), "PanelAlignment");
    private static final By BUTTONS = By.xpath("//div[@title='alignment']//button");

    PanelAlignmentForm() {
        super(PANEL_NAME, "PanelAlignment");
    }

    public boolean isAllButtonDisable() {
        return PANEL_NAME.isAllButtonsDisable(PANEL_NAME.getButtonWithPanel(BUTTONS));
    }
}
