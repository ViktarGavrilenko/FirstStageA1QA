package com.example;

import com.example.page_object.BasicAuth;
import org.apache.log4j.Logger;
import org.testng.annotations.Test;

public class BasicAuthTest extends BaseTest {

    private static final Logger log = Logger.getLogger(BasicAuthTest.class);

    public static final String TEXT = "Congratulations! You must have the proper credentials.";

    @Test(description = "Тест формы авторизации")
    public void testBasicAuth() {
        log.info("Run the test");
        BasicAuth basicAuth = new BasicAuth();
        basicAuth.userAuthorization("admin", "admin");
        assertEquals(basicAuth.getTextAuthorized(), TEXT, "Проверка авторизации на странице BasicAuth");
        log.info("Test completed");
    }

}