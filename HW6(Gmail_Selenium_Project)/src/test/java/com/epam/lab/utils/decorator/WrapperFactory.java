package com.epam.lab.utils.decorator;

import com.epam.lab.elements.AbstractElement;
import org.openqa.selenium.WebElement;

class WrapperFactory {
    static AbstractElement createInstance(Class<AbstractElement> clazz, WebElement element) {
        try {
            return clazz.getConstructor(WebElement.class).newInstance(element);
        } catch (Exception e) {
            throw new AssertionError(
                    "WebElement can't be represented as " + clazz
            );
        }
    }
}