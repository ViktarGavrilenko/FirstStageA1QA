package com.example;

import com.example.core.DriverUtilities;
import com.example.page_object.HorizontalSliderForm;
import org.apache.log4j.Logger;
import org.testng.annotations.Test;

public class HorizontalSliderTest extends BaseTest {
    private static final Logger LOG = Logger.getLogger(HorizontalSliderTest.class);
    private static final String URL = CONFIGURATION_PROPERTIES.getProperty("main.page") +
            TEST_DATA_PROPERTIES.getProperty("horizontal.slider.page");

    @Test(description = "Тест формы с горизонтальным слайдером")
    public void testHorizontalSliderTest() {
        LOG.info("Navigate to URL " + URL);
        DriverUtilities.goToUrl(URL);
        HorizontalSliderForm horizontalSlider = new HorizontalSliderForm();
        assertTrue(horizontalSlider.isDisplayed(), "Страница HorizontalSlider не загрузилась");
        LOG.info("Set random value");
        horizontalSlider.setRandomValueSlider();
        assertTrue(horizontalSlider.isSliderValueValid(), "Значение ползунка не допустимо");
    }
}