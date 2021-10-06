package com.example.page_object;

import com.example.core.DriverManager;
import com.google.common.collect.Ordering;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

import static com.example.utilities.StringUtils.getPriceFromString;

public class SearchPage {
    private static final By SORT_BY = By.xpath("//a[@id='sort_by_trigger']");
    private static final By SORT_PRICE_DESC = By.xpath("//a[@id='Price_DESC']");
    private static final By SEARCH_PAGE_TITLE = By.xpath("//div[@class='searchbar']");
    private static final By SEARCH_PRICE_GAME =
            By.xpath("//div[contains(@class,'search_price') and not(contains(@class,'discount_combined'))]");
    private static final By BLOCK_WITH_GAME = By.xpath("//div[@id='search_resultsRows']//a");

    public SearchPage() {

    }

    public boolean isSearchPageTitleDisplayed() {
        return DriverManager.getDriver().findElement(SEARCH_PAGE_TITLE).isDisplayed();
    }

    public void clickSortPriceDesc() {
        DriverManager.getDriver().findElement(SORT_BY).click();
        DriverManager.getDriver().findElement(SORT_PRICE_DESC).click();
    }

    public boolean isGamesListNotEmpty() {
        return !DriverManager.getDriver().findElements(BLOCK_WITH_GAME).isEmpty();
    }

    public List<Float> getGamePrice(int count) {
        DriverManager.getDriver().navigate().to(DriverManager.getDriver().getCurrentUrl());
        List<WebElement> elementList = DriverManager.getDriver().findElements(SEARCH_PRICE_GAME);
        if (elementList.size() < count) {
            count = elementList.size();
        }
        List<Float> priceList = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            priceList.add(getPriceFromString(elementList.get(i).getText()));
        }
        return priceList;
    }

    public boolean checkPriceDesc(List<Float> priceList) {
        return Ordering.natural().reverse().isOrdered(priceList);
    }
}
