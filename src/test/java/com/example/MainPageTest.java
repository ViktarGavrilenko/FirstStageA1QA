package com.example;

import com.example.config.TestDataProperties;
import com.example.page_object.MainPage;
import com.example.page_object.SearchPage;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class MainPageTest extends BaseTest {

    public static MainPage mainPage;
    public static SearchPage searchPage;

    @DataProvider
    public Object[][] dataForTest() {
        return new Object[][]{
                {TestDataProperties.getInstance().getFirstGame(), TestDataProperties.getInstance().getFirstN()},
                {TestDataProperties.getInstance().getSecondGame(), TestDataProperties.getInstance().getSecondN()},
        };
    }

    @Test(dataProvider = "dataForTest")
    public void testSteamPowered(String nameGame, int count) {
        mainPage = new MainPage();
        assertTrue(mainPage.isHomePageTitleDisplayed());
        mainPage.inputDataIntoSearch(nameGame);
        mainPage.clickSearchBtn();
        searchPage = new SearchPage();
        assertTrue(searchPage.isSearchPageTitleDisplayed());
        assertTrue(searchPage.isGamesListNotEmpty());
        searchPage.clickSortPriceDesc();
        assertTrue(searchPage.checkPriceDesc(searchPage.getPriceGame(count)));
    }

}