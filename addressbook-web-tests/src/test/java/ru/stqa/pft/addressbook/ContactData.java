package ru.stqa.pft.addressbook;

public class ContactData {
  private final String firstname;
  private final String lastname;
  private final String job;
  private final String email;
  private final String phonenumber;

  public ContactData(String firstname, String lastname, String job, String email, String phonenumber) {
    this.firstname = firstname;
    this.lastname = lastname;
    this.job = job;
    this.email = email;
    this.phonenumber = phonenumber;
  }

  public String getFirstname() {
    return firstname;
  }

  public String getLastname() {
    return lastname;
  }

  public String getJob() {
    return job;
  }

  public String getEmail() {
    return email;
  }

  public String getPhonenumber() {
    return phonenumber;
  }
}
