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
    app.goTo( ).groupPage(); //"Group1", "GroupHeader1", "GroupFooter1"
    if (app.group().all().size() == 0) {
      app.group().create(new GroupData().withName( "Group1" ));
    }
  }

  @Test
  public void testGroupModification () {
    Groups before = app.group().all();
    GroupData modifiedGroup = before.iterator().next();
        GroupData group = new GroupData()
            .withId(modifiedGroup.getId()).withName( "UpdatedGroup" ).withHeader( "UpdatedGroupHeader" ).withFooter( "UpdatedGroupFooter" );
    app.group().modify(group);
    assertThat(app.group().count(), equalTo( before.size()));
    Groups after = app.group().all();
    assertThat( after, equalTo(before.without(modifiedGroup).withAdded(group)));
  }

}
