package ua.annav.mantis.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ua.annav.mantis.model.UserData;

import static org.testng.Assert.assertTrue;

public class UserHelper extends HelperBase {

  public UserHelper(WebDriver wd) {
    super((ApplicationManager) wd);
  }


  public void manageUsers() {
    click(By.xpath("//*[normalize-space(text()) and normalize-space(.)='Summary'])[1]/following::i[1]"));
    click( By.linkText("Manage Users"));

  }

  public void resetPasswordByAdmin(UserData user) {
    selectUser(user.getId());
    resetPasswordByAdmin();
  }

  public void selectUser(int id) {
      wd.findElement(By.xpath("//a[@href=\"manage_user_edit_page.php?user_id="+id+"\"]")).click();
    }

  public void resetPasswordByAdmin() {
    click( By.xpath( "//input[@value='Reset Password']" ) );
    boolean acceptNextAlert = true;
    assertTrue(closeAlertAndGetItsText( acceptNextAlert ).matches("^Delete 1 addresses[\\s\\S]$"));
  }

  public void submitResetPasswordByUser(String resetPasswordLink, String password) {
    wd.get(resetPasswordLink);
    type(By.name("password"), password);
    type(By.name("password_confirm"), password);
    click(By.cssSelector("button[type='submit']"));
  }
}
