package ua.av.addressbook.tests;

import org.testng.annotations.*;
import ua.av.addressbook.model.GroupData;

public class GroupCreationTest extends TestBase {

  @Test
  public void testGroupCreation() throws Exception {
    app.gotoGroupPage();
    app.initGroupCreation();
    app.fillGroupForm(new GroupData("Group2", "GroupHeader2", "GroupFooter2"));
    app.submitGroupCreation();
    app.returnToGroupPage();
  }

}
