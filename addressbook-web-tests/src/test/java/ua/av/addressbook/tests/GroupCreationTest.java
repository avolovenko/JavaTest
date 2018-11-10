package ua.av.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.*;
import ua.av.addressbook.model.GroupData;

public class GroupCreationTest extends TestBase {

  @Test
  public void testGroupCreation() throws Exception {
    app.getNavigationHelper( ).gotoGroupPage();
    int before = app.getGroupHelper().getGroupCount();
    app.getGroupHelper( ).createGroup( new GroupData("Group1", "GroupHeader1", "GroupFooter1") );
    int after = app.getGroupHelper().getGroupCount();
    Assert.assertEquals(after, before +1);
  }

}
