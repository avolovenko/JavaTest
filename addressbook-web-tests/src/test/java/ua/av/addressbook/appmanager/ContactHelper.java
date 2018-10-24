package ua.av.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ua.av.addressbook.model.ContactData;

import static org.testng.Assert.assertTrue;

public class ContactHelper extends HelperBase {

  public ContactHelper(WebDriver wd) {
    super( wd );
  }

  public void submitNewContact() {
    click( By.xpath("(//input[@name='submit'])[2]"));
  }

  public void fillNewContactData(ContactData contactData) {
    type(By.name("firstname"), contactData.getFirstName());
    type(By.name("lastname"), contactData.getLastName());
    type(By.name("address"), contactData.getAddress());
    type(By.name("mobile"), contactData.getPhoneMobile());
    type(By.name("email"), contactData.getEmailAddress());
    select( By.name( "bday" ), contactData.getbDay( ) );
    select( By.name( "bmonth" ), contactData.getbMonth() );
    type( By.name("byear"), contactData.getbYear());
  }

  public void initNewContact() {
    click( By.linkText("ADD_NEW"));
  }

  public void editContact() {
    click( By.xpath("(//img[@alt='EDIT'])[1]") );
  }

  public void submitContactModification() {
    click( By.xpath("(//input[@name='update'])[1]") );
  }

  public void selectContact() {
    click( By.id("9") );
  }

  public void deleteContact() {
    click( By.xpath( "//input[@value='DELETE']" ) );
    boolean acceptNextAlert = true;
    assertTrue(closeAlertAndGetItsText( acceptNextAlert ).matches("^Delete 1 addresses[\\s\\S]$"));

  }


}
