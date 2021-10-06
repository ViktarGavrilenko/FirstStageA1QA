package com.example.page_object;

import com.example.core.DriverManager;
import org.openqa.selenium.By;

public class MainPage {
    private static final By HOME_PAGE_TITLE = By.xpath("//div[@class='home_cluster_ctn home_ctn']");
    private static final By SEARCH_FIELD = By.xpath("//input[@id='store_nav_search_term']");
    private static final By SEARCH_BTN = By.xpath("//a[@id='store_search_link']//img");

    public MainPage() {
    }

    public boolean isHomePageTitleDisplayed() {
        return !DriverManager.getDriver().findElements(HOME_PAGE_TITLE).isEmpty();
    }

    public void inputDataIntoSearch(String data) {
        DriverManager.getDriver().findElement(SEARCH_FIELD).sendKeys(data);
    }

    public void clickSearchBtn() {
        DriverManager.getDriver().findElement(SEARCH_BTN).click();
    }

}
