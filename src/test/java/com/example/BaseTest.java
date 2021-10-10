package com.example;

import com.example.core.DriverManager;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseTest extends Assert {
    private static final Logger LOG = Logger.getLogger(HorizontalSliderTest.class);

    @BeforeTest
    public void writeRunTestToLog(){
        LOG.info("Run the test");
    }
    @AfterTest
    public void writeCompleteTestToLog(){
        LOG.info("Test completed");
    }

    @AfterClass
    public void tearDown() {
        DriverManager.close();
    }
}
