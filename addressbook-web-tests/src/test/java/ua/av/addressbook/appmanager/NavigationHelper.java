package ua.av.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NavigationHelper extends HelperBase{

  public NavigationHelper(WebDriver wd) {
    super( wd );
  }

  public void groupPage() {
    if (isElementPresent( By.tagName( "h1" ) )
            && wd.findElement( By.tagName( "h1" ) ).getText().equals( "GROUPS" )
            && isElementPresent( By.name( "new" ) ) ) {
      return;
    }
    click( By.linkText("GROUPS"));
  }

  public void ContactPage() {
    if (isElementPresent( By.id("maintable") ) ) {
      return;
    }
    click( By.linkText("HOME"));
  }

  public void Home() {
    click( By.linkText("HOME"));
  }

  public void closeDlgBox() {
    if (isAlertPresent( ))  {
      return;
    }
    click( By.linkText("home page"));
  }

  public void returnToContactPage() {
    if (isAlertPresent( ))  {
      return;
    }
    click( By.linkText("home page"));
  }
}
