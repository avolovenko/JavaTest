package ua.av.addressbook.tests;

import org.testng.annotations.Test;
import ua.av.addressbook.model.ContactData;
import java.time.temporal.TemporalAdjusters;

public class ContactModificationTest extends TestBase {

  @Test
  public void testContactModification() throws Exception {
    app.getNavigationHelper( ).gotoContactPage();

    if (! app.getContactHelper().isThereAContact()) {
      app.getContactHelper().createContact(new ContactData("FirstName", "LastName", "Address street, 5/1, City, PostCode", "697975432", "email@gmail.com", "Group1", "12", "DECEMBER", "2000"), true);
      Thread.sleep( 5000 );
    }
    
    app.getContactHelper( ).editContact();
    app.getContactHelper( ).fillNewContactData(new ContactData("FirstNameUpdate", "LastNameUpdate", "Address Update", "697975432", "email1@gmail.com", null, "12", "DECEMBER", "2000"), false);
    app.getContactHelper( ).submitContactModification();
  }

}
