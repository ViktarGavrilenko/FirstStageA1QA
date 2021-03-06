package com.example;

import com.example.core.DriverUtilities;
import com.example.pageobject.HoversForm;
import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class HoversTest extends BaseTest {

    private static final Logger LOG = Logger.getLogger(HoversTest.class);
    private static final String URL = CONFIGURATION_PROPERTIES.getProperty("main.page") +
            TEST_DATA_PROPERTIES.getProperty("hovers.page");

    @Test(dataProvider = "hovers", dataProviderClass = DataProviderForTests.class,
            description = "Тест формы с наведением мыши на пользователей")
    public void testHoversTest(int user) {
        LOG.info("Navigate to URL " + URL);
        DriverUtilities.goToUrl(URL);
        HoversForm hoversForm = new HoversForm();
        assertTrue(hoversForm.isDisplayed(), "Страница Hovers не загрузилась");
        LOG.info("Move the cursor to user label");
        assertEquals(hoversForm.getTextUser(user), "name: user" + user,
                "При наведенни на картинку текст не совпадает");
        assertTrue(hoversForm.isUrlProfile(user), "Ссылка на профиль не отображается");
        String urlProfile = hoversForm.getUrl(user);
        LOG.info("Click user label");
        hoversForm.clickUrl(user);
        assertEquals(DriverUtilities.getCurrentUrl(), urlProfile,
                "URL не соответствует ссылке из шага 2");
        LOG.info("Back to the previous page");
        DriverUtilities.goToBack();
        assertTrue(hoversForm.isDisplayed(), "Страница Hovers не загрузилась");
    }
}