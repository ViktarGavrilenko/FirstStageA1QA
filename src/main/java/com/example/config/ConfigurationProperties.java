package com.example.config;

import com.example.core.BrowserType;
import ru.qatools.properties.Property;
import ru.qatools.properties.PropertyLoader;
import ru.qatools.properties.Resource;


@Resource.Classpath("configuration.properties")
public class ConfigurationProperties {

    @Property("main.page")
    private String mainPage;

    @Property("browser.type")
    private BrowserType browserType;

    @Property("locale")
    private String locale;

    private static ConfigurationProperties configProperties;

    private ConfigurationProperties() {
        PropertyLoader.newInstance().populate(this);
    }

    public static ConfigurationProperties getInstance() {
        if (configProperties == null) {
            configProperties = new ConfigurationProperties();
        }
        return configProperties;
    }

    public String getMainPage() {
        return mainPage;
    }

    public BrowserType getBrowserType() {
        return browserType;
    }

    public String getLocale() {
        return locale;
    }

}
