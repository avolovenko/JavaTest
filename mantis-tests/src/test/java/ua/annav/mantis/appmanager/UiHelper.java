package ua.annav.mantis.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ua.annav.mantis.model.UserData;

import static org.testng.Assert.assertTrue;

public class UiHelper extends HelperBase{

  public UiHelper(ApplicationManager app) {
    super(app);
  }

  public void login(String username, String password){
    wd.get(app.getProperty("web.baseUrl") + "/login_page.php");
    type(By.name("username"), username);
    click(By.cssSelector("input[value='Login']"));
    type(By.name("password"), password);
    click(By.cssSelector("input[value='Login']"));
  }

  public void logout(){
    click(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='administrator'])[1]/following::i[1]"));
    click(By.linkText("Logout"));
  }

  public void manageUsers() {
    click(By.cssSelector("a[href = '/mantisbt-2.18.0/manage_overview_page.php']"));
    click(By.cssSelector("a[href = '/mantisbt-2.18.0/manage_user_page.php']"));
    //click( By.linkText("Manage Users"));

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
  }

  public void submitResetPasswordByUser(String resetPasswordLink, String name, String password) {
    //wd.get(app.getProperty("web.baseUrl") + "/login_page.php");
    wd.get(resetPasswordLink);
    type(By.name("realname"), name);
    type(By.name("password"), password);
    type(By.name("password_confirm"), password);
    click(By.cssSelector("button[type='submit']"));
  }

  public void exit() {
    wd.quit();
  }
}
