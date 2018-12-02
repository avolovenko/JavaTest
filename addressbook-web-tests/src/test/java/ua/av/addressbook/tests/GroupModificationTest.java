package ua.av.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ua.av.addressbook.model.GroupData;
import ua.av.addressbook.model.Groups;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

public class GroupModificationTest extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    System.out.println("If no");
    if (app.db().groups().size() == 0) {
      app.goTo().groupPage();
      app.group().create(new GroupData().withName( "Group1" ));
    }

  }

  @Test
  public void testGroupModification () {
    Groups before = app.db().groups();
    GroupData modifiedGroup = before.iterator().next();
    GroupData group = new GroupData()
            .withId(modifiedGroup.getId()).withName( "UpdatedGroup" ).withHeader( "UpdatedGroupHeader" ).withFooter( "UpdatedGroupFooter" );
    app.goTo( ).groupPage();
    app.group().modify(group);
    assertThat(app.group().count(), equalTo( before.size()));
    Groups after = app.db().groups();
    assertThat( after, equalTo(before.without(modifiedGroup).withAdded(group)));
    VerifyGroupListInUi();
  }


}
