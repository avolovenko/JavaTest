package ua.av.addressbook.appmanager;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ua.av.addressbook.model.ContactData;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.assertTrue;

public class ContactHelper extends HelperBase {

  public ContactHelper(WebDriver wd) {
    super( wd );
  }

  public void submitNewContact() {
    click( By.xpath("(//input[@name='submit'])[2]"));
  }

  public void fillNewContactData(ContactData contactData, boolean creation) {
    type( By.name( "firstname" ), contactData.getFirstName( ) );
    type( By.name( "lastname" ), contactData.getLastName( ) );
    type( By.name( "address" ), contactData.getAddress( ) );
    type( By.name( "mobile" ), contactData.getPhoneMobile( ) );
    type( By.name( "email" ), contactData.getEmailAddress( ) );

    if (creation) {
      new Select( wd.findElement( By.name( "new_group" ) ) ).selectByVisibleText( contactData.getGroup( ) );
    } else {
      Assert.assertFalse(isElementPresent( By.name( "new_group" )));
    }

    select( By.name( "bday" ), contactData.getbDay( ) );
    select( By.name( "bmonth" ), contactData.getbMonth( ) );
    type( By.name( "byear" ), contactData.getbYear( ) );
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

  public void selectContact(int index) {
    /*click( By.xpath("//table[@id='maintable']/tbody/tr[2]/td[2]") );
    click( By.name("selected[]") );*/
    wd.findElements( By.name("selected[]")).get( index ).click();
  }

  public void deleteContact() {
    click( By.xpath( "//input[@value='DELETE']" ) );
    boolean acceptNextAlert = true;
    assertTrue(closeAlertAndGetItsText( acceptNextAlert ).matches("^Delete 1 addresses[\\s\\S]$"));

  }

  public void createContact(ContactData contact, boolean creation) {
    initNewContact();
    fillNewContactData(contact, creation);
    submitNewContact();
  }

  public boolean isThereAContact() {
    return isElementPresent( By.xpath("//table[@id='maintable']/tbody/tr[2]/td[2]"));
  }

  /*public int getContactCount() {return wd.findElements( By.className( "group" )).size();}*/

  public List<ContactData> getContactList() {
    List<ContactData> contacts = new ArrayList<ContactData>( );
    WebElement table = wd.findElement(By.id("maintable"));
    List<WebElement> elements = wd.findElements(By.xpath( "//table[@id='maintable']/tbody/tr[@name='entry']"));
    //List<WebElement> elements = wd.findElements(By.tagName( "entry" ));
    System.out.println("==========================================");
    System.out.println("Rows number: " + elements.size());
    for (WebElement element : elements) {
    System.out.println("Row");
      int id = Integer.parseInt(element.findElement( By.tagName( "input" )).getAttribute( "value" ));
      System.out.println("id: " + id);
      String lastName = element.findElement(By.xpath( "./td[2]")).getText();
      System.out.println("lastName: " + lastName);
      String firstName = element.findElement(By.xpath( "./td[3]")).getText();
      System.out.println("lastName: " + firstName);
      ContactData contact = new ContactData( id, firstName, lastName, null, null, null, null, null, null, null);
      contacts.add( contact );
    }
    return contacts;
  }

}

