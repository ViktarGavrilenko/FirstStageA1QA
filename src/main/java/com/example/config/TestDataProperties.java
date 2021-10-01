package com.example.config;

import ru.qatools.properties.Property;
import ru.qatools.properties.PropertyLoader;
import ru.qatools.properties.Resource;

@Resource.Classpath("testdata.properties")
public class TestDataProperties {

    @Property("first.game")
    private String firstGame;

    @Property("first.N")
    private int firstN;

    @Property("second.game")
    private String secondGame;

    @Property("second.N")
    private int secondN;

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


    public String getFirstGame() {
        return firstGame;
    }

    public int getFirstN() {
        return firstN;
    }

    public String getSecondGame() {
        return secondGame;
    }

    public int getSecondN() {
        return secondN;
    }
}
