package ua.av.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ua.av.addressbook.model.ContactData;
import ua.av.addressbook.model.Contacts;
import ua.av.addressbook.model.GroupData;

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
    //attach( By.name( "photo" ), contactData.getPhoto());
    type( By.name( "address" ), contactData.getAddress( ) );
    type( By.name( "home" ), contactData.getPhoneHome( ) );
    type( By.name( "mobile" ), contactData.getPhoneMobile( ) );
    type( By.name( "work" ), contactData.getPhoneWork( ) );
    type( By.name( "email" ), contactData.getEmailAddress( ) );
    type( By.name( "email2" ), contactData.getEmailAddress2( ) );
    type( By.name( "email3" ), contactData.getEmailAddress3( ) );

    if (creation) {
      if (contactData.getGroups().size() > 0 ) {
        Assert.assertTrue(contactData.getGroups().size() == 1);
        new Select( wd.findElement( By.name( "new_group" ) ) ).selectByVisibleText(String.valueOf(contactData.getGroups().iterator().next().getgName()));
      }
    } else {
      Assert.assertFalse(isElementPresent( By.name( "new_group" )));
    }

    select( By.name( "bday" ), String.valueOf(contactData.getbDay( )));
    //select( By.name( "bmonth" ), contactData.getbMonth( ) );
    selectByValue( By.name( "bmonth" ), contactData.getbMonth( ) );
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
  public void selectAllContacts() {
    wd.findElement(By.name("group")).click();
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

  public Contacts all() {
    Contacts contacts = new Contacts();
    List<WebElement> elements = wd.findElements(By.xpath( "//table[@id='maintable']/tbody/tr[@name='entry']"));
    for (WebElement element : elements) {
      List<WebElement> cells = element.findElements( By.tagName( "td" ) );
      int id = Integer.parseInt(element.findElement( By.tagName( "input" )).getAttribute( "value" ));
      String lastName = element.findElement(By.xpath( "./td[2]")).getText();
      String firstName = element.findElement(By.xpath( "./td[3]")).getText();
      String allPhones = cells.get(5).getText();
      String allEmails = cells.get(4).getText();
      String address = cells.get(3).getText();
      contacts.add(new ContactData().withId(id).withFirstName(firstName).withLastName(lastName)
              .withAllPhones(allPhones).withAllEmails(allEmails).withAddress(address));
    }
    return contacts;
  }

  public ContactData infoFromEditForm(ContactData contact) {
    initContactModificationById(contact.getId());
    String firstname = wd.findElement(By.name("firstname")).getAttribute("value");
    String lastname = wd.findElement(By.name("lastname")).getAttribute("value");
    String home = wd.findElement(By.name("home")).getAttribute("value");
    String mobile = wd.findElement(By.name("mobile")).getAttribute("value");
    String work = wd.findElement(By.name("work")).getAttribute("value");
    String email = wd.findElement(By.name("email")).getAttribute("value");
    String email2 = wd.findElement(By.name("email2")).getAttribute("value");
    String email3 = wd.findElement(By.name("email3")).getAttribute("value");
    String address = wd.findElement(By.cssSelector("textarea[name=\"address\"]")).getText();

    wd.navigate().back();
    return new ContactData().withId( contact.getId() ).withFirstName( firstname ).withLastName( lastname )
            .withPhoneHome(home).withPhoneMobile(mobile).withPhoneWork(work)
            .withEmailAddress(email).withEmailAddress2( email2 ).withEmailAddress3( email3 )
            .withAddress( address );
  }

  private void initContactModificationById(int id) {
    wd.findElement( By.cssSelector( String.format( "a[href='edit.php?id=%s']", id ) ) ).click();
  }

  public void addToGroup(ContactData contact, GroupData group) {
    selectContactById(contact.getId());
    new Select(wd.findElement(By.name("to_group"))).selectByVisibleText(String.valueOf(group.getgName()));
    click( By.name("add"));
    app.goTo().ContactPage();
  }

}

