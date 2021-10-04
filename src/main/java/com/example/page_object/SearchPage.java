package com.example.page_object;

import com.example.core.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class SearchPage {
    private By sortBy = By.xpath("//a[@id='sort_by_trigger']");
    private By sortPriceDesc = By.xpath("//a[@id='Price_DESC']");
    private By searchPageTitle = By.xpath("//div[@class='searchbar']");
    private By searchPriceGame =
            By.xpath("//div[contains(@class,'search_price') and not(contains(@class,'discount_combined'))]");
    private By blockWithGame = By.xpath("//div[@id='search_resultsRows']//a");

    public SearchPage() {

    }

    public boolean isSearchPageTitleDisplayed() {
        return DriverManager.getDriver().findElement(searchPageTitle).isDisplayed();
    }

    public void clickSortPriceDesc() {
        DriverManager.getDriver().findElement(sortBy).click();
        DriverManager.getDriver().findElement(sortPriceDesc).click();
    }

    public boolean isGamesListNotEmpty() {
        return !DriverManager.getDriver().findElements(blockWithGame).isEmpty();
    }

    public List getPriceGame(int count) {
        DriverManager.getDriver().navigate().to(DriverManager.getDriver().getCurrentUrl());
        List<WebElement> elementList = DriverManager.getDriver().findElements(searchPriceGame);
        if (elementList.size() < count) {
            count = elementList.size();
        }
        List<Float> priceList = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            String priceText = elementList.get(i).getText();
            float price;
            if (priceText.equals("") || priceText.toLowerCase().contains("free") ||
                    priceText.toLowerCase().contains("бесплатно")) {
                price = 0;
            } else {
                price = Float.parseFloat(priceText.substring(priceText.lastIndexOf("$") + 1));
            }
            priceList.add(price);
        }
        return priceList;
    }

    public boolean checkPriceDesc(List<Float> priceList) {
        for (int i = 0; i < priceList.size() - 1; i++) {
            if (!(priceList.get(i) >= priceList.get(i + 1))) {
                return false;
            }
        }
        return true;
    }
}
