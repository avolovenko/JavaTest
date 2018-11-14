package ua.av.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ua.av.addressbook.model.ContactData;
import ua.av.addressbook.model.GroupData;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

public class ContactCreationTest extends TestBase {

  @Test
  public void testContactCreation() throws Exception {
    app.getNavigationHelper().gotoContactPage();
    List<ContactData> before = app.getContactHelper().getContactList();
    ContactData contact = new ContactData("FirstName", "LastName", "Address street, 5/1, City, PostCode", "697975432", "email@gmail.com", "Group1", "12", "DECEMBER", "2000" );
    app.getContactHelper( ).createContact( contact, true) ;
    app.getNavigationHelper().closeContactCreationDlgBox();
    app.getNavigationHelper().gotoContactPage();
    List<ContactData> after = app.getContactHelper().getContactList();
    Assert.assertEquals(after.size(), before.size() +1);

    contact.setId( after.stream().max( (o1, o2 ) -> Integer.compare( o1.getId(), o2.getId() ) ).get().getId());
    before.add( contact );
    Assert.assertEquals( new HashSet<Object>( before ), new HashSet<Object>( after ) );

  }
}
