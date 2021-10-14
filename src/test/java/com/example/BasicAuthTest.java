package com.example;

import com.example.page_object.BasicAuthForm;
import org.apache.log4j.Logger;
import org.testng.annotations.Test;

public class BasicAuthTest extends BaseTest {

    private static final Logger LOG = Logger.getLogger(BasicAuthTest.class);
    public static final String TEXT = "Congratulations! You must have the proper credentials.";

    @Test(description = "Тест формы авторизации")
    public void testBasicAuth() {
        BasicAuthForm basicAuth = new BasicAuthForm();
        LOG.info("Navigate to URL " + testDataProperties.getProperty("main.page") +
                testDataProperties.getProperty("basic.auth.page") + "and pass basic authorization credentials");
        basicAuth.userAuthorization(testDataProperties.getProperty("login"),
                testDataProperties.getProperty("password"));
        assertEquals(basicAuth.getTextAuthorized(), TEXT, "Проверка авторизации на странице BasicAuth");
    }
}