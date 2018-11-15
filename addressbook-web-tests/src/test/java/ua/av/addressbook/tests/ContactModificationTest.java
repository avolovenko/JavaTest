package ua.av.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ua.av.addressbook.model.ContactData;
import ua.av.addressbook.model.GroupData;

import java.util.Comparator;
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
    app.getContactHelper( ).editContact(before.size() - 1);
    ContactData contact = new ContactData( before.get( before.size() - 1).getId(), "FirstNameUpdate1", "LastNameUpdate1", "Address Update1", "697975432", "email1@gmail.com", null, "12", "DECEMBER", "2000") ;
    app.getContactHelper( ).fillNewContactData(contact, false);
    app.getContactHelper( ).submitContactModification();
    app.getNavigationHelper().returnToContactPage();
    List<ContactData> after = app.getContactHelper().getContactList();
    Assert.assertEquals( after.size(), before.size());

    before.remove( before.size() - 1);
    before.add( contact );
    //contact.setId( after.stream().max( (o1, o2 ) -> Integer.compare( o1.getId(), o2.getId() ) ).get().getId());
    Comparator<? super ContactData> byId = (o1, o2) -> Integer.compare( o1.getId(), o2.getId() );
    before.sort( byId );
    after.sort( byId );
    Assert.assertEquals( before, after);
    //Assert.assertEquals( new HashSet<Object>( before ), new HashSet<Object>( after ) );
  }

}
