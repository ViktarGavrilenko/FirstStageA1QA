package com.example.page_object;

import com.example.elements.Button;
import com.example.elements.Form;
import com.example.elements.TextField;
import org.openqa.selenium.By;

import static com.example.core.DriverUtilities.goToDefaultFrame;
import static com.example.core.DriverUtilities.goToFrame;
import static com.example.utils.KeyEventUtils.*;

public class IframeForm extends BaseForm {
    private static final Form FORM = new Form(By.xpath("//div[@id='content']"), "Iframe");

    private static final Button BTN_ALIGN_LEFT =
            new Button(By.xpath("//button[contains(@title,'Align left')]"), "ButtonAlignLeft");

    private static final TextField TEXT_FIELD = new TextField(By.xpath("//body[@id='tinymce']/p"), "TextField");

    private static final TextField TEXT_NEW_SIZE =
            new TextField(By.xpath("//body[@id='tinymce']//span"), "TextNewSize");

    private static final Button BTN_FILE =
            new Button(By.xpath("//div[@class='tox-menubar']/button[1]"), "ButtonFile");

    private static final Button BTN_FORMAT =
            new Button(By.xpath("//div[@class='tox-menubar']/button[4]"), "ButtonFormat");

    private static final Button BTN_NEW_DOCUMENT =
            new Button(By.xpath("//div[@role='menuitem']"), "ButtonNewDocument");

    private static final Button BTN_FONT_SIZES =
            new Button(By.xpath("//div[@title='Font sizes']"), "ButtonFontSizes");

    private static final Button BTN_8PT =
            new Button(By.xpath("//div[@title='8pt']"), "Button8pt");

    private static final TextField FORMATS =
            new TextField(By.xpath("//button[@title='Formats']/span"), "Formats");

    private static final String NAME_FRAME = "mce_0_ifr";

    public IframeForm() {
        super(FORM, "IframeForm");
    }

    public void clickBtnAlignLeft() {
        BTN_ALIGN_LEFT.click();
    }

    public String getAlignText() {
        goToFrame(NAME_FRAME);
        return TEXT_FIELD.getAttribute("data-mce-style");
    }

    public void clickBtnNewDocument() {
        goToDefaultFrame();
        BTN_FILE.click();
        BTN_NEW_DOCUMENT.click();
    }

    public boolean isTextEmpty() {
        goToFrame(NAME_FRAME);
        return TEXT_FIELD.getText().equals("");
    }

    public void selectTextInField() {
        TEXT_FIELD.click(0, TEXT_FIELD.getSizeHeight() / 2);
        int lengthStr = TEXT_FIELD.getText().length();
        for (int i = 0; i < lengthStr; i++) {
            clickLeft();
        }
        pressShift();
        for (int i = 0; i < lengthStr / 2; i++) {
            clickRight();
        }
        releaseShift();
        goToDefaultFrame();
        BTN_FORMAT.click();
        BTN_FONT_SIZES.click();
        BTN_8PT.click();
    }

    public String getTextWithNewSize() {
        goToFrame(NAME_FRAME);
        return TEXT_NEW_SIZE.getText();
    }

    public boolean isDocumentFormattingDefault() {
        goToDefaultFrame();
        if (!FORMATS.getText().equals("Paragraph")) {
            return false;
        }
        PanelFormattingForm panelFormatting = new PanelFormattingForm();
        if (!panelFormatting.isAllButtonDisable()) {
            return false;
        }
        PanelAlignmentForm panelAlignment = new PanelAlignmentForm();
        if (!panelAlignment.isAllButtonDisable()) {
            return false;
        }
        PanelIndentationForm panelIndentation = new PanelIndentationForm();
        return panelIndentation.isStateButtonDefault();
    }
}
