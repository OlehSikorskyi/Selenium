package com.epam.lab.businessobjects;

import com.epam.lab.utils.WebDriverSetting;
import com.epam.lab.pageobject.InboxPage;

public class InboxPageBO extends WebDriverSetting {
    private InboxPage inboxPage;

    public InboxPageBO() {
        inboxPage = new InboxPage(driver);
    }

    public void selectThreeEmail() {
        inboxPage.checkInitialInboxEmailQuantity();
        inboxPage.selectThreeFirstInboxEmail(0, 1, 2);
    }

    public void deleteEmail() {
        inboxPage.deleteSelectedEmail();
    }

    public void cancelDeletingEmail() {
        inboxPage.clickUndoButton();
        inboxPage.checkInboxEmailQuantityAfterDeleting();
    }
}