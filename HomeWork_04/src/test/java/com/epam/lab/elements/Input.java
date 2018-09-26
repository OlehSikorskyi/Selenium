package com.epam.lab.elements;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public class Input extends Element {

    public Input(WebElement webElement) {
        super(webElement);
    }

    public void clearTypeAndSubmit(String input) {
        webElement.clear();
        webElement.sendKeys(input);
        webElement.sendKeys(Keys.ENTER);
    }
}