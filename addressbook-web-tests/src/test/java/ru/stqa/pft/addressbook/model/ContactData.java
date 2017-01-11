package ru.stqa.pft.addressbook.model;

public class ContactData {
  private final String firstName;
  private final String lastName;
  private final String company;
  private final String tellNumber;
  private final String email;

  public ContactData(String firstName, String lastName, String company, String tellNumber, String email) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.company = company;
    this.tellNumber = tellNumber;
    this.email = email;
  }

  public String getFirstName() {
    return firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public String getCompany() {
    return company;
  }

  public String getTellNumber() {
    return tellNumber;
  }

  public String getEmail() {
    return email;
  }
}
