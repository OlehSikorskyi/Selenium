package com.epam.lab.pageobject;

import com.epam.lab.elements.Button;
import com.epam.lab.elements.CheckBox;
import com.epam.lab.elements.Label;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class InboxPage extends WebElementsInitialization {
    private final static Logger LOG = LogManager.getLogger(InboxPage.class);
    public static int emailInitialQuantity;
    public static int emailQuantityAfterDeleting;
    private WebDriverWait wait = new WebDriverWait(driver, 30);

    @FindBy(xpath = "//div[@class='J-J5-Ji amH J-JN-I']/span/span[last()]")
    private Label initialInboxEmailQuantity;

    @FindBy(css = "table.F.cf.zt tbody div[role='checkbox']")
    private List<CheckBox> checkboxList;

    @FindBy(css = "div[act='10']")
    private Button deleteButton;

    @FindBy(id = "link_undo")
    private Button undoLink;

    @FindBy(xpath = "//div[@class='J-J5-Ji amH J-JN-I']/span/span[last()]")
    private Label finalInboxEmailQuantity;

    public void checkInitialInboxEmailQuantity() {
        emailInitialQuantity = Integer.parseInt(initialInboxEmailQuantity.getText());
        LOG.info(String.format("> Initial inbox Email quantity is: %d", emailInitialQuantity));
    }

    public void selectThreeFirstInboxEmail(int ...args){
        LOG.info("> There are three inbox email was selected");
        for (int i : args) {
            checkboxList.get(i).setChecked(true);
        }
    }

    public void deleteSelectedEmail() {
        deleteButton.click();
        LOG.info("> Selected email has been deleted");
    }

    public void clickUndoButton() {
        undoLink.click();
        LOG.info("> Deletion canceled");
    }

    public void checkInboxEmailQuantityAfterDeleting() {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("span.bAq")));
        emailQuantityAfterDeleting = Integer.parseInt(finalInboxEmailQuantity.getText());
        LOG.info(String.format("> Quantity of inbox Email after deleting is: %d", emailQuantityAfterDeleting));
    }

    public void selectThreeEmailDeleteAndPressUndoButton() {
        checkInitialInboxEmailQuantity();
        selectThreeFirstInboxEmail(0,1,2);
        deleteSelectedEmail();
        clickUndoButton();
        checkInboxEmailQuantityAfterDeleting();
    }

    public InboxPage(WebDriver driver) {
        super(driver);
    }
}