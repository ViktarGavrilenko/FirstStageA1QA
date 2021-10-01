package com.example;

import com.example.core.DriverUtilities;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;

public class BaseTest extends Assert {

    @BeforeMethod
    public void refreshPage() {
        DriverUtilities.goToUrl();
    }

    @AfterClass
    public void tearDown() {
        DriverUtilities.close();
    }
}
