package ua.av.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ua.av.addressbook.model.ContactData;
import ua.av.addressbook.model.Contacts;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

public class ContactDeletion extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    if (app.contact().all().size() == 0) {
      app.goTo( ).ContactPage();
      app.contact().create(new ContactData().withFirstName("NewFirstName").withLastName("NewLastName").withAddress("NewAddress street, 5/1, City, PostCode")
              .withPhoneHome("1111").withPhoneMobile("2222").withPhoneWork("2336")
              .withEmailAddress("email@gmail.com").withEmailAddress2("email2@gmail.com").withEmailAddress3("email3@gmail.com")
              .withbDay(Integer.valueOf("12")).withbMonth("DECEMBER").withbYear("2000").withGroup("Group1"), true);
      app.goTo().closeDlgBox();
      app.goTo().ContactPage();
    }
  }

  @Test
  public void testContactDeletion() throws Exception {
    Contacts before = app.db().contacts();
    ContactData deletedContact = before.iterator().next();
    app.contact().delete(deletedContact);
    Contacts after = app.db().contacts();
    assertEquals( after.size(), before.size() -1);
    assertThat(after, equalTo(before.without(deletedContact)));
  }

}
