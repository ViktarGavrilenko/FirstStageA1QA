package com.example.page_object;

import com.example.elements.Form;
import com.example.elements.TextField;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;

public class BasicAuthForm extends BaseForm {
    private static final Logger LOG = Logger.getLogger(BasicAuthForm.class);
    private static final Form FORM = new Form(By.xpath("//div[@id='content']"), "BasicAuthForm");
    private static final TextField TEXT_AUTHORIZED = new TextField(By.xpath("//div[@class='example']//p"),
            "BasicAuthText");

    public BasicAuthForm() {
        super(FORM, "BasicAuthForm");
    }

    public String getTextAuthorized() {
        return TEXT_AUTHORIZED.getText();
    }
}