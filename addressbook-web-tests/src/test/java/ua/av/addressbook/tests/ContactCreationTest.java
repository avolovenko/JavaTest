package ua.av.addressbook.tests;

import org.testng.annotations.Test;
import ua.av.addressbook.model.ContactData;

public class ContactCreationTest extends TestBase {

  @Test
  public void testContactCreation() throws Exception {
    app.initNewContact();
    app.fillNewContactData(new ContactData("FirstName", "LastName", "Address street, 5/1, City, PostCode", "697975432", "email@gmail.com", "12", "DECEMBER", "2000"));
    app.submitNewContact();
  }

}
