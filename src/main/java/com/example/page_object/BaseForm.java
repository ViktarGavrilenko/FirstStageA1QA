package com.example.page_object;

import com.example.elements.BaseElement;
import org.apache.log4j.Logger;

public abstract class BaseForm {
    private static final Logger LOG = Logger.getLogger(BaseForm.class);
    private BaseElement element;
    private String name;

    BaseForm(BaseElement element, String name) {
        LOG.info(name + " page is open");
        this.element = element;
        this.name = name;
    }

    public boolean isDisplayed() {
        return element.isDisplayed();
    }
}
