package com.epam.lab.google;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class GoogleSimpleTest extends SetupWebDriver {
    private String expectedTitle = "Apple - Пошук Google";

    @Test
    public void shouldNavigateToGoogleWebSiteAndSearchApple() {
        driver.get("https://www.google.com.ua/");
        WebElement searchField = driver.findElement(By.xpath("//input[@name=\"q\"]"));
        searchField.clear();
        searchField.sendKeys("Apple");
        searchField.sendKeys(Keys.RETURN);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Assert.assertEquals(driver.getTitle(), expectedTitle);
    }
}