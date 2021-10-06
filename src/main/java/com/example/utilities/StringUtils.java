package com.example.utilities;

public class StringUtils {
    public static Float getPriceFromString(String str) {
        float price;
        if (!str.contains("$")) {
            price = 0;
        } else {
            price = Float.parseFloat(str.substring(str.lastIndexOf("$") + 1));
        }
        return price;
    }

}
