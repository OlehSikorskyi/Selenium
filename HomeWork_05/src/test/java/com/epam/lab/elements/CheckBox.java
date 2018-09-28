package com.epam.lab.elements;

import org.openqa.selenium.WebElement;

public class CheckBox extends AbstractElement.Element {

    public CheckBox(WebElement webElement) {
        super(webElement);
    }

    public void setChecked(boolean value) {
        if (value != isChecked()) {
            webElement.click();
        }
    }

    private boolean isChecked() {
        return webElement.isSelected();
    }
}