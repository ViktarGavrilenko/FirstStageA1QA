package com.example.config;

import ru.qatools.properties.Property;
import ru.qatools.properties.PropertyLoader;
import ru.qatools.properties.Resource;

@Resource.Classpath("testData.properties")
public class TestDataProperties {

    @Property("main.page")
    private String mainPage;

    @Property("basic.auth.page")
    private String basicAuthPage;

    @Property("javascript.alerts.page")
    private String javascriptAlertsPage;

    @Property("horizontal.slider.page")
    private String horizontalSlidePage;

    @Property("iframe.page")
    private String iframePage;


    private static TestDataProperties testDataProperties;

    private TestDataProperties() {
        PropertyLoader.newInstance().populate(this);
    }

    public static TestDataProperties getInstance() {
        if (testDataProperties == null) {
            testDataProperties = new TestDataProperties();
        }
        return testDataProperties;
    }

    public String getMainPage() {
        return mainPage;
    }

    public String getBasicAuthPage() {
        return basicAuthPage;
    }

    public String getJavascriptAlertsPage() {
        return javascriptAlertsPage;
    }

    public String getHorizontalSlidePage() {
        return horizontalSlidePage;
    }

    public String getIframePage() {
        return iframePage;
    }
}
