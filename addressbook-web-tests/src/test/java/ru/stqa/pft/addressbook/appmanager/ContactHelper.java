package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.stqa.pft.addressbook.model.ContactData;

/**
 * Created by e.katanaev on 11.01.2017.
 */
public class ContactHelper {
  FirefoxDriver wd;

  public ContactHelper(FirefoxDriver wd) {
    this.wd =wd;
      }

  public void returnToContactPage() {
    wd.findElement(By.linkText("home page")).click();
  }

  public void fillContactForm(ContactData contactData) {
    wd.findElement(By.name("firstname")).click();
    wd.findElement(By.name("firstname")).clear();
    wd.findElement(By.name("firstname")).sendKeys(contactData.getFirstName());
    wd.findElement(By.name("lastname")).click();
    wd.findElement(By.name("lastname")).clear();
    wd.findElement(By.name("lastname")).sendKeys(contactData.getLastName());
    wd.findElement(By.name("company")).click();
    wd.findElement(By.name("company")).clear();
    wd.findElement(By.name("company")).sendKeys(contactData.getCompany());
    wd.findElement(By.name("home")).click();
    wd.findElement(By.name("home")).clear();
    wd.findElement(By.name("home")).sendKeys(contactData.getTellNumber());
    wd.findElement(By.name("email")).click();
    wd.findElement(By.name("email")).clear();
    wd.findElement(By.name("email")).sendKeys(contactData.getEmail());
  }

  public void submitContactCreation() {
    wd.findElement(By.xpath("//div[@id='content']/form/input[21]")).click();
  }

  public void gotoContactCreation() {
    wd.findElement(By.linkText("add new")).click();
  }

  public void confirmDeleteContacts() {
      wd.switchTo().alert().accept();
  }

  public void deleteSelectedContact() {
      wd.findElement(By.xpath("//div[@id='content']/form[2]/div[2]/input")).click();
  }

  public void selectContact() {
      wd.findElement(By.name("selected[]")).click();
  }
}
