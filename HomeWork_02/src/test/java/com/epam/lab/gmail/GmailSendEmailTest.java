package com.epam.lab.gmail;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

@SuppressWarnings("ALL")
public class GmailSendEmailTest extends WebDriverSetting {
    private static final String EMAIL = "oleh.sikorskyi@gmail.com";
    private static final String PASS = "g3t7UZ?Rq-";
    private static String emailRecipients = "helgi.sikora@gmail.com";
    private static String emailSubject = "no-reply: New mail via gmail using Selenium Webdriver";
    private static String emailBody = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.";
    private static int lettersQuantityBeforeSendingEmail;
    private static int lettersQuantityAfterSendingEmail;
    private static String accountGoogleUrl = "https://accounts.google.com/";
    private static String userNameLocator = "input#identifierId";
    private static String passwordLocator = "input[name=\"password\"]";
    private static String gmailIconLocator = "//a[@href=\"https://mail.google.com\"]";
    private static String sentLinkLocator = "//a[contains(@href, \"sent\")]";
    private static String letterCounterLocator = "//div[@class=\"J-J5-Ji amH J-JN-I\"]/span/span[last()]";
    private static String composeButtonLocator = "//div[@class=\"T-I J-J5-Ji T-I-KE L3\" and @role=\"button\"]";
    private static String recipientLocator = "//textarea[@name=\"to\"]";
    private static String subjectBoxLocator = "//input[@name=\"subjectbox\"]";
    private static String messageBodyLocator = "table tbody tr td div.Am.Al.editable.LW-avf";
    private static String sendButtonLocator = "//div[@class=\"T-I J-J5-Ji aoO T-I-atl L3\"][@role=\"button\"]";
    private static String sentPopUpLocator = "span.bAq";

    @Test
    public void shouldLoginAndSendMessageViaGmail() {
        driver.get(accountGoogleUrl);
        WebElement userName = driver.findElement(By.cssSelector(userNameLocator));
        userName.clear();
        userName.sendKeys(EMAIL);
        userName.sendKeys(Keys.RETURN);
        WebElement password = driver.findElement(By.cssSelector(passwordLocator));
        password.sendKeys(PASS);
        password.sendKeys(Keys.RETURN);
        WebElement gmailIcon = driver.findElement(By.xpath(gmailIconLocator));
        gmailIcon.click();

        //should go to "Sent" folder and check actual sent letters quantity
        WebElement sentLink = driver.findElement(By.xpath(sentLinkLocator));
        sentLink.click();
        WebElement letterCounter = driver.findElement(By.xpath(letterCounterLocator));
        lettersQuantityBeforeSendingEmail = Integer.parseInt(letterCounter.getText());

        //should create new letter
        WebElement composeButton = driver.findElement(By.xpath(composeButtonLocator));
        composeButton.click();
        WebElement recipient = driver.findElement(By.xpath(recipientLocator));
        recipient.sendKeys(emailRecipients);
        WebElement subjectBox = driver.findElement(By.xpath(subjectBoxLocator));
        subjectBox.sendKeys(emailSubject);
        WebElement messageBody = driver.findElement(By.cssSelector(messageBodyLocator));
        messageBody.sendKeys(emailBody);
        WebElement sendButton = driver.findElement(By.xpath(sendButtonLocator));
        sendButton.click();

        //should check sent letters quantity after sending letter and compare with initial value
        WebDriverWait webDriverWait = new WebDriverWait(driver, timeouts);
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(sentPopUpLocator)));
        WebElement letterCounterAfterSendingEmail = driver.findElement(By.xpath(letterCounterLocator));
        lettersQuantityAfterSendingEmail = Integer.parseInt(letterCounterAfterSendingEmail.getText());
        Assert.assertEquals(lettersQuantityAfterSendingEmail - 1, lettersQuantityBeforeSendingEmail);
    }
}