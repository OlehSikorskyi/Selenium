package com.epam.lab;

import com.epam.lab.businessobjects.InboxPageBO;
import com.epam.lab.businessobjects.LoginPageBO;
import com.epam.lab.utils.ConfigFileReader;
import com.epam.lab.utils.WebDriverPool;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.util.Map;

import static com.epam.lab.pageobject.InboxPage.emailInitialQuantity;
import static com.epam.lab.pageobject.InboxPage.emailQuantityAfterDeleting;

public class DeleteInboxMessageTest {
    private ConfigFileReader configFileReader;

    @BeforeClass
    public void setupDriver() {
        configFileReader = new ConfigFileReader();
        System.setProperty("webdriver.chrome.driver", configFileReader.getDriverPath());
    }

    @DataProvider(name = "userData", parallel = true)
    public Object[][] getUserData(ITestContext context) {
        Map<String, String> suiteParams = context.getCurrentXmlTest().getSuite().getParameters();
        return new Object[][]{{suiteParams.get("login-first"), suiteParams.get("password-first")},
                {suiteParams.get("login-second"), suiteParams.get("password-second")},
                {suiteParams.get("login-third"), suiteParams.get("password-third")},
                {suiteParams.get("login-fourth"), suiteParams.get("password-fourth")},
                {suiteParams.get("login-fifth"), suiteParams.get("password-fifth")},
        };
    }

    @Test(dataProvider = "userData")
    public void deleteInboxMessage(String login, String password) {
        WebDriver driver = WebDriverPool.getDriver();
        driver.get(configFileReader.getWebSiteUrl());
        LoginPageBO loginPageBO = new LoginPageBO(driver);
        InboxPageBO inboxPageBO = new InboxPageBO(driver);
        loginPageBO.loginToGmail(login, password);
        inboxPageBO.selectThreeEmail();
        inboxPageBO.deleteEmail();
        inboxPageBO.cancelDeletingEmail();
        Assert.assertEquals(emailInitialQuantity, emailQuantityAfterDeleting);
    }

    @AfterMethod
    public void tearDown() {
        WebDriverPool.removeDriver();
    }
}