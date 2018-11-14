package ua.av.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ua.av.addressbook.model.ContactData;

import java.util.List;

public class ContactDeletion extends TestBase {

  @Test
  public void testContactDeletion() throws Exception {
    app.getNavigationHelper( ).gotoContactPage();
    if (! app.getContactHelper().isThereAContact()) {
      app.getContactHelper().createContact(new ContactData("FirstName", "LastName", "Address street, 5/1, City, PostCode", "697975432", "email@gmail.com", "Group1", "12", "DECEMBER", "2000"), true);
      Thread.sleep( 5000 );
    }
    List<ContactData> before = app.getContactHelper().getContactList();
    app.getContactHelper().selectContact( before.size() -1);
    app.getContactHelper( ).deleteContact();
    app.getNavigationHelper().gotoContactPage();
    List<ContactData> after = app.getContactHelper().getContactList();
    Assert.assertEquals( after.size(), before.size() - 1);

    before.remove( before.size() - 1 );
    Assert.assertEquals( before, after);
  }

}
