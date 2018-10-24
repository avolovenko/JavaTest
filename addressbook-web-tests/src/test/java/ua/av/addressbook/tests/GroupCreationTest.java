package ua.av.addressbook.tests;

import org.testng.annotations.*;
import ua.av.addressbook.model.GroupData;

public class GroupCreationTest extends TestBase {

  @Test
  public void testGroupCreation() throws Exception {
    app.getNavigationHelper( ).gotoGroupPage();
    app.getGroupHelper( ).initGroupCreation();
    app.getGroupHelper( ).fillGroupForm(new GroupData("Group3", "GroupHeader3", "GroupFooter3"));
    app.getGroupHelper( ).submitGroupCreation();
    app.getGroupHelper( ).returnToGroupPage();
  }

}
