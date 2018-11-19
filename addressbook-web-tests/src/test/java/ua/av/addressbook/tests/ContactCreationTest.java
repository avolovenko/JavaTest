package ua.av.addressbook.tests;

import org.testng.annotations.Test;
import ua.av.addressbook.model.ContactData;
import ua.av.addressbook.model.Contacts;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactCreationTest extends TestBase {

  @Test
  public void testContactCreation() throws Exception {
    app.goTo().ContactPage();
    Contacts before = app.contact().all();
    ContactData contact = new ContactData()
            .withFirstName("FirstName").withLastName("LastName").withAddress("Address street, 5/1, City, PostCode")
            .withPhoneMobile("697975432").withEmailAddress("email@gmail.com").withGroup("Group1")
            .withbDay("12").withbMonth("DECEMBER").withbYear("2000");
    app.contact( ).create( contact, true) ;
    Contacts after = app.contact().all();
    assertThat( after.size(), equalTo( before.size() + 1 ) );
    assertThat( after, equalTo( before.withAdded(contact.withId( after.stream().mapToInt((c) -> c.getId()).max().getAsInt()))));
  }
}
