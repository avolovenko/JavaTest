package ua.annav.mantis.Tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.lanwen.verbalregex.VerbalExpression;
import ua.annav.mantis.appmanager.HttpSession;
import ua.annav.mantis.model.MailMessage;
import ua.annav.mantis.model.UserData;
import ua.annav.mantis.model.Users;

import java.io.IOException;
import java.util.List;

import static org.testng.Assert.assertTrue;

public class ChangePasswordTest extends TestBase  {

  @BeforeMethod
  public void startMailServer() {
    app.mail().start();
  }

  @Test
  public void TestChangePasswordT() throws IOException {
    long now = System.currentTimeMillis();
    String realName = "RealUserName";
    //String.format("user%s", now);
    String password = "password1";

    Users users = app.db().users();
    UserData user = users.iterator().next();

    app.ui().login(app.getProperty("web.adminLogin"), app.getProperty("web.adminPassword"));
    app.ui().manageUsers();
    app.ui().resetPasswordByAdmin(user);
    app.ui().logout();

    List<MailMessage> mailMessages = app.mail().waitForMail(1, 10000);
    String resetPasswordLink = findResetPasswordLink(mailMessages, user.getEmail());

    app.ui().submitResetPasswordByUser(resetPasswordLink, realName, password);
    app.ui().exit();

    assertTrue(app.newSession().login(user.getName(), password));



  }

  private String findResetPasswordLink(List<MailMessage> mailMessages, String email) {
    MailMessage mailMessage = mailMessages.stream().filter((m) -> m.to.equals(email)).findFirst().get();
    VerbalExpression regex = VerbalExpression.regex().find("http://").nonSpace().oneOrMore().build();
    return regex.getText(mailMessage.text);
  }



  @AfterMethod(alwaysRun = true)
  public void stopMailServer() {
    app.mail().stop();
  }

}
