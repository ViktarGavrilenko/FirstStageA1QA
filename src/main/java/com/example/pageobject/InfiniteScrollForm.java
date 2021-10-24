package com.example.pageobject;

import com.example.config.ConfigurationProperties;
import com.example.elements.Form;
import com.example.elements.TextField;
import org.openqa.selenium.By;

import java.util.Properties;

import static com.example.core.DriverUtilities.manageTimeout;
import static com.example.core.DriverUtilities.scrollDownPageJS;

public class InfiniteScrollForm extends BaseForm {
    protected static final Properties TEST_DATA_PROPERTIES =
            ConfigurationProperties.createProperties("testData.properties");
    private static final int ENGINEER_AGE = Integer.parseInt(TEST_DATA_PROPERTIES.getProperty("engineer.age"));

    private static final Form FORM = new Form(By.xpath("//div[@class='example']//h3"), "InfiniteScrollForm");
    private final TextField LAST_PARAGRAPH =
            new TextField(getLocatorOfLastParagraph(ENGINEER_AGE), "Paragraphs");

    private static final By TEXT_PARAGRAPHS = By.xpath("//div[@class='jscroll-inner']/div");

    public InfiniteScrollForm() {
        super(FORM, "InfiniteScroll");
    }

    private By getLocatorOfLastParagraph(int engineerAge) {
        return By.xpath(String.format("//div[@class='jscroll-added'][%s]", engineerAge));
    }

    public void goDownPage(int engineerAge) {
        manageTimeout(100);
        for (int i = 0; i < engineerAge * 3; i++) {
            if (LAST_PARAGRAPH.isElementOnPage()) {
                break;
            } else {
                scrollDownPageJS();
            }
        }
        manageTimeout(10000);
    }

    public int getNumberParagraphsInfiniteScroll() {
        return LAST_PARAGRAPH.getNumberParagraphs(TEXT_PARAGRAPHS);
    }
}
