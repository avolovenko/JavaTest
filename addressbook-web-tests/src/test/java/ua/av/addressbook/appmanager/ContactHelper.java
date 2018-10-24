package ua.av.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import ua.av.addressbook.model.ContactData;

public class ContactHelper {
  private WebDriver wd;

  public ContactHelper(WebDriver wd) {
    this.wd = wd;
  }

  public void submitNewContact() {
    wd.findElement( By.xpath("(//input[@name='submit'])[2]")).click();
  }

  public void fillNewContactData(ContactData contactData) {
    wd.findElement(By.name("firstname")).click();
    wd.findElement(By.name("firstname")).clear();
    wd.findElement(By.name("firstname")).sendKeys(contactData.getFirstName());
    wd.findElement(By.name("lastname")).clear();
    wd.findElement(By.name("lastname")).sendKeys(contactData.getLastName());
    wd.findElement(By.name("address")).clear();
    wd.findElement(By.name("address")).sendKeys(contactData.getAddress());
    wd.findElement(By.name("mobile")).click();
    wd.findElement(By.name("mobile")).clear();
    wd.findElement(By.name("mobile")).sendKeys(contactData.getPhoneMobile());
    wd.findElement(By.name("email")).click();
    wd.findElement(By.name("email")).clear();
    wd.findElement(By.name("email")).sendKeys(contactData.getEmailAddress());
    wd.findElement(By.name("bday")).click();
    new Select( wd.findElement(By.name("bday"))).selectByVisibleText(contactData.getbDay());
    wd.findElement(By.name("bday")).click();
    wd.findElement(By.name("bmonth")).click();
    new Select( wd.findElement(By.name("bmonth"))).selectByVisibleText(contactData.getbMonth());
    wd.findElement(By.name("bmonth")).click();
    wd.findElement(By.name("byear")).click();
    wd.findElement(By.name("byear")).clear();
    wd.findElement(By.name("byear")).sendKeys(contactData.getbYear());
  }

  public void initNewContact() {
    wd.findElement(By.linkText("ADD_NEW")).click();
  }
}
