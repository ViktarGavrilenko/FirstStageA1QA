package com.example.utils;

public class ArithmeticUtils {
    public static int valueForSlider(int sliderWidth, float maxValue, float minValue) {
        return (int) ((Math.random() * 10) * sliderWidth / (maxValue - minValue));
    }
}
