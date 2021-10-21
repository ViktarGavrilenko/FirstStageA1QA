package com.example;

import com.example.config.ConfigurationProperties;
import com.example.core.DriverManager;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.util.Properties;

public class BaseTest extends Assert {
    private static final Logger LOG = Logger.getLogger(HorizontalSliderTest.class);
    protected static final Properties TEST_DATA_PROPERTIES =
            ConfigurationProperties.createProperties("testData.properties");
    protected static final Properties CONFIGURATION_PROPERTIES =
            ConfigurationProperties.createProperties("configuration.properties");

    @BeforeTest
    public void writeRunTestToLog() {
        LOG.info("Run the test");
        DriverManager.createDriver();
    }

    @AfterTest
    public void writeCompleteTestToLog() {
        LOG.info("Test completed");
        DriverManager.close();
    }
}