package com.example.pageobject;

import com.example.elements.Form;
import com.example.elements.HorizontalSlider;
import com.example.elements.TextField;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;

public class HorizontalSliderForm extends BaseForm {
    private static final Logger LOG = Logger.getLogger(HorizontalSliderForm.class);

    private static final Form FORM = new Form(By.xpath("//div[@id='content']"), "HorizontalSliderForm");
    private static final HorizontalSlider SLIDER =
            new HorizontalSlider(By.xpath("//div[@class='sliderContainer']//input"), "HorizontalSlider");
    private static final TextField VALUE_SLIDER = new TextField(By.xpath("//span[@id='range']"), "ValueSlider");

    public HorizontalSliderForm() {
        super(FORM, "HorizontalSlider");
    }

    public void setValueSlider(float value) {
        float minValue = Float.parseFloat(SLIDER.getAttribute("min"));
        float maxValue = Float.parseFloat(SLIDER.getAttribute("max"));
        int sliderWidth = SLIDER.getSizeWidth();
        if (value > maxValue || value < minValue) {
            LOG.error("Invalid slider value");
        } else {
            int valueHorizontal = Math.round((value - minValue) * sliderWidth / (maxValue - minValue));
            SLIDER.click(valueHorizontal - sliderWidth / 2, 0);
        }
    }

    public boolean isSliderValueValid() {
        Float value = null;
        float minValue = Float.parseFloat(SLIDER.getAttribute("min"));
        float maxValue = Float.parseFloat(SLIDER.getAttribute("max"));

        try {
            LOG.info("Slider value " + VALUE_SLIDER.getText());
            value = Float.parseFloat(VALUE_SLIDER.getText());
        } catch (NumberFormatException e) {
            LOG.error("Incorrect value in the slider");
        }

        return value >= minValue && value <= maxValue;
    }

    public float getMaxValueSlider() {
        return Float.parseFloat(SLIDER.getAttribute("max"));
    }
}