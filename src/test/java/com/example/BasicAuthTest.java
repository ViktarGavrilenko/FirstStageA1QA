package com.example;

import com.example.pageobject.BasicAuthForm;
import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import static com.example.core.DriverUtilities.userAuthorization;
import static org.testng.Assert.assertEquals;

public class BasicAuthTest extends BaseTest {

    private static final Logger LOG = Logger.getLogger(BasicAuthTest.class);
    private static final String TEXT = "Congratulations! You must have the proper credentials.";
    private static final String URL = CONFIGURATION_PROPERTIES.getProperty("main.page") +
            TEST_DATA_PROPERTIES.getProperty("basic.auth.page");

    @Test(description = "Тест формы авторизации")
    public void testBasicAuth() {
        BasicAuthForm basicAuth = new BasicAuthForm();
        LOG.info("Navigate to URL " + URL + "and pass basic authorization credentials");
        userAuthorization(TEST_DATA_PROPERTIES.getProperty("login"),
                TEST_DATA_PROPERTIES.getProperty("password"), URL);
        assertEquals(basicAuth.getTextAuthorized(), TEXT, "Авторизации на странице BasicAuth не выполнена");
    }
}