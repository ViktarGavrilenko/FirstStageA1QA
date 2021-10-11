package com.example.page_object;

import com.example.elements.Form;
import com.example.elements.HorizontalSlider;
import com.example.elements.TextField;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;

import static com.example.utils.ArithmeticUtils.valueForSlider;

public class HorizontalSliderForm extends BaseForm {
    private static final Logger LOG = Logger.getLogger(HorizontalSliderForm.class);

    private static final Form FORM = new Form(By.xpath("//div[@id='content']"), "HorizontalSliderForm");
    private static final HorizontalSlider SLIDER =
            new HorizontalSlider(By.xpath("//div[@class='sliderContainer']//input"), "HorizontalSlider");
    private static final TextField VALUE_SLIDER = new TextField(By.xpath("//span[@id='range']"), "ValueSlider");

    public HorizontalSliderForm() {
        super(FORM, "HorizontalSlider");
    }

    public void SetRandomValueSlider() {
        float minValue = Float.parseFloat(SLIDER.getAttribute("min"));
        float maxValue = Float.parseFloat(SLIDER.getAttribute("max"));
        int sliderHeight = SLIDER.getSizeHeight();
        int sliderWidth = SLIDER.getSizeWidth();
        SLIDER.click(valueForSlider(sliderWidth, maxValue * 2, minValue), sliderHeight / 2);
        LOG.info("Set a random value on the slider");
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

        if (value >= minValue && value <= maxValue) {
            return true;
        } else {
            return false;
        }
    }
}
