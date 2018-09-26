package com.epam.lab.pageobject;

import com.epam.lab.elements.Button;
import com.epam.lab.elements.CheckBox;
import com.epam.lab.elements.QuantityCounter;
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

    @FindBy(xpath = "//div[@class='J-J5-Ji amH J-JN-I']/span/span[last()]")
    private QuantityCounter initialInboxEmailQuantity;

    @FindBy(css = "table.F.cf.zt tbody div[role='checkbox']")
    private CheckBox checkbox;

    @FindBy(css = "table.F.cf.zt tbody div[role='checkbox']")
    private List<WebElement> checkboxList;

    @FindBy(css = "div[act='10']")
    private Button deleteButton;

    @FindBy(id = "link_undo")
    private Button undoLink;

    @FindBy(xpath = "//div[@class='J-J5-Ji amH J-JN-I']/span/span[last()]")
    private QuantityCounter finalInboxEmailQuantity;

    private void checkInitialInboxEmailQuantity() {
        initEmailQuantity = Integer.parseInt(initialInboxEmailQuantity.getText());
        LOG.info(String.format("> Initial inbox Email quantity is: %d", initEmailQuantity));
    }

    private void selectThreeFirstInboxEmail(){
        checkbox.setChecked( true, checkboxList, 0,1,2);
    }
    private void deleteSelectedEmail() {
        deleteButton.click();
        LOG.info("> Selected email has been deleted");
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