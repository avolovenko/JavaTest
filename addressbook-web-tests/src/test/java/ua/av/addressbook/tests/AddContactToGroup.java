package ua.av.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ua.av.addressbook.model.ContactData;
import ua.av.addressbook.model.Contacts;
import ua.av.addressbook.model.GroupData;
import ua.av.addressbook.model.Groups;

import java.security.acl.Group;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

public class AddContactToGroup extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    if (app.db().contacts().size() == 0) {
      Groups groups = app.db().groups();
      app.goTo( ).ContactPage();
      app.contact().create(new ContactData().withFirstName("NewFirstName").withLastName("NewLastName").withAddress("NewAddress street, 5/1, City, PostCode")
              .withPhoneHome("1111").withPhoneMobile("2222").withPhoneWork("2336")
              //.withEmailAddress("email@gmail.com").withEmailAddress2("email2@gmail.com").withEmailAddress3("email3@gmail.com")
              .withbDay(Integer.valueOf("12"))
              .withbMonth("December").withbYear("2000").inGroup(groups.iterator().next()), true);
      app.goTo().closeDlgBox();
      app.goTo().ContactPage();
    }
    if (app.db().groups().size() == 0) {
      app.goTo().groupPage();
      app.group().create(new GroupData().withName("Group1"));
    }
    app.contact().selectAllContacts();
  }

  @Test
  public void testContactAddToGroup() throws Exception {

    //Groups availableGroups = app.db().availableGroups(contact.getId());
    ContactData usedContact = app.db().contacts().iterator().next();
    Groups before = app.db().availableGroups(usedContact.getId());
    GroupData usedGroup = before.iterator().next();
    app.contact().addToGroup(usedContact, usedGroup);
    Groups after = app.db().availableGroups(usedContact.getId());
    assertEquals( after.size(), before.size() - 1);
    assertThat(after, equalTo(before.without(usedGroup)));
  }

}
