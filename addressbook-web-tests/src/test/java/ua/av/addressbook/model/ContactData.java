package ua.av.addressbook.model;

import java.util.Objects;

public class ContactData<contact> {
  private int id = Integer.MAX_VALUE;
  private String firstName;
  private String lastName;
  private String address;
  private String phoneHome;
  private String phoneMobile;
  private String phoneWork;
  private String emailAddress;
  private String emailAddress2;
  private String emailAddress3;
  private String group;
  private String bDay;
  private String bMonth;
  private String bYear;
  private String allPhones;
  private String allEmails;

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

  public String getPhoneHome() {return phoneHome;  }

  public String getPhoneMobile() {
    return phoneMobile;
  }

  public String getPhoneWork() {return phoneWork; }

  public String getEmailAddress() {
    return emailAddress;
  }

  public String getEmailAddress2() {return emailAddress2; }

  public String getEmailAddress3() { return emailAddress3; }

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

  public String getAllPhones() { return allPhones; }

  public String getAllEmails() {return allEmails; }

  public ContactData withId(int id) {
    this.id = id;
    return this;
  }

  public ContactData withFirstName(String firstName) {
    this.firstName = firstName;
    return this;
  }

  public ContactData withLastName(String lastName) {
    this.lastName = lastName;
    return this;
  }

  public ContactData withAddress(String address) {
    this.address = address;
    return this;
  }

  public ContactData withPhoneHome(String phoneHome) {
    this.phoneHome = phoneHome;
    return this;
  }

  public ContactData withPhoneMobile(String phoneMobile) {
    this.phoneMobile = phoneMobile;
    return this;
  }

  public ContactData withPhoneWork(String phoneWork) {
    this.phoneWork = phoneWork;
    return this;
  }

  public ContactData withEmailAddress(String emailAddress) {
    this.emailAddress = emailAddress;
    return this;
  }

  public ContactData withEmailAddress2(String emailAddress2) {
    this.emailAddress2 = emailAddress2;
    return this;
  }

  public ContactData withEmailAddress3(String emailAddress3) {
    this.emailAddress3 = emailAddress3;
    return this;
  }

  public ContactData withGroup(String group) {
    this.group = group;
    return this;
  }

  public ContactData withbDay(String bDay) {
    this.bDay = bDay;
    return this;
  }

  public ContactData withbMonth(String bMonth) {
    this.bMonth = bMonth;
    return this;
  }

  public ContactData withbYear(String bYear) {
    this.bYear = bYear;
    return this;
  }

  public ContactData withAllPhones(String allPhones) {
    this.allPhones = allPhones;
    return this;
  }

  public ContactData withAllEmails(String allEmails) {
    this.allEmails = allEmails;
    return this;
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
