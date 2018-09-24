package com.epam.lab.POMGmail.Tests;

import com.epam.lab.POMGmail.ConfigFileReader;
import com.epam.lab.POMGmail.PageObjects.LoginPage;
import com.epam.lab.POMGmail.PageObjects.MainInboxPage;
import com.epam.lab.POMGmail.WebDriverSetting;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class DeleteInboxMessageTest extends WebDriverSetting {
    private ConfigFileReader configFileReader;

    @Parameters({"login", "password"})
    @Test
    public void deleteInboxMessage(String login, String password) {
        configFileReader = new ConfigFileReader();
        driver.get(configFileReader.getApplicationUrl());
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginToGmail(login, password);
        MainInboxPage mainInboxPage = new MainInboxPage(driver);
        mainInboxPage.selectThreeEmailDeleteAndPressUndoButton();
        Assert.assertEquals(mainInboxPage.initEmailQuantity, mainInboxPage.emailQuantityAfterDeleting);
    }
}