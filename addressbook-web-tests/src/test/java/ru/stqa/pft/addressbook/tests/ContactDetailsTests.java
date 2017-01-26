package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by e.katanaev on 25.01.2017.
 */
public class ContactDetailsTests extends TestBase {
  @BeforeMethod
  public void ensurePreconditions() {
    app.contact().contactPage();
    if (app.contact().all().size() == 0) {
      app.contact().create(new ContactData()
              .withFirstName("Evgen").withLastName("Kat").withAddress("Taganrog").withHomePhone("111").withMobilePhone("222").withWorkPhone("333").withEmail("ino@mail.ru"));
    }
  }

  @Test
  public void testContactDetails() {
    app.goTo().gotoContactPage();
    ContactData contact = app.contact().all().iterator().next();
    ContactData contactInfoFromEditForm = app.contact().infoFromEditForm(contact);
    String contactInfoFromDetailsPage = app.contact().infoFromDetailsPage(contact);

    assertThat((cleanedPhones(clearEmptyLines(contactInfoFromDetailsPage)))
            , equalTo(clearEmptyLines(mergeContactInfoFromEditForm(contactInfoFromEditForm))));
  }

  private String mergeContactInfoFromEditForm(ContactData contact) {
    String mergedName = Arrays.asList(contact.getFirstName(), contact.getLastName())
            .stream().filter((s) -> !s.equals(""))
            .collect(Collectors.joining(" "));

    String mergedAddress = Arrays.asList(contact.getAddress())
            .stream().filter((s) -> !s.equals(""))
            .collect(Collectors.joining("\n"));

    String mergedPhones = Arrays.asList(cleanedPhones(contact.getHomePhone()), contact.getMobilePhone(), contact.getWorkPhone())
            .stream().filter((s) -> !s.equals(""))
            .collect(Collectors.joining("\n"));

    return Arrays.asList(mergedName, mergedAddress, mergedPhones,
            contact.getEmail())
            .stream().filter((s) -> !s.equals(""))
            .collect(Collectors.joining("\n"));
  }

  public static String cleanedPhones(String s) {
    return s.replaceAll("\n[HWM]: ", "\n");
  }

  public static String clearEmptyLines(String s) {
    return s.replaceAll("\n\n", "\n");
  }
}

