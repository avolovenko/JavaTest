package ua.av.addressbook.tests;

import org.testng.annotations.Test;
import ua.av.addressbook.model.ContactData;

public class ContactDeletion extends TestBase {

  @Test
  public void testContactDeletion() throws Exception {
    app.getNavigationHelper( ).gotoContactPage();
    app.getContactHelper().selectContact( );
    app.getContactHelper( ).deleteContact();
  }

}
