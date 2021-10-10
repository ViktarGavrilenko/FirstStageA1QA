package com.example;

import com.example.config.TestDataProperties;
import com.example.core.DriverUtilities;
import com.example.page_object.HorizontalSliderForm;
import org.testng.annotations.Test;

public class HorizontalSliderTest extends BaseTest {

    @Test(description = "Тест формы с горизонтальным слайдером")
    public void testHorizontalSliderTest() {
        DriverUtilities.goToUrl(TestDataProperties.getInstance().getMainPage() +
                TestDataProperties.getInstance().getHorizontalSlidePage());
        HorizontalSliderForm horizontalSlider = new HorizontalSliderForm();
        assertTrue(horizontalSlider.isDisplayed(), "Проверяем загрузилась ли страница HorizontalSlider");
        horizontalSlider.SetRandomValueSlider();
        assertTrue(horizontalSlider.isSliderValueValid(), "Проверяем допустимо ли значение ползунка");
    }
}
