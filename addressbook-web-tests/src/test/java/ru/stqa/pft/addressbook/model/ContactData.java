package ru.stqa.pft.addressbook.model;

public class ContactData {
  private final String name;
  private final String lastname;
  private final String job;
  private final String number;

  public ContactData(String name, String lastname, String job, String number) {
    this.name = name;
    this.lastname = lastname;
    this.job = job;
    this.number = number;
  }

  public String getName() {
    return name;
  }

  public String getLastname() {
    return lastname;
  }

  public String getJob() {
    return job;
  }

  public String getNumber() {
    return number;
  }
}
