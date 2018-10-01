package com.epam.lab.elements;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public class TextInput extends AbstractElement.Element {

    public TextInput(WebElement webElement) {
        super(webElement);
    }

    public void clearAndType(String input) {
        webElement.clear();
        webElement.sendKeys(input);
    }

    public void submit() {
        webElement.sendKeys(Keys.ENTER);
    }
}