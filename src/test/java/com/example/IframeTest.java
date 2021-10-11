package com.example;

import com.example.config.TestDataProperties;
import com.example.core.DriverUtilities;
import com.example.page_object.IframeForm;
import org.testng.annotations.Test;

public class IframeTest extends BaseTest {
    @Test(description = "Тест формы Iframe")
    public void testIframe() {
        DriverUtilities.goToUrl(TestDataProperties.getInstance().getMainPage() +
                TestDataProperties.getInstance().getIframePage());
        IframeForm iframe = new IframeForm();
        assertTrue(iframe.isDisplayed(), "Проверяем загрузилась ли страница Iframe");
        iframe.clickBtnAlignLeft();
        assertEquals(iframe.getAlignText(), "text-align: left;",
                "Проверяем, что текст выровнен по левому краю");
        iframe.selectTextInField();
        assertEquals(iframe.getTextNewSize(), "Your conten", "Проверяем текст с новым размером шрифта");
        iframe.clickBtnNewDocument();
        assertTrue(iframe.isTextEmpty(), "Проверяем пустое ли поле для текста");
    }
}
