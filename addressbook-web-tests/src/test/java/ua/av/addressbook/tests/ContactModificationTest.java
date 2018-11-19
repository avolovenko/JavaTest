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
    app.goTo( ).ContactPage();
    if (app.contact().all().size() == 0) {
      app.contact().create(new ContactData().withFirstName("FirstName").withLastName("LastName"), true);
      app.goTo().closeDlgBox();
      app.goTo().ContactPage();
    }
  }

  @Test
  public void testContactModification() throws Exception {
    Contacts before = app.contact().all();
    ContactData modifiedContact = before.iterator().next();
    ContactData contact = new ContactData()
            .withId(modifiedContact.getId()).withFirstName("FirstName").withLastName("LastName")
            .withAddress("Address street, 5/1, City, PostCode")
            .withPhoneMobile("697975432").withEmailAddress("email@gmail.com").withGroup("Group1")
            .withbDay("12").withbMonth("DECEMBER").withbYear("2000");
    app.contact().modify(contact);
    Contacts after = app.contact().all();
    assertEquals( after.size(), before.size());
    assertThat(after, equalTo(before.without( modifiedContact ).withAdded( contact )));
  }

}
