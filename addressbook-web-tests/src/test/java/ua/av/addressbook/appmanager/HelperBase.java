package ua.av.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class HelperBase {
  private WebDriver wd;

  public HelperBase(WebDriver wd) {
    this.wd = wd;
  }

  public void click(By locator) {
    wd.findElement( locator ).click();
  }

  public void type(By locator, String text) {
    click( locator );
    wd.findElement( locator ).clear();
    wd.findElement( locator ).sendKeys( text );
  }

  public void select(By locator, String text) {
    wd.findElement( locator ).click();
    new Select( wd.findElement(locator)).selectByVisibleText( text );
    wd.findElement(locator).click();
  }

  private boolean isAlertPresent() {
    try {
      wd.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }
  private boolean isElementPresent(By by) {
    try {
      wd.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

}
