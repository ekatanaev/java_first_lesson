package ru.stqa.pft.addressbook.tests;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactCreationTests extends TestBase {


  @Test
  public void testContactCreation() {
    app.getContactHelper().gotoContactCreation();
    app.getContactHelper().fillContactForm(new ContactData("Evgen", "Kat", "Ino", null, null));
    app.getContactHelper().submitContactCreation();
    app.getContactHelper().returnToContactPage();
  }
}