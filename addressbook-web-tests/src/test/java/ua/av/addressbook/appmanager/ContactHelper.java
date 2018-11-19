package ua.av.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ua.av.addressbook.model.ContactData;
import ua.av.addressbook.model.Contacts;
import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.assertTrue;
import static ua.av.addressbook.tests.TestBase.app;

public class ContactHelper extends HelperBase {

  public ContactHelper(WebDriver wd) {
    super( wd );
  }

  public void initNewContact() {
    click( By.linkText("ADD_NEW"));
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

  public void submitNewContact() {
    click( By.xpath("(//input[@name='submit'])[2]"));
  }

  public void editContactById(int id) {
      wd.findElement(By.xpath("//a[@href=\"edit.php?id="+id+"\"]")).click();
  }

  public void submitContactModification() {
    click( By.xpath("(//input[@name='update'])[1]") );
  }

  public void selectContactById(int id) {
    wd.findElement(By.cssSelector("input[value='"+ id + "']" )).click();
  }

  public void deleteContact() {
    click( By.xpath( "//input[@value='DELETE']" ) );
    boolean acceptNextAlert = true;
    assertTrue(closeAlertAndGetItsText( acceptNextAlert ).matches("^Delete 1 addresses[\\s\\S]$"));
  }

  public void delete(ContactData contact) {
    selectContactById(contact.getId());
    deleteContact();
    app.goTo().ContactPage();
  }

  public void create(ContactData contact, boolean creation) {
    initNewContact();
    fillNewContactData(contact, creation);
    submitNewContact();
    app.goTo().closeDlgBox();
    app.goTo().ContactPage();
  }

  public void modify(ContactData contact) {
    editContactById(contact.getId());
    fillNewContactData(contact, false);
    submitContactModification();
    app.goTo().returnToContactPage();
  }

  public boolean isThereAContact() {
    return isElementPresent( By.xpath("//table[@id='maintable']/tbody/tr[2]/td[2]"));
  }

  public List<ContactData> list() {
    List<ContactData> contacts = new ArrayList<ContactData>( );
    WebElement table = wd.findElement(By.id("maintable"));
    List<WebElement> elements = wd.findElements(By.xpath( "//table[@id='maintable']/tbody/tr[@name='entry']"));
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
      contacts.add(new ContactData().withId(id).withFirstName(firstName).withLastName(lastName));
    }
    return contacts;
  }

  public Contacts all() {
    Contacts contacts = new Contacts();
    List<WebElement> elements = wd.findElements(By.xpath( "//table[@id='maintable']/tbody/tr[@name='entry']"));
    for (WebElement element : elements) {
      int id = Integer.parseInt(element.findElement( By.tagName( "input" )).getAttribute( "value" ));
      String lastName = element.findElement(By.xpath( "./td[2]")).getText();
      String firstName = element.findElement(By.xpath( "./td[3]")).getText();
      contacts.add(new ContactData().withId(id).withFirstName(firstName).withLastName(lastName));
    }
    return contacts;
  }
}

