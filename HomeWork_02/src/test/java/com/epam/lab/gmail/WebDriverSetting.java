package com.epam.lab.gmail;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

public class WebDriverSetting {
    private static final String USER_DIR = "user.dir";
    private static final String CHROME_DRIVER_PATH = "\\src\\main\\resources\\chromedriver.exe";
    static long timeouts = 30;
    WebDriver driver;

    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", System.getProperty(USER_DIR) + CHROME_DRIVER_PATH);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(timeouts, TimeUnit.SECONDS);
    }

    @AfterTest
    public void close() {
        driver.quit();
    }
}