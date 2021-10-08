package com.example;

import com.example.page_object.BasicAuth;
import org.testng.annotations.Test;

public class BasicAuthTest extends BaseTest {
    public static final String text = "Congratulations! You must have the proper credentials.";

    @Test(description = "Тест формы авторизации")
    public void testBasicAuth() {

        BasicAuth basicAuth = new BasicAuth();
        basicAuth.userAuthorization("admin", "admin");
        assertEquals(basicAuth.getTextAuthorized(), text, "Проверка авторизации на странице BasicAuth");

    }

}