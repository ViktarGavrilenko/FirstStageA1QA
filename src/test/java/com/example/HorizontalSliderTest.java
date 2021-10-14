package com.example;

import com.example.core.DriverUtilities;
import com.example.page_object.HorizontalSliderForm;
import org.apache.log4j.Logger;
import org.testng.annotations.Test;

public class HorizontalSliderTest extends BaseTest {

    private static final Logger LOG = Logger.getLogger(HorizontalSliderTest.class);

    @Test(description = "Тест формы с горизонтальным слайдером")
    public void testHorizontalSliderTest() {
        LOG.info("Navigate to URL" + testDataProperties.getProperty("main.page") +
                testDataProperties.getProperty("horizontal.slider.page"));
        DriverUtilities.goToUrl(testDataProperties.getProperty("main.page") +
                testDataProperties.getProperty("horizontal.slider.page"));
        HorizontalSliderForm horizontalSlider = new HorizontalSliderForm();
        assertTrue(horizontalSlider.isDisplayed(), "Проверяем загрузилась ли страница HorizontalSlider");
        LOG.info("Set random value");
        horizontalSlider.SetRandomValueSlider();
        assertTrue(horizontalSlider.isSliderValueValid(), "Проверяем допустимо ли значение ползунка");
    }
}
