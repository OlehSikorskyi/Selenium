package com.epam.lab.tests;

import com.epam.lab.ConfigFileReader;
import com.epam.lab.WebDriverSetting;
import com.epam.lab.pageobject.LoginPage;
import com.epam.lab.pageobject.MainInboxPage;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class DeleteInboxMessageTest extends WebDriverSetting {
    private ConfigFileReader configFileReader;

    @Parameters({"login", "password"})
    @Test
    public void deleteInboxMessage(String login, String password) {
        configFileReader = new ConfigFileReader();
        driver.get(configFileReader.getWebSiteUrl());
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginToGmail(login, password);
        MainInboxPage mainInboxPage = new MainInboxPage(driver);
        mainInboxPage.selectThreeEmailDeleteAndPressUndoButton();
        Assert.assertEquals(mainInboxPage.initEmailQuantity, mainInboxPage.emailQuantityAfterDeleting);
    }
}