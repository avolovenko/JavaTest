package ua.av.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import ua.av.addressbook.model.ContactData;

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
}
