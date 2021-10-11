package com.example;

import com.example.page_object.BasicAuthForm;
import org.testng.annotations.Test;

public class BasicAuthTest extends BaseTest {

    public static final String TEXT = "Congratulations! You must have the proper credentials.";

    @Test(description = "Тест формы авторизации")
    public void testBasicAuth() {
        BasicAuthForm basicAuth = new BasicAuthForm();
        basicAuth.userAuthorization("admin", "admin");
        assertEquals(basicAuth.getTextAuthorized(), TEXT, "Проверка авторизации на странице BasicAuth");
    }
}