package ua.av.addressbook.tests;

import org.testng.annotations.*;
import ua.av.addressbook.model.GroupData;

public class GroupCreationTest extends TestBase {

  @Test
  public void testGroupCreation() throws Exception {
    app.getNavigationHelper( ).gotoGroupPage();
    app.getGroupHelper( ).createGroup( new GroupData("Group1", "GroupHeader1", "GroupFooter1") );
  }

}
