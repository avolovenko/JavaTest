package ua.av.addressbook.tests;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import ua.av.addressbook.appmanager.ApplicationManager;

import static org.openqa.selenium.remote.BrowserType.CHROME;
import static org.openqa.selenium.remote.BrowserType.FIREFOX;
import static org.openqa.selenium.remote.BrowserType.IE;

public class TestBase {

  protected static ApplicationManager app = new ApplicationManager( CHROME );

  @BeforeSuite
  public void setUp() throws Exception {
    app.init( );
  }

  @AfterSuite
  public void tearDown() throws Exception {
    app.stop( );
  }

}
