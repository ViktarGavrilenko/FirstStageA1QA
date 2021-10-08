package com.example.core;

import com.example.config.ConfigurationProperties;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.concurrent.TimeUnit;

public class DriverFactory {

    private static final Logger log = Logger.getLogger(DriverFactory.class);

    public static WebDriver createDriver() {
        ConfigurationProperties configProperties = ConfigurationProperties.getInstance();
        DesiredCapabilities capabilities;
        WebDriver driver = null;
        switch (configProperties.getBrowserType()) {
            case CHROME:
                WebDriverManager.chromedriver().setup();
                capabilities = DesiredCapabilities.chrome();
                ChromeOptions options = new ChromeOptions();
//                options.addArguments("--start-maximized");
                options.addArguments("--lang=" + configProperties.getLocale());
                capabilities.setCapability(ChromeOptions.CAPABILITY, options);
                driver = new ChromeDriver(capabilities);
                break;
            case FIREFOX:
                WebDriverManager.firefoxdriver().setup();
                capabilities = DesiredCapabilities.firefox();
                FirefoxOptions optionsFirefox = new FirefoxOptions();
                FirefoxProfile profile = new FirefoxProfile();
                profile.setPreference("intl.accept_languages", configProperties.getLocale());
                optionsFirefox.setProfile(profile);
                capabilities.setCapability(FirefoxOptions.FIREFOX_OPTIONS, optionsFirefox);
                driver = new FirefoxDriver(capabilities);
                break;
            default:
                throw new IllegalArgumentException("Browser not supported");
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return driver;
    }
}
