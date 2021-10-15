package com.example;

import com.example.page_object.BasicAuthForm;
import org.apache.log4j.Logger;
import org.testng.annotations.Test;

public class BasicAuthTest extends BaseTest {

    private static final Logger LOG = Logger.getLogger(BasicAuthTest.class);
    private static final String TEXT = "Congratulations! You must have the proper credentials.";
    private static final String URL = TEST_DATA_PROPERTIES.getProperty("main.page") +
            TEST_DATA_PROPERTIES.getProperty("basic.auth.page");

    @Test(description = "Тест формы авторизации")
    public void testBasicAuth() {
        BasicAuthForm basicAuth = new BasicAuthForm();
        LOG.info("Navigate to URL " + URL + "and pass basic authorization credentials");
        basicAuth.userAuthorization(TEST_DATA_PROPERTIES.getProperty("login"),
                TEST_DATA_PROPERTIES.getProperty("password"), URL);
        assertEquals(basicAuth.getTextAuthorized(), TEXT, "Проверка авторизации на странице BasicAuth");
    }
}