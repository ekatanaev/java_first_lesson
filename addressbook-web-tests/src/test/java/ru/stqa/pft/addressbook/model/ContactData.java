package ru.stqa.pft.addressbook.model;

public class ContactData {
  private int id;
  private final String firstName;
  private final String lastName;
  private final String company;
  private final String tellNumber;
  private final String email;

  public ContactData(String firstName, String lastName, String company, String tellNumber, String email) {
    this.firstName = firstName;
    this.id = 0;
    this.lastName = lastName;
    this.company = company;
    this.tellNumber = tellNumber;
    this.email = email;
  }

  public ContactData(int id, String firstName, String lastName, String company, String tellNumber, String email) {
    this.firstName = firstName;
    this.id = id;
    this.lastName = lastName;
    this.company = company;
    this.tellNumber = tellNumber;
    this.email = email;
  }

  public int getId() {
    return id;
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

  @Override
  public String toString() {
    return "ContactData{" +
            "id='" + id + '\'' +
            ", firstName='" + firstName + '\'' +
            ", lastName='" + lastName + '\'' +
            '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    ContactData that = (ContactData) o;

    if (id != that.id) return false;
    if (firstName != null ? !firstName.equals(that.firstName) : that.firstName != null) return false;
    return lastName != null ? lastName.equals(that.lastName) : that.lastName == null;

  }

  @Override
  public int hashCode() {
    int result = id;
    result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
    result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
    return result;
  }

  public void setId(int id) {
    this.id = id;
  }
}