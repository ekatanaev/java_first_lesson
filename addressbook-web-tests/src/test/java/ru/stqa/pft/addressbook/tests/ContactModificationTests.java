package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.HashSet;
import java.util.List;
import java.util.zip.CheckedInputStream;

/**
 * Created by jekko on 12.01.2017.
 */
public class ContactModificationTests extends TestBase {

  @Test
  public void testContactModification() {
    app.getContactHelper().gotoContactEdit();
    if (! app.getContactHelper().isThereAContact()) {
      app.getContactHelper().createContact(new ContactData("Evgen", "Kat", "Ino", null, null));
    }
    List<ContactData> before = app.getContactHelper().getContactList();
    app.getContactHelper().selectContact(0);
    app.getContactHelper().initContactModification();
    ContactData contact = new ContactData(before.get(0 ).getId(), "Evgen", "Kat", "Ino", "123456789", "Ino@mail.ru");
    app.getContactHelper().fillContactForm(contact);
    app.getContactHelper().submitContactModification();
    app.getContactHelper().returnToContactPage();
    List<ContactData> after = app.getContactHelper().getContactList();
    Assert.assertEquals(after.size(), before.size());

    //before.remove(0);
    //before.add(contact);
    Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object>(after));

  }
}
