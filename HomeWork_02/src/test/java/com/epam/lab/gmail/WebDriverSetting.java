package com.epam.lab.gmail;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;

public class WebDriverSetting {
    public WebDriver driver;
    public static final String USER_DIR = "user.dir";
    public static final String CHROME_DRIVER_PATH = "\\src\\main\\resources\\chromedriver.exe";

    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", System.getProperty(USER_DIR) + CHROME_DRIVER_PATH);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @AfterTest
    public void close() {
        driver.quit();
    }
}