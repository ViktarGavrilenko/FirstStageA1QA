package com.example;

import com.example.config.TestDataProperties;
import com.example.core.DriverUtilities;
import com.example.page_object.MainPage;
import com.example.page_object.SearchPage;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class MainPageTest extends BaseTest {

    @DataProvider
    public Object[][] dataForTest() {
        return new Object[][]{
                {TestDataProperties.getInstance().getFirstGame(), TestDataProperties.getInstance().getFirstN()},
                {TestDataProperties.getInstance().getSecondGame(), TestDataProperties.getInstance().getSecondN()},
        };
    }

    @Test(dataProvider = "dataForTest")
    public void testSteamPowered(String gameName, int count) {
        DriverUtilities.goToUrl();
        MainPage mainPage = new MainPage();
        assertTrue(mainPage.isHomePageTitleDisplayed(), "Проверка открытия главной страницы");
        mainPage.inputDataIntoSearch(gameName);
        mainPage.clickSearchBtn();
        SearchPage searchPage = new SearchPage();
        assertTrue(searchPage.isSearchPageTitleDisplayed(), "Проверка открытия страницы с результатами поиска");
        assertTrue(searchPage.isGamesListNotEmpty(), "Проверяем, что список найденных игр не пустой");
        searchPage.clickSortPriceDesc();
        assertTrue(searchPage.checkPriceDesc(searchPage.getGamePrice(count)), "Проверяем, что игры " +
                "отсортированы корректно");
    }

}