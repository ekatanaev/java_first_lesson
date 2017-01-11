package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactCreationTests extends TastBase {


  @Test
  public void testContactCreation() {
    app.gotoContactCreation();
    app.fillContactForm(new ContactData("Evgen", "Kat", "Ino", "123456789", "Ino@mail.ru"));
    app.submitContactCreation();
    app.returnToContactPage();
  }

}
