package com.example.page_object;

import com.example.core.DriverUtilities;
import com.example.elements.Button;
import com.example.elements.Form;
import com.example.elements.TextField;
import org.openqa.selenium.By;

public class IframeForm extends BaseForm {
    private static final Form FORM = new Form(By.xpath("//div[@id='content']"), "Iframe");

    private static final Button BTN_ALIGN_LEFT =
            new Button (By.xpath("//button[contains(@title,'Align left')]"), "ButtonAlignLeft");

    private static final TextField TEXT_FIELD = new TextField (By.xpath("//body[@id='tinymce']/p"), "TextField");

    private static final Button BTN_FILE =
            new Button (By.xpath("//div[@class='tox-menubar']/button[1]"), "ButtonFile");

    private static final Button BTN_NEW_DOCUMENT =
            new Button (By.xpath("//div[@role='menuitem']"), "ButtonNewDocument");

    public IframeForm() {
        super(FORM, "IframeForm");
    }

    public void clickBtnAlignLeft(){
        BTN_ALIGN_LEFT.click();
    }

    public String getAlignText(){
        DriverUtilities.goToFrame("mce_0_ifr");
        return TEXT_FIELD.getAttribute("data-mce-style");
    }

    public void clickBtnFile(){
        DriverUtilities.goToDefaultFrame();
        BTN_FILE.click();
    }

    public void clickBtnNewDocument(){
        BTN_NEW_DOCUMENT.click();
    }

    public boolean isTextEmpty() {
        DriverUtilities.goToFrame("mce_0_ifr");
        return TEXT_FIELD.getText().equals("");
    }


}
