package ua.av.addressbook.tests;

import org.hamcrest.MatcherAssert;
import org.openqa.selenium.remote.BrowserType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import ua.av.addressbook.appmanager.ApplicationManager;
import ua.av.addressbook.model.ContactData;
import ua.av.addressbook.model.Contacts;
import ua.av.addressbook.model.GroupData;
import ua.av.addressbook.model.Groups;

import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.openqa.selenium.remote.BrowserType.CHROME;
import static org.openqa.selenium.remote.BrowserType.FIREFOX;
import static org.openqa.selenium.remote.BrowserType.IE;

public class TestBase {

  Logger logger = LoggerFactory.getLogger(TestBase.class);

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

  @AfterSuite
  public void tearDown() throws Exception {
    app.stop( );
  }

  @BeforeMethod(alwaysRun = true)
  public void logTestStart(Method m, Object[] p) {
    logger.info("Start test " + m.getName() + " with parameters " + Arrays.asList(p));
  }

  @AfterMethod(alwaysRun = true)
  public void logTestStop(Method m) {
    logger.info("Stop test " + m.getName());
  }

  public void VerifyGroupListInUi() {
    if (Boolean.getBoolean("verifyUI")) {
      Groups dbGroups = app.db().groups();
      Groups uiGroups = app.group().all();
      //assertThat(uiGroups, equalTo(dbGroups));

      assertThat(uiGroups.stream()
                      .map((g) -> new GroupData().withId(g.getId()).withName(g.getgName()))
                      .collect(Collectors.toSet()),
              equalTo(dbGroups.stream()
                      .map((g) -> new GroupData().withId(g.getId()).withName(g.getgName()))
                      .collect(Collectors.toSet())));
    }
  }

  protected Groups refreshContact(Integer findContact) {
    Contacts contacts = app.db().contacts();
    for (ContactData contact : contacts) {
      if (contact.getId() == findContact) {
        return contact.getGroups();
      }
      return null;
    }
    return null;
  }
}

