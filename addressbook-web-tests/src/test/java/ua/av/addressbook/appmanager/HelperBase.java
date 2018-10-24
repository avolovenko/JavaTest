package ua.av.addressbook.appmanager;

import org.openqa.selenium.*;
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
