package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by e.katanaev on 11.01.2017.
 */
public class SessionHelper extends HelperBase {

  public SessionHelper(WebDriver wd) {

    super(wd);
  }

  public void login(String username, String password) {
    type(By.name("user"), username);
    type(By.name("pass"), password);
    click(By.id("LoginForm"));
    click(By.xpath("//form[@id='LoginForm']/input[3]"));
  }

}
