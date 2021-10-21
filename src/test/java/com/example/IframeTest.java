package com.example;

import com.example.core.DriverUtilities;
import com.example.pageobject.IframeForm;
import org.apache.log4j.Logger;
import org.testng.annotations.Test;

public class IframeTest extends BaseTest {

    private static final Logger LOG = Logger.getLogger(IframeTest.class);
    private static final String URL = CONFIGURATION_PROPERTIES.getProperty("main.page") +
            TEST_DATA_PROPERTIES.getProperty("iframe.page");

    @Test(description = "Тест формы Iframe")
    public void testIframe() {
        LOG.info("Navigate to URL " + URL);
        DriverUtilities.goToUrl(URL);
        IframeForm iframe = new IframeForm();
        assertTrue(iframe.isDisplayed(), "Страница Iframe не загрузилась");
        LOG.info("Align text left");
        iframe.clickBtnAlignLeft();
        assertEquals(iframe.getAlignText(), "text-align: left;",
                "Текст не выровнен по левому краю");
        LOG.info("For the first half of text symbols change font size");
        iframe.selectTextInField();
        assertEquals(iframe.getTextWithNewSize(), "Your conten",
                "Текст с новым размером шрифта не соответствует ожидаемому");
        LOG.info("Click File -> New document");
        iframe.clickBtnNewDocument();
        assertTrue(iframe.isTextEmpty(), "Поле для текста не пустое");
        assertTrue(iframe.isDocumentFormattingDefault(),
                "Документ не соответствует форматированию по умолчанию");
    }
}