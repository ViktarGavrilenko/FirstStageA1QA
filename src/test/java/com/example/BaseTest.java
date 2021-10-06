package com.example;

import com.example.core.DriverUtilities;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class BaseTest extends Assert {

    @AfterClass
    public void tearDown() {
        DriverUtilities.close();
    }
}
