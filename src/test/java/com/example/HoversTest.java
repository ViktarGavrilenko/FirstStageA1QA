package com.example;

import com.example.core.DriverUtilities;
import com.example.page_object.HoversForm;
import org.apache.log4j.Logger;
import org.testng.annotations.Test;

public class HoversTest extends BaseTest {

    private static final Logger LOG = Logger.getLogger(HoversTest.class);
    private static final String URL = TEST_DATA_PROPERTIES.getProperty("main.page") +
            TEST_DATA_PROPERTIES.getProperty("hovers.page");

    @Test(dataProvider = "hovers", dataProviderClass = DP.class,
            description = "Тест формы с наведением мыши на пользователей")
    public void testHoversTest(int user) {
        LOG.info("Navigate to URL " + URL);
        DriverUtilities.goToUrl(URL);
        HoversForm hoversForm = new HoversForm();
        assertTrue(hoversForm.isDisplayed(), "Проверяем загрузилась ли страница Hovers");
        LOG.info("Move the cursor to user label");
        assertEquals(hoversForm.getTextUser(user), "name: user" + user,
                "Проверяем текс после наведения на картинку");
        assertTrue(hoversForm.isUrlProfile(user), "Проверяем отображается ли ссылка на профиль");
        String urlProfile = hoversForm.getUrl(user);
        LOG.info("Click user label");
        hoversForm.clickUrl(user);
        assertEquals(DriverUtilities.getCurrentUrl(), urlProfile,
                "Сверяем что текущий URL соответствует ссылке из шага 2");
        LOG.info("Back to the previous page");
        DriverUtilities.goToBack();
        assertTrue(hoversForm.isDisplayed(), "Проверяем загрузилась ли страница Hovers");
    }
}
