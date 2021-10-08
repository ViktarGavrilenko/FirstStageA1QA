package com.example.page_object;

import com.example.core.DriverManager;
import com.example.elements.BaseElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public abstract class BaseForm {
    private BaseElement element;
    private String name;

    BaseForm(BaseElement element, String name){
        this.element = element;
        this.name = name;
    }

    protected BaseForm() {
    }

    public boolean isDisplayed(){
        return element.isDisplayed();
    }

    public void waitForOpen() {

    }

}
