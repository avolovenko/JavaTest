package ua.av.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ua.av.addressbook.model.ContactData;
import ua.av.addressbook.model.Contacts;
import ua.av.addressbook.model.GroupData;
import ua.av.addressbook.model.Groups;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

public class RemoveContactFromGroup extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {

    if (app.db().groups().size() == 0) {
      app.goTo().groupPage();
      app.group().create(new GroupData().withName("Group1"));
    }

    if (app.db().contacts().size() == 0) {
      Groups groups = app.db().groups();
      app.goTo().ContactPage();
      app.contact().create(new ContactData().withFirstName("NewFirstName").withLastName("NewLastName").withAddress("NewAddress street, 5/1, City, PostCode")
              .withPhoneHome("1111").withPhoneMobile("2222").withPhoneWork("2336")
              .withbDay(Integer.valueOf("12"))
              .withbMonth("December").withbYear("2000").inGroup(groups.iterator().next()), true);
      app.goTo().Home();
    }
  }


  @Test
  public void testRemoveContactFromGroup() throws Exception {

    Contacts contacts = app.db().contacts();
    //Groups groups = app.db().groups();

    app.goTo().ContactPage();
    for (ContactData contact : contacts) {
      if (contact.getGroups() != null) {
        Groups groupsBefore = contact.getGroups();
        app.contact().removeFromGroup(contact.getId(), String.valueOf(contact.getGroups().iterator().next().getId()));
        Groups groupsAfter = refreshContact(contact.getId());
        assertEquals(groupsAfter.size(), groupsBefore.size() - 1);
        return;
      } else {
        System.out.println("There are no contacts in groups");
      }

    }

  }

}


