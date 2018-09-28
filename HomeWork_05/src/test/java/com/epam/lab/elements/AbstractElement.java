package com.epam.lab.elements;

import org.openqa.selenium.WebElement;

public interface AbstractElement {

    class Element implements AbstractElement {
        WebElement webElement;

        Element(WebElement webElement) {
            this.webElement = webElement;
        }

        public void click() {
            webElement.click();
        }

        public String getText() {
            return webElement.getText();
        }
    }
}