package com.example.page_object;

import com.example.core.DriverManager;
import org.openqa.selenium.By;

public class MainPage {
    private By homePageTitle = By.xpath("//div[@class='home_cluster_ctn home_ctn']");  //div[@class='logo']
    private By searchField = By.xpath("//input[@id='store_nav_search_term']");
    private By searchBtn = By.xpath("//a[@id='store_search_link']//img");

    public MainPage() {
    }

    public boolean isHomePageTitleDisplayed() {
        return DriverManager.getDriver().findElement(homePageTitle).isDisplayed();
    }

    public void inputDataIntoSearch(String data) {
        DriverManager.getDriver().findElement(searchField).sendKeys(data);
    }

    public void clickSearchBtn() {
        DriverManager.getDriver().findElement(searchBtn).click();
    }

}
