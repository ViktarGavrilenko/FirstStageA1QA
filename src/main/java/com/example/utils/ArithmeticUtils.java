package com.example.utils;

public class ArithmeticUtils {
    public static final int NUMBER_OF_VALUES_ON_SLIDER = 10;

    public static int valueForSlider(int sliderWidth, float maxValue, float minValue) {
        return (int) ((Math.random() * NUMBER_OF_VALUES_ON_SLIDER) * sliderWidth / (maxValue - minValue));
    }
}
