package ua.av.addressbook.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import ua.av.addressbook.appmanager.ApplicationManager;

import static org.openqa.selenium.remote.BrowserType.CHROME;
import static org.openqa.selenium.remote.BrowserType.FIREFOX;
import static org.openqa.selenium.remote.BrowserType.IE;

public class TestBase {

  protected final ApplicationManager app = new ApplicationManager( CHROME );

  @BeforeMethod(alwaysRun = true)
  public void setUp() throws Exception {
    app.init( );
  }

  @AfterMethod(alwaysRun = true)
  public void tearDown() throws Exception {
    app.stop( );
  }

}
