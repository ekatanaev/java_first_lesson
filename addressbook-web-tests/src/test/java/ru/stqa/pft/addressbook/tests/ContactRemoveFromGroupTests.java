package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by e.katanaev on 10.02.2017.
 */
public class ContactRemoveFromGroupTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    if (app.db().contacts().size() == 0) {
      app.contact().contactPage();
      app.contact().create(new ContactData()
              .withFirstName("Evgen").withLastName("Kat").withCompany("Ino"));

    }

    if (app.db().groups().size() == 0) {
      app.goTo().groupPage();
      app.group().create(new GroupData().withName("test1"));
    }
  }

  @Test
  public void testContactRemoveFromGroup() {
    Groups groups = app.db().groups();
    Contacts contacts = app.db().contacts();
    ContactData modifiedContact = contacts.iterator().next();
    GroupData relatedGroup = groups.iterator().next();

    if (!(app.contact().isContactInGroup(modifiedContact, relatedGroup))) {
      app.contact().contactPage();
      app.contact().selectContactById(modifiedContact.getId());
      app.contact().selectRelatedGroup(relatedGroup);
      app.contact().submitAddToGroup();
      contacts = app.db().contacts();
      for (ContactData contact : contacts) {
        if (contact.getId() == modifiedContact.getId()) {
          modifiedContact = contact;
        }
      }
    }
    app.contact().contactPage();
    app.contact().filterByGroup(relatedGroup);
    app.contact().selectContactById(modifiedContact.getId());
    app.contact().submitRemoveFromGroup();
    app.contact().contactPage();
    contacts = app.db().contacts();
    for (ContactData contact : contacts) {
      if (contact.getId() == modifiedContact.getId()) {
        modifiedContact = contact;
      }
    }
    assertThat(app.contact().isContactInGroup(modifiedContact, relatedGroup), equalTo(false));
  }
}
