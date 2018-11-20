package ua.av.addressbook.appmanager;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;

public class HelperBase {
  public WebDriver wd;

  public HelperBase(WebDriver wd) {
    this.wd = wd;
  }

  public void click(By locator) {
    wd.findElement( locator ).click();
  }

  public void type(By locator, String text) {
    click( locator );
    wd.findElement( locator ).clear();
    if (text == null) {
      return;
    } wd.findElement( locator ).sendKeys( text );
  }

  public void select(By locator, String text) {
    wd.findElement( locator ).click();
    new Select( wd.findElement(locator)).selectByVisibleText( text );
    wd.findElement(locator).click();
  }

  public String closeAlertAndGetItsText(boolean acceptNextAlert) {
    try {
      Alert alert = wd.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }

  public boolean isAlertPresent() {
    try {
      wd.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  public boolean isElementPresent(By locator) {
    try {
      wd.findElement( locator );
      return true;
    } catch (NoSuchElementException ex) {
      return false;
    }
  }
}
