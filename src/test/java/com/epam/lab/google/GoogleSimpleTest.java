package com.epam.lab.google;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class GoogleSimpleTest extends SetupWebDriver {
    private String expectedTitle = "Apple - Пошук Google";

    @Test
    public void shouldNavigateToGoogleWebSiteAndSearchApple() {
        System.setProperty("webdriver.chrome.driver", System.getProperty(USER_DIR) + CHROME_DRIVER_PATH);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.google.com.ua/");
        WebElement searchField = driver.findElement(By.xpath("//input[@name=\"q\"]"));
        searchField.clear();
        searchField.sendKeys("Apple");
        searchField.sendKeys(Keys.RETURN);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Assert.assertEquals(driver.getTitle(), expectedTitle);
    }
}