package ua.av.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ua.av.addressbook.model.GroupData;

import java.util.Comparator;
import java.util.List;

public class GroupCreationTest extends TestBase {

  @Test
  public void testGroupCreation() throws Exception {
    app.getNavigationHelper( ).gotoGroupPage();
    List<GroupData> before = app.getGroupHelper().getGroupList();
    GroupData group = new GroupData( "Group1", "GroupHeader1", "GroupFooter1");
    app.getGroupHelper( ).createGroup( group );
    List<GroupData> after = app.getGroupHelper().getGroupList();
    Assert.assertEquals(after.size(), before.size() +1);

    before.add(group);
    Comparator<? super GroupData> byId = (g1, g2) -> Integer.compare( g1.getId(), g2.getId() );
    before.sort( byId );
    after.sort( byId );
    Assert.assertEquals( before, after );
  }

}
