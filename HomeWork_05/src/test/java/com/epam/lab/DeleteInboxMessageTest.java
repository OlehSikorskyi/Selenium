package com.epam.lab;

import com.epam.lab.businessobjects.InboxPageBO;
import com.epam.lab.businessobjects.LoginPageBO;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import static com.epam.lab.pageobject.InboxPage.emailInitialQuantity;
import static com.epam.lab.pageobject.InboxPage.emailQuantityAfterDeleting;

public class DeleteInboxMessageTest extends WebDriverSetting {
    private ConfigFileReader configFileReader;
    private LoginPageBO loginPageBO;
    private InboxPageBO inboxPageBO;

    public DeleteInboxMessageTest(){
        configFileReader = new ConfigFileReader();
        loginPageBO = new LoginPageBO();
        inboxPageBO = new InboxPageBO();
    }

    @Parameters({"login", "password"})
    @Test
    public void deleteInboxMessage(String login, String password) {
        driver.get(configFileReader.getWebSiteUrl());
        loginPageBO.loginToGmail(login, password);
       inboxPageBO.selectThreeEmail();
       inboxPageBO.deleteEmail();
       inboxPageBO.cancelDeletingEmail();
        Assert.assertEquals(emailInitialQuantity, emailQuantityAfterDeleting);
    }
}