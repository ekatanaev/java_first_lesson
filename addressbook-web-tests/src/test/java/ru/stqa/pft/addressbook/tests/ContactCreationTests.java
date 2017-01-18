package ru.stqa.pft.addressbook.tests;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactCreationTests extends TestBase {


  @Test
  public void testContactCreation() {
    app.getContactHelper().gotoContactEdit();
    int before = app.getContactHelper().getContactCount();
    app.getContactHelper().gotoContactCreation();
    app.getContactHelper().fillContactForm(new ContactData("Evgen", "Kat", "Ino", null, null));
    app.getContactHelper().submitContactCreation();
    app.getContactHelper().returnToContactPage();
    int after = app.getContactHelper().getContactCount();
    Assert.assertEquals(after, before + 1);
  }
}