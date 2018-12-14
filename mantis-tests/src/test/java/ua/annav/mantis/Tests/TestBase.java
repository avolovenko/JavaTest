package ua.annav.mantis.Tests;

import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import ua.annav.mantis.appmanager.ApplicationManager;

import java.io.IOException;

public class TestBase {

  public static ApplicationManager app = null;

  static {
    try {
      app = new ApplicationManager(System.getProperty("browser", BrowserType.CHROME));
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  @BeforeSuite
  public void setUp() throws Exception {
    app.init( );
  }

  @AfterSuite (alwaysRun = true)
  public void tearDown() throws Exception {
    app.stop( );
  }

}

