package com.epam.lab.pageobject;

import com.epam.lab.elements.Input;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends WebElementsInitialization {
    private final static Logger LOG = LogManager.getLogger(LoginPage.class);
    private WebDriverWait wait = new WebDriverWait(driver, 30);

    @FindBy(id = "identifierId")
    private Input userName;

    @FindBy(css = "input[name='password']")
    private Input password;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    private void enterUserNameAndSubmit(String userName) {
        this.userName.clearTypeAndSubmit(userName);
        LOG.info("> UserName typed correctly");
    }

    private void enterPasswordAndSubmit(String password) {
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input[name='password']")));
        this.password.clearTypeAndSubmit(password);
        LOG.info("> Entered valid password");
    }

    public void loginToGmail(String userName, String password) {
        enterUserNameAndSubmit(userName);
        enterPasswordAndSubmit(password);
    }
}