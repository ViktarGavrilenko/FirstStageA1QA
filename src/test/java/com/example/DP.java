package com.example;

import org.testng.annotations.DataProvider;

public class DP {
    @DataProvider (name = "hovers")
    public static Object[][] dataForFile() {
        return new Object[][]{{1}, {3}};
    }
}
