package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by e.katanaev on 11.01.2017.
 */
public class ContactHelper extends HelperBase {

  public ContactHelper(WebDriver wd) {
    super(wd);
  }

  public void returnToContactPage() {
    click(By.linkText("home page"));
  }

  public void fillContactForm(ContactData contactData) {
    type(By.name("firstname"), contactData.getFirstName());
    type(By.name("lastname"), contactData.getLastName());
    type(By.name("company"), contactData.getCompany());
    type(By.name("home"), contactData.getTellNumber());
    type(By.name("email"), contactData.getEmail());
  }

  public void submitContactCreation() {
    click(By.xpath("//div[@id='content']/form/input[21]"));
  }

  public void gotoContactCreation() {
    click(By.linkText("add new"));
  }

  public void confirmDeleteContacts() {
    wd.switchTo().alert().accept();
  }

  public void deleteSelectedContact() {
    click(By.xpath("//div[@id='content']/form[2]/div[2]/input"));
  }

  public void selectEditContact(int index) {
    wd.findElements(By.cssSelector("img[alt='Edit']")).get(index).click();
  }

  public void selectContact(int index) {
    wd.findElements(By.name("selected[]")).get(index).click();
  }

  public void contactPage() {
    click(By.linkText("home"));
  }

  public void submitContactModification() {
    click(By.name("update"));
  }

  public void create(ContactData contact) {
    gotoContactCreation();
    fillContactForm(contact);
    submitContactCreation();
    returnToContactPage();
  }
  public void delete(int index) {
    selectContact(index);
    deleteSelectedContact();
    confirmDeleteContacts();
  }
  public void modify(int index, ContactData contact) {
    selectEditContact(index);
    fillContactForm(contact);
    submitContactModification();
    returnToContactPage();
  }

  public boolean isThereAContact() {
    return isElementPresent(By.name("selected[]"));
  }

  public int getContactCount() {
    return wd.findElements(By.name("selected[]")).size();
  }

  public List<ContactData> list() {
    List<ContactData> contacts = new ArrayList<>();
    List<WebElement> elements = wd.findElements(By.name("entry"));
    for (WebElement element : elements) {
      List<WebElement> cells = element.findElements(By.tagName("td"));
      int id = Integer.parseInt(cells.get(0).findElement(By.tagName("input")).getAttribute("value"));
      String lastName = cells.get(1).getText();
      String firstName = cells.get(2).getText();
      ContactData contact = new ContactData(id, firstName, lastName, null, null, null);
      contacts.add(contact);
    }
    return contacts;
  }
}


