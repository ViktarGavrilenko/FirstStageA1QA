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

import java.util.Properties;

public class DriverFactory {
    private static final Logger LOG = Logger.getLogger(DriverFactory.class);

    public static WebDriver createDriver() {
        Properties configProperties =
                ConfigurationProperties.createProperties("configuration.properties");
        DesiredCapabilities capabilities;
        WebDriver driver = null;
        switch (BrowserType.valueOf(configProperties.getProperty("browser.type"))) {
            case CHROME:
                WebDriverManager.chromedriver().setup();
                capabilities = DesiredCapabilities.chrome();
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--lang=" + configProperties.getProperty("locale"));
                capabilities.setCapability(ChromeOptions.CAPABILITY, options);
                driver = new ChromeDriver(capabilities);
                break;
            case FIREFOX:
                WebDriverManager.firefoxdriver().setup();
                capabilities = DesiredCapabilities.firefox();
                FirefoxOptions optionsFirefox = new FirefoxOptions();
                FirefoxProfile profile = new FirefoxProfile();
                profile.setPreference("intl.accept_languages", configProperties.getProperty("locale"));
                optionsFirefox.setProfile(profile);
                capabilities.setCapability(FirefoxOptions.FIREFOX_OPTIONS, optionsFirefox);
                driver = new FirefoxDriver(capabilities);
                break;
            default:
                LOG.info("Browser name " + configProperties.getProperty("browser.type") + " is incorrect");
        }
        return driver;
    }
}