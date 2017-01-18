package ru.stqa.pft.addressbook.tests;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.List;

public class ContactCreationTests extends TestBase {


  @Test
  public void testContactCreation() {
    app.getContactHelper().gotoContactEdit();
    List<ContactData> before = app.getContactHelper().getContactList();
    app.getContactHelper().gotoContactCreation();
    app.getContactHelper().fillContactForm(new ContactData("Evgen", "Kat", "Ino", null, null));
    app.getContactHelper().submitContactCreation();
    app.getContactHelper().returnToContactPage();
    List<ContactData> after = app.getContactHelper().getContactList();
    Assert.assertEquals(after.size(), before.size() + 1);
  }
}