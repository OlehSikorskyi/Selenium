package com.epam.lab.google;

import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class SetupWebDriver {
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
