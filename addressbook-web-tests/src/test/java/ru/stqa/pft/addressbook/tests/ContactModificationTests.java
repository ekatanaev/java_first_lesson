package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.appmanager.ContactHelper;
import ru.stqa.pft.addressbook.model.ContactData;

/**
 * Created by jekko on 12.01.2017.
 */
public class ContactModificationTests extends TestBase {

  @Test
  public void testContactModification() {
    app.getContactHelper().gotoContactEdit();
    app.getContactHelper().selectContact();
    app.getContactHelper().initContactModification();
    app.getContactHelper().fillContactForm(new ContactData("Evgen", "Kat", "Ino", "123456789", "Ino@mail.ru"));
    app.getContactHelper().submitContactModification();
    app.getContactHelper().returnToContactPage();
  }
}
