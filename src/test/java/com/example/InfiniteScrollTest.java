package com.example;

import com.example.core.DriverUtilities;
import com.example.pageobject.InfiniteScrollForm;
import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class InfiniteScrollTest extends BaseTest {
    private static final Logger LOG = Logger.getLogger(InfiniteScrollTest.class);
    private static final String URL = CONFIGURATION_PROPERTIES.getProperty("main.page") +
            TEST_DATA_PROPERTIES.getProperty("infinite.scroll.page");
    private static final int ENGINEER_AGE = Integer.parseInt(TEST_DATA_PROPERTIES.getProperty("engineer.age"));

    @Test(description = "Тест формы InfiniteScroll")
    public void testJavascriptAlerts() {
        LOG.info("Navigate to URL " + URL);
        DriverUtilities.goToUrl(URL);
        InfiniteScrollForm infiniteScrollForm = new InfiniteScrollForm();
        assertTrue(infiniteScrollForm.isDisplayed(), "Страница InfiniteScroll не загрузилась");
        infiniteScrollForm.goDownPage(ENGINEER_AGE);
        assertEquals(infiniteScrollForm.getNumberParagraphsInfiniteScroll(), ENGINEER_AGE,
                "Количестов абзацев не соответствует возрасту инженера");
    }
}