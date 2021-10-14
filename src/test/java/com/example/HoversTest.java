package com.example;

import com.example.core.DriverUtilities;
import com.example.page_object.HoversForm;
import org.apache.log4j.Logger;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class HoversTest extends BaseTest {

    private static final Logger LOG = Logger.getLogger(HoversTest.class);

    @DataProvider
    public Object[][] dataForFile() {
        return new Object[][]{{1}, {3}};
    }

    @Test(dataProvider = "dataForFile", description = "Тест формы с наведением мыши на пользователей")
    public void testHoversTest(int user) {
        LOG.info("Navigate to URL" + testDataProperties.getProperty("main.page") +
                testDataProperties.getProperty("hovers.page"));
        DriverUtilities.goToUrl(testDataProperties.getProperty("main.page") +
                testDataProperties.getProperty("hovers.page"));
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
