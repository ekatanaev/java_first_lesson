package ru.stqa.pft.addressbook;

import org.testng.annotations.Test;

public class ContactCreationTests extends TastBase {


  @Test
  public void testContactCreation() {
    gotoContactCreation();
    fillContactForm(new ContactData("Evgen", "Kat", "Ino", "123456789", "Ino@mail.ru"));
    submitContactCreation();
    returnToContactPage();
  }

}
