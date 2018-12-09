package ua.av.addressbook.model;

import com.google.gson.annotations.Expose;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamOmitField;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.File;
import java.util.Objects;

import static jdk.nashorn.internal.objects.NativeString.toUpperCase;

@XStreamAlias("contact")
@Entity
@Table(name="addressbook")
public class ContactData<contact> {

  @XStreamOmitField
  @Id
  @Column(name="id")
  private int id = Integer.MAX_VALUE;

  @Expose
  @Column(name="firstname")
  private String firstName;

  @Expose
  @Column(name="lastname")
  private String lastName;

  @Expose
  @Column(name="address")
  @Type(type="text")
  private String address;

  @Expose
  @Column(name="home")
  @Type(type="text")
  private String phoneHome;

  @Expose
  @Column(name="mobile")
  @Type(type="text")
  private String phoneMobile;

  @Expose
  @Column(name="work")
  @Type(type="text")
  private String phoneWork;

  @Expose
  @Column(name="email")
  @Type(type="text")
  private String emailAddress;

  @Expose
  @Column(name="email2")
  @Type(type="text")
  private String emailAddress2;

  @Expose
  @Column(name="email3")
  @Type(type="text")
  private String emailAddress3;

  @Expose
  @Transient
  private String group;

  @Expose
  @Column(name="bday", columnDefinition = "tinyint")
  private int bDay;

  @Expose
  @Column(name="bmonth")
  private String bMonth;

  @Expose
  @Column(name="byear")
  private String bYear;

  @Transient
  private String allPhones;

  @Transient
  private String allEmails;

  @Column(name="photo")
  @Type(type="text")
  private String photo;

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

  public Integer getbDay() {
    return Integer.valueOf(bDay);
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

  //public File getPhoto() {return new File(photo);  }

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

  public ContactData withbDay(Integer bDay) {
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

  public ContactData withPhoto(File photo) {
    this.photo = photo.getPath();
    return this;
  }

  @Override
  public String toString() {
    return "ContactData{" +
            "id=" + id +
            ", firstName='" + firstName + '\'' +
            ", lastName='" + lastName + '\'' +
            ", address='" + address + '\'' +
            ", phoneHome='" + phoneHome + '\'' +
            ", phoneMobile='" + phoneMobile + '\'' +
            ", phoneWork='" + phoneWork + '\'' +
            /*", emailAddress='" + emailAddress + '\'' +
            ", emailAddress2='" + emailAddress2 + '\'' +
            ", emailAddress3='" + emailAddress3 + '\'' +
            ", group='" + group + '\'' +*/
            ", bDay=" + bDay +
            ", bMonth='" + bMonth + '\'' +
            ", bYear='" + bYear + '\'' +
            '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    ContactData contactData = (ContactData) o;

    if (id != contactData.id) return false;
    if (firstName != null ? !firstName.equals(contactData.firstName) : contactData.firstName != null) return false;
    if (lastName != null ? !lastName.equals(contactData.lastName) : contactData.lastName != null) return false;
    if (address != null ? !address.equals(contactData.address) : contactData.address != null) return false;
    if (phoneHome != null ? !phoneHome.equals(contactData.phoneHome) : contactData.phoneHome != null) return false;
    if (phoneMobile != null ? !phoneMobile.equals(contactData.phoneMobile) : contactData.phoneMobile != null) return false;
    if (phoneWork != null ? !phoneWork.equals(contactData.phoneWork) : contactData.phoneWork != null) return false;
    if (bDay != contactData.bDay) return false;
    if (bMonth != null ? !bMonth.equals(contactData.bMonth) : contactData.bMonth != null) return false;
    if (bYear != null ? !bYear.equals(contactData.bYear) : contactData.bYear != null) return false;
    return bYear != null ? bYear.equals(contactData.bYear) : contactData.bYear == null;
  }



  @Override
  public int hashCode() {
    int result = id;
    result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
    result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
    result = 31 * result + (address != null ? address.hashCode() : 0);
    result = 31 * result + (phoneHome != null ? phoneHome.hashCode() : 0);
    result = 31 * result + (phoneMobile != null ? phoneMobile.hashCode() : 0);
    result = 31 * result + (phoneWork != null ? phoneWork.hashCode() : 0);
    result = 31 * result + bDay;
    result = 31 * result + (bMonth != null ? bMonth.hashCode() : 0);
    result = 31 * result + (bYear != null ? bYear.hashCode() : 0);
    return result;
  }
}
