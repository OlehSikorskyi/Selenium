package com.epam.lab.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public class WebDriverPool {

    private WebDriverPool() {
    }

    private static WebDriverPool instance = new WebDriverPool();

    public static WebDriverPool getInstance()
    {
        return instance;
    }

    private static  ThreadLocal<WebDriver> webDriverPool = new ThreadLocal<WebDriver>(){
        @Override
        protected WebDriver initialValue() {
            ConfigFileReader configFileReader = new ConfigFileReader();
            System.setProperty("webdriver.chrome.driver", configFileReader.getDriverPath());
            WebDriver driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(configFileReader.getImplicitlyWait(), TimeUnit.SECONDS);
            return driver;
        }
    };

    public WebDriver getDriver() {
        return webDriverPool.get();
    }

    public void removeDriver() {
        webDriverPool.get().quit();
        webDriverPool.remove();
    }

    @AfterClass
    public void tearDown() {
        WebDriverPool.getInstance().removeDriver();
    }
}