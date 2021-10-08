package com.example.page_object;

import com.example.core.DriverUtilities;
import com.example.elements.Form;
import com.example.elements.TextField;
import org.openqa.selenium.By;

public class BasicAuth extends BaseForm {
    private static Form form = new Form(By.xpath("//div[@id='content']"), "BasicAuth");
    private static TextField textAuthorized = new TextField(By.xpath("//div[@class='example']//p"), "BasicAuthText");

    public BasicAuth() {
        super(form, "BasicAuthForm");
    }

    public String getTextAuthorized() {
        return textAuthorized.getText();
    }

    public void userAuthorization(String login, String password) {
        String url = String.format("http://%s:%s@the-internet.herokuapp.com/basic_auth", login, password);
        DriverUtilities.goToUrl(url);
    }

}
