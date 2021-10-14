package com.example;

import com.example.core.DriverUtilities;
import com.example.page_object.IframeForm;
import org.apache.log4j.Logger;
import org.testng.annotations.Test;

public class IframeTest extends BaseTest {

    private static final Logger LOG = Logger.getLogger(IframeTest.class);

    @Test(description = "Тест формы Iframe")
    public void testIframe() {
        LOG.info("Navigate to URL " + testDataProperties.getProperty("main.page") +
                testDataProperties.getProperty("iframe.page"));
        DriverUtilities.goToUrl(testDataProperties.getProperty("main.page") +
                testDataProperties.getProperty("iframe.page"));
        IframeForm iframe = new IframeForm();
        assertTrue(iframe.isDisplayed(), "Проверяем загрузилась ли страница Iframe");
        LOG.info("Align text left");
        iframe.clickBtnAlignLeft();
        assertEquals(iframe.getAlignText(), "text-align: left;",
                "Проверяем, что текст выровнен по левому краю");
        LOG.info("For the first half of text symbols change font size");
        iframe.selectTextInField();
        assertEquals(iframe.getTextWithNewSize(), "Your conten", "Проверяем текст с новым размером шрифта");
        LOG.info("Click File -> New document");
        iframe.clickBtnNewDocument();
        assertTrue(iframe.isTextEmpty(), "Проверяем пустое ли поле для текста");
        assertTrue(iframe.isDocumentFormattingDefault(), "Проверяем, что форматирование документа по умолчанию");
    }
}
