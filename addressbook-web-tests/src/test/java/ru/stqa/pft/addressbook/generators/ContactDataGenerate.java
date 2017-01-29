package ru.stqa.pft.addressbook.generators;

import ru.stqa.pft.addressbook.model.ContactData;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by jekko on 29.01.2017.
 */
public class ContactDataGenerate {

  public static void main(String[] args) throws IOException {
    int count = Integer.parseInt(args[0]);
    File file = new File(args[1]);

    List<ContactData> contacts = generateContacts(count);
    save(contacts, file);
  }

  private static void save(List<ContactData> contacts, File file) throws IOException {
    System.out.println(new File(".").getAbsolutePath());
    Writer writer = new FileWriter(file);
    for (ContactData contact : contacts) {
      writer.write(String.format("%s;%s;%s;%s;%s;%s;%s\n", contact.getFirstName(), contact.getLastName()
              ,contact.getHomePhone(), contact.getMobilePhone(), contact.getWorkPhone()
              ,contact.getAddress(), contact.getEmail()));
    }
    writer.close();
  }

  private static List<ContactData> generateContacts(int count) {
    List<ContactData> contacts = new ArrayList<ContactData>();
    for (int i = 0; i < count; i++) {
      contacts.add(new ContactData().withFirstName(String.format("firstname %s", i))
              .withLastName(String.format("lastname %s", i)).withHomePhone(String.format("homephone %s", i))
              .withMobilePhone(String.format("mobilephone %s", i)).withWorkPhone(String.format("workphone %s", i))
              .withAddress(String.format("address %s", i)).withEmail(String.format("email %s", i)));
    }
    return contacts;
  }
}