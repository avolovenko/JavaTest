package ua.av.addressbook.tests;

import org.testng.annotations.Test;
import ua.av.addressbook.model.ContactData;
import java.time.temporal.TemporalAdjusters;

public class ContactModificationTest extends TestBase {

  @Test
  public void testContactModification() throws Exception {
    app.getNavigationHelper( ).gotoContactPage();
    app.getContactHelper( ).editContact();
    app.getContactHelper( ).fillNewContactData(new ContactData("FirstNameUpdate", "LastNameUpdate", "Address Update", "697975432", "email1@gmail.com", null, "12", "DECEMBER", "2000"), false);
    app.getContactHelper( ).submitContactModification();
  }

}
