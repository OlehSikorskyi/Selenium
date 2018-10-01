package com.epam.lab.pageobject;

import com.epam.lab.elements.TextInput;
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
    private TextInput userName;

    @FindBy(css = "input[name='password']")
    private TextInput password;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void enterUserNameAndSubmit(String userName) {
        LOG.info("> UserName typed correctly");
        this.userName.clearAndType(userName);
        this.userName.submit();
    }

    public void enterPasswordAndSubmit(String password) {
        LOG.info("> Entered valid password");
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input[name='password']")));
        this.password.clearAndType(password);
        this.password.submit();
    }
}