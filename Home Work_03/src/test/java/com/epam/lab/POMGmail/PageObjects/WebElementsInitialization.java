package com.epam.lab.POMGmail.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

class WebElementsInitialization {
    WebDriver driver;

    WebElementsInitialization(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}