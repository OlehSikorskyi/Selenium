package com.epam.lab.POMGmail.PageObjects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class MainInboxPage extends WebElementsInitialization {
    private final static Logger LOG = LogManager.getLogger(MainInboxPage.class);
    public int initEmailQuantity;
    public int emailQuantityAfterDeleting;
    private WebDriverWait wait = new WebDriverWait(driver, 30);

    @FindBy(xpath = "//div[@class=\"J-J5-Ji amH J-JN-I\"]/span/span[last()]")
    private WebElement initialInboxEmailQuantity;

    @FindBy(css = "table.F.cf.zt tbody div[role=\"checkbox\"]")
    private List<WebElement> checkboxList;

    @FindBy(css = "div[act=\"10\"]")
    private WebElement deleteButton;

    @FindBy(id = "link_undo")
    private WebElement undoLink;

    @FindBy(xpath = "//div[@class=\"J-J5-Ji amH J-JN-I\"]/span/span[last()]")
    private WebElement finalInboxEmailQuantity;

    private void checkInitialInboxEmailQuantity() {
        initEmailQuantity = Integer.parseInt(initialInboxEmailQuantity.getText());
        LOG.info(String.format("> Initial inbox Email quantity is: %d", initEmailQuantity));
    }

    private void selectThreeFirstInboxEmail() {
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("table.F.cf.zt tbody div[role=\"checkbox\"]")));
        checkboxList.get(0).click();
        checkboxList.get(1).click();
        checkboxList.get(2).click();
        LOG.info("> There are three inbox email was selected");
    }

    private void deleteSelectedEmail() {
        deleteButton.click();
        LOG.info("> Selected email had been deleted");
    }

    private void cancelSendingEmail() {
        undoLink.click();
        LOG.info("> Deletion canceled");
    }

    private void checkInboxEmailQuantityAfterDeleting() {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("span.bAq")));
        emailQuantityAfterDeleting = Integer.parseInt(finalInboxEmailQuantity.getText());
        LOG.info(String.format("> Quantity of inbox Email after deleting is: %d", emailQuantityAfterDeleting));
    }

    public void selectThreeEmailDeleteAndPressUndoButton() {
        checkInitialInboxEmailQuantity();
        selectThreeFirstInboxEmail();
        deleteSelectedEmail();
        cancelSendingEmail();
        checkInboxEmailQuantityAfterDeleting();
    }

    public MainInboxPage(WebDriver driver) {
        super(driver);
    }
}