package ru.stqa.pft.addressbook;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class ContactDeletionTests extends TastBase {

    @Test
    public void testContactDeletion() {
        gotoContactPage();
        selectContact();
        deleteSelectedContact();
        confirmDeleteContacts();
    }

}
