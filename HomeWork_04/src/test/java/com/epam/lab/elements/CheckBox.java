package com.epam.lab.elements;

import org.openqa.selenium.WebElement;
import java.util.List;

public class CheckBox extends Element {

    public CheckBox(WebElement webElement) {
        super(webElement);
    }

    public void setChecked(Boolean value, List<WebElement> list, int... args) {
        if (value != isChecked()) {
            for (int i : args) {
                list.get(i).click();
            }
        }
    }

    private boolean isChecked() {
        return webElement.isSelected();
    }
}