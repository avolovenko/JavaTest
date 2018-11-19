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
    app.goTo( ).ContactPage();
    if (app.contact().all().size() == 0) {
      app.contact().create(new ContactData().withFirstName("FirstName").withLastName("LastName"), true);
      app.goTo().closeDlgBox();
      app.goTo().ContactPage();
    }
  }

  @Test
  public void testContactDeletion() throws Exception {
    Contacts before = app.contact().all();
    ContactData deletedContact = before.iterator().next();
    app.contact().delete(deletedContact);
    Contacts after = app.contact().all();
    assertEquals( after.size(), before.size() -1);
    assertThat(after, equalTo(before.without(deletedContact)));
  }

}
