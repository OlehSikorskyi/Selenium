package com.epam.lab;

import com.epam.lab.businessobjects.InboxPageBO;
import com.epam.lab.businessobjects.LoginPageBO;
import com.epam.lab.utils.ConfigFileReader;
import com.epam.lab.utils.WebDriverPool;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Map;

import static com.epam.lab.pageobject.InboxPage.emailInitialQuantity;
import static com.epam.lab.pageobject.InboxPage.emailQuantityAfterDeleting;

public class DeleteInboxMessageTest {
    private ConfigFileReader configFileReader;
    private LoginPageBO loginPageBO;
    private InboxPageBO inboxPageBO;

    @DataProvider(name = "userData", parallel = true)
    public Object[][] getUserData() {
        return new Object[][]{{"oleh.sikorskyi@gmail.com", "g3t7UZ?Rq-"},
                {"oleh.sikorskyi01@gmail.com", "g3t7UZg3t7UZ"},
                {"oleh.sikorskyi02@gmail.com", "7UZg3t7UZ-"},
                {"oleh.sikorskyi03@gmail.com", "7U3t7U457Z-"},
                {"oleh.sikorskyi04@gmail.com", "t7Udvv457Z-"},
        };
    }

    @Test(dataProvider = "userData", threadPoolSize = 3)
    public void deleteInboxMessage(String login, String password) {
        configFileReader = new ConfigFileReader();
        WebDriver driver = WebDriverPool.getInstance().getDriver();
        driver.get(configFileReader.getWebSiteUrl());
        loginPageBO = new LoginPageBO(driver);
        inboxPageBO = new InboxPageBO(driver);
        loginPageBO.loginToGmail(login, password);
        inboxPageBO.selectThreeEmail();
        inboxPageBO.deleteEmail();
        inboxPageBO.cancelDeletingEmail();
        Assert.assertEquals(emailInitialQuantity, emailQuantityAfterDeleting);
    }
    /* @DataProvider(name = "userData", parallel = true)
     public Object[][] getUserData(ITestContext context) {
         Map<String, String> suiteParams = context.getCurrentXmlTest().getSuite().getParameters();

         return new Object[][]{{suiteParams.get("login-first"), suiteParams.get("password-first")},
                 {suiteParams.get("login-second"), suiteParams.get("password-second")},
                 {suiteParams.get("login-third"), suiteParams.get("password-third")},
                 {suiteParams.get("login-fourth"), suiteParams.get("password-fourth")},
                 {suiteParams.get("login-fifth"), suiteParams.get("password-fifth")},
         };
     }*/
}