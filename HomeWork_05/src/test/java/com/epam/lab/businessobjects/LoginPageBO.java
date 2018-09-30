package com.epam.lab.businessobjects;

import com.epam.lab.utils.WebDriverSetting;
import com.epam.lab.pageobject.LoginPage;

public class LoginPageBO extends WebDriverSetting {
   private LoginPage loginPage;

    public LoginPageBO(){
        loginPage = new LoginPage(driver);
    }

    public void loginToGmail(String userName, String password){
        loginPage.enterUserNameAndSubmit(userName);
        loginPage.enterPasswordAndSubmit(password);
    }
}
