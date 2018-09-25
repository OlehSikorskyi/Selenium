package com.epam.lab.POMGmail.PageObjects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends WebElementsInitialization {
    private final static Logger LOG = LogManager.getLogger(LoginPage.class);

    @FindBy(id = "identifierId")
    private WebElement userName;

    @FindBy(css = "input[name='password']")
    private WebElement password;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    private void enterUserNameAndSubmit(String userName) {
        this.userName.sendKeys(userName);
        this.userName.sendKeys(Keys.ENTER);
        LOG.info("> UserName typed correctly");
    }

    private void enterPasswordAndSubmit(String passwprd) {
        this.password.sendKeys(passwprd);
        this.password.sendKeys(Keys.ENTER);
        LOG.info("> Entered valid password");
    }

    public void loginToGmail(String userName, String password) {
        enterUserNameAndSubmit(userName);
        enterPasswordAndSubmit(password);
    }
}