package ua.av.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ua.av.addressbook.model.ContactData;
import java.util.HashSet;
import java.util.List;

public class ContactModificationTest extends TestBase {

  @Test
  public void testContactModification() throws Exception {
    app.getNavigationHelper( ).gotoContactPage();
    if (! app.getContactHelper().isThereAContact()) {
      app.getContactHelper().createContact(new ContactData("FirstName", "LastName", "Address street, 5/1, City, PostCode", "697975432", "email@gmail.com", "Group1", "12", "DECEMBER", "2000"), true);
      app.getNavigationHelper().closeContactCreationDlgBox();
      app.getNavigationHelper().gotoContactPage();
    }
    List<ContactData> before = app.getContactHelper().getContactList();
    app.getContactHelper().selectContact( before.size() - 1 );
    app.getContactHelper( ).editContact();
    ContactData contact = new ContactData( before.get( before.size() - 1 ).getId(), "FirstNameUpdate", "LastNameUpdate", "Address Update", "697975432", "email1@gmail.com", null, "12", "DECEMBER", "2000") ;
    app.getContactHelper( ).fillNewContactData(contact, false);
    app.getContactHelper( ).submitContactModification();
    app.getNavigationHelper().returnToContactPage();
    List<ContactData> after = app.getContactHelper().getContactList();
    Assert.assertEquals( after.size(), before.size());

    before.remove( before.size() - 1);
    contact.setId( after.stream().max( (o1, o2 ) -> Integer.compare( o1.getId(), o2.getId() ) ).get().getId());
    before.add( contact );
    Assert.assertEquals( new HashSet<Object>( before ), new HashSet<Object>( after ) );
  }

}
