package ua.av.addressbook;

public class ContactData {
  private final String firstName;
  private final String lastName;
  private final String address;
  private final String phoneMobile;
  private final String emailAddress;
  private final String bDay;
  private final String bMonth;
  private final String bYear;

  public ContactData(String firstName, String lastName, String Address, String phoneMobile, String emailAddress, String bDay, String bMonth, String bYear) {
    this.firstName = firstName;
    this.lastName = lastName;
    address = Address;
    this.phoneMobile = phoneMobile;
    this.emailAddress = emailAddress;
    this.bDay = bDay;
    this.bMonth = bMonth;
    this.bYear = bYear;
  }

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
}
