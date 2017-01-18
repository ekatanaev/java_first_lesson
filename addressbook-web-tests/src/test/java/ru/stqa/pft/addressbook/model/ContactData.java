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

  @Override
  public String toString() {
    return "ContactData{" +
            "firstName='" + firstName + '\'' +
            ", lastName='" + lastName + '\'' +
            ", company='" + company + '\'' +
            ", tellNumber='" + tellNumber + '\'' +
            ", email='" + email + '\'' +
            '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    ContactData that = (ContactData) o;

    if (firstName != null ? !firstName.equals(that.firstName) : that.firstName != null) return false;
    if (lastName != null ? !lastName.equals(that.lastName) : that.lastName != null) return false;
    if (company != null ? !company.equals(that.company) : that.company != null) return false;
    if (tellNumber != null ? !tellNumber.equals(that.tellNumber) : that.tellNumber != null) return false;
    return email != null ? email.equals(that.email) : that.email == null;

  }

  @Override
  public int hashCode() {
    int result = firstName != null ? firstName.hashCode() : 0;
    result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
    result = 31 * result + (company != null ? company.hashCode() : 0);
    result = 31 * result + (tellNumber != null ? tellNumber.hashCode() : 0);
    result = 31 * result + (email != null ? email.hashCode() : 0);
    return result;
  }
}