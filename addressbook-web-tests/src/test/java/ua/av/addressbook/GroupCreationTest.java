package ua.av.addressbook;

import org.testng.annotations.*;

public class GroupCreationTest extends  TestBase {

  @Test
  public void testGroupCreation() throws Exception {
    gotoGroupPage();
    initGroupCreation();
    fillGroupForm(new GroupData("Group2", "GroupHeader2", "GroupFooter2"));
    submitGroupCreation();
    returnToGroupPage();
  }

}
