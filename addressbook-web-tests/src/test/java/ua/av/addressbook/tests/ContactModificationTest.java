package ua.av.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ua.av.addressbook.model.ContactData;
import ua.av.addressbook.model.Contacts;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

public class ContactModificationTest extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    if (app.db().contacts().size() == 0) {
      app.goTo( ).ContactPage();
      app.contact().create(new ContactData().withFirstName("NewFirstName").withLastName("NewLastName").withAddress("NewAddress street, 5/1, City, PostCode")
              .withPhoneHome("1111").withPhoneMobile("2222").withPhoneWork("2336")
              //.withEmailAddress("email@gmail.com").withEmailAddress2("email2@gmail.com").withEmailAddress3("email3@gmail.com")
              //.withbDay(Integer.valueOf("12"))
              .withbMonth("DECEMBER").withbYear("2000").withGroup("Group1"), true);
      app.goTo().closeDlgBox();
      app.goTo().ContactPage();
    }
  }

  @Test
  public void testContactModification() throws Exception {
    Contacts before = app.db().contacts();
    ContactData modifiedContact = before.iterator().next();
    ContactData contact = new ContactData()
            .withId(modifiedContact.getId()).withFirstName("FirstName").withLastName("LastName").withAddress("Address street, 5/1, City, PostCode")
            .withPhoneHome("12345").withPhoneMobile("697975432").withPhoneWork("2336")
            //.withEmailAddress("email@gmail.com").withEmailAddress2("email2@gmail.com").withEmailAddress3("email3@gmail.com")
            .withbDay(Integer.valueOf("12"))
            .withbMonth("DECEMBER").withbYear("2000");
    app.contact().modify(contact);
    Contacts after = app.db().contacts();
    assertEquals( after.size(), before.size());

    assertThat(after, equalTo(before.without( modifiedContact ).withAdded( contact )));
  }

}
