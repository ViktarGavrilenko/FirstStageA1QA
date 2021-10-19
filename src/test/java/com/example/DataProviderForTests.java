package com.example;

import org.testng.annotations.DataProvider;

public class DataProviderForTests {
    @DataProvider(name = "hovers")
    public static Object[][] dataForFile() {
        return new Object[][]{{1}, {3}};
    }
}