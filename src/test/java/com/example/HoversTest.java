package com.example;

import com.example.config.TestDataProperties;
import com.example.core.DriverUtilities;
import com.example.page_object.HoversForm;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class HoversTest extends BaseTest {

    @DataProvider
    public Object[][] dataForFile() {
        return new Object[][]{{1}, {3}};
    }

    @Test(dataProvider = "dataForFile", description = "Тест формы с наведением мыши на пользователей")
    public void testHoversTest(int user) {
        DriverUtilities.goToUrl(TestDataProperties.getInstance().getMainPage() +
                TestDataProperties.getInstance().getHoversPage());
        HoversForm hoversForm = new HoversForm();
        assertTrue(hoversForm.isDisplayed(), "Проверяем загрузилась ли страница Hovers");
        assertEquals(hoversForm.getTextUser(user), "name: user" + user,
                "Проверяем текс после наведения на картинку");
        assertTrue(hoversForm.isUrlProfile(user), "Проверяем отображается ли ссылка на профиль");
        String urlProfile = hoversForm.getUrl(user);
        hoversForm.clickUrl(user);
        assertEquals(DriverUtilities.getCurrentUrl(), urlProfile,
                "Сверяем что текущий URL соответствует ссылке из шага 2");
        DriverUtilities.goToBack();
        assertTrue(hoversForm.isDisplayed(), "Проверяем загрузилась ли страница Hovers");
    }
}
