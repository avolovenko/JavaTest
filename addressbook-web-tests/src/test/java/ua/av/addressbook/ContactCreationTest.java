package ua.av.addressbook;

import org.testng.annotations.Test;

public class ContactCreationTest extends  TestBase {

  @Test
  public void testContactCreation() throws Exception {
    initNewContact();
    fillNewContactData(new ContactData("FirstName", "LastName", "Address street, 5/1, City, PostCode", "697975432", "email@gmail.com", "12", "DECEMBER", "2000"));
    submitNewContact();
  }

}
