package com.epam.lab;

import com.epam.lab.businessobjects.InboxPageBO;
import com.epam.lab.businessobjects.LoginPageBO;
import com.epam.lab.utils.ConfigFileReader;
import com.epam.lab.utils.WebDriverSetting;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import static com.epam.lab.pageobject.InboxPage.emailInitialQuantity;
import static com.epam.lab.pageobject.InboxPage.emailQuantityAfterDeleting;

public class DeleteInboxMessageTest extends WebDriverSetting {
    private ConfigFileReader configFileReader;
    private LoginPageBO loginPageBO;
    private InboxPageBO inboxPageBO;

    @Parameters({"login", "password"})
    @Test
    public void deleteInboxMessage(String login, String password) {
        configFileReader = new ConfigFileReader();
        loginPageBO = new LoginPageBO();
        inboxPageBO = new InboxPageBO();
        driver.get(configFileReader.getWebSiteUrl());
        loginPageBO.loginToGmail(login, password);
        inboxPageBO.selectThreeEmail();
        inboxPageBO.deleteEmail();
        inboxPageBO.cancelDeletingEmail();
        Assert.assertEquals(emailInitialQuantity, emailQuantityAfterDeleting);
    }
}