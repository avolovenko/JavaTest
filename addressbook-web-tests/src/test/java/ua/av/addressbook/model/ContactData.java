package ua.av.addressbook.model;

import java.util.Objects;

public class ContactData<contact> {
  private int id;
  private final String firstName;
  private final String lastName;
  private final String address;
  private final String phoneMobile;
  private final String emailAddress;
  private final String group;
  private final String bDay;
  private final String bMonth;
  private final String bYear;

  public ContactData(int id, String firstName, String lastName, String Address, String phoneMobile, String emailAddress, String group, String bDay, String bMonth, String bYear) {
    this.id = id;
    this.firstName = firstName;
    this.lastName = lastName;
    this.address = Address;
    this.phoneMobile = phoneMobile;
    this.emailAddress = emailAddress;
    this.group = group;
    this.bDay = bDay;
    this.bMonth = bMonth;
    this.bYear = bYear;
  }

  public ContactData(String firstName, String lastName, String Address, String phoneMobile, String emailAddress, String group, String bDay, String bMonth, String bYear) {
    this.id = Integer.MAX_VALUE;;
    this.firstName = firstName;
    this.lastName = lastName;
    this.address = Address;
    this.phoneMobile = phoneMobile;
    this.emailAddress = emailAddress;
    this.group = group;
    this.bDay = bDay;
    this.bMonth = bMonth;
    this.bYear = bYear;
  }

  public int getId() { return id;  }

  public String getFirstName() {
    return firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public String getAddress() {
    return address;
  }

  public String getPhoneMobile() {
    return phoneMobile;
  }

  public String getEmailAddress() {
    return emailAddress;
  }

  public String getbDay() {
    return bDay;
  }

  public String getbMonth() {
    return bMonth;
  }

  public String getbYear() {
    return bYear;
  }

  public String getGroup() {
    return group;
  }

  public void setId(int id) {
    this.id = id;
  }

  @Override
  public String toString() {
    return "ContactData{" +
            "id=" + id +
            ", firstName='" + firstName + '\'' +
            ", lastName='" + lastName + '\'' +
            '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass( ) != o.getClass( )) return false;
    ContactData<?> that = (ContactData<?>) o;
    return id == that.id &&
            Objects.equals( firstName, that.firstName ) &&
            Objects.equals( lastName, that.lastName );
  }

  @Override
  public int hashCode() {
    return Objects.hash( id, firstName, lastName );
  }
}
