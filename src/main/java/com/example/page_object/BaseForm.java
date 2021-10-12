package com.example.page_object;

import com.example.elements.BaseElement;

public abstract class BaseForm {
    private BaseElement element;
    private String name;

    BaseForm(BaseElement element, String name) {
        this.element = element;
        this.name = name;
    }

    public boolean isDisplayed() {
        return element.isDisplayed();
    }
}
