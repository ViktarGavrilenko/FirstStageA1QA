package com.example;

import com.example.config.ConfigurationProperties;
import com.example.core.DriverManager;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

import java.util.Properties;

public class BaseTest extends Assert {
    private static final Logger LOG = Logger.getLogger(HorizontalSliderTest.class);
    public static final Properties testDataProperties =
            ConfigurationProperties.createProperties("testData.properties");

    @BeforeClass
    public void initializationDriver() {
        DriverManager.createDriver();
    }

    @BeforeTest
    public void writeRunTestToLog() {
        LOG.info("Run the test");
    }

    @AfterTest
    public void writeCompleteTestToLog() {
        LOG.info("Test completed");
    }

    @AfterClass
    public void tearDown() {
        DriverManager.close();
    }
}
