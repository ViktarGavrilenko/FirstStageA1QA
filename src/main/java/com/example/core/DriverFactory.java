package com.example.core;

import com.example.config.ConfigurationProperties;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.concurrent.TimeUnit;

public class DriverFactory {
    public static WebDriver createDriver() {
        ConfigurationProperties configProperties = ConfigurationProperties.getInstance();
        DesiredCapabilities capabilities = null;
        WebDriver driver = null;
        switch (configProperties.getBrowserType()) {
            case CHROME:
                WebDriverManager.chromedriver().setup();
                capabilities = DesiredCapabilities.chrome();
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--start-maximized");
                options.addArguments("--lang=" + configProperties.getLocale());
                capabilities.setCapability(ChromeOptions.CAPABILITY, options);
                driver = new ChromeDriver(capabilities);
                driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                break;
            case FIREFOX:
                break;

        }
        return driver;
    }
}
