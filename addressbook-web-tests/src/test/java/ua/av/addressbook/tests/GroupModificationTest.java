package ua.av.addressbook.tests;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ua.av.addressbook.model.GroupData;
import ua.av.addressbook.model.Groups;

import java.util.Set;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;
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
    Groups after = app.group().all();
    assertEquals(after.size(), before.size() );

    before.remove( modifiedGroup);
    before.add( group );
    assertThat( after, equalTo(before.without(modifiedGroup).withAdded(modifiedGroup)));
  }

}
