package ua.av.addressbook.tests;

import org.testng.annotations.Test;
import ua.av.addressbook.model.GroupData;

public class GroupDeletionTest extends TestBase {

  @Test
  public void testGroupDeletion() throws Exception {
    app.getNavigationHelper( ).gotoGroupPage();
    if (! app.getGroupHelper().isThereAGroup()) {
      app.getGroupHelper().createGroup(new GroupData("Group1", "GroupHeader1", "GroupFooter1"));
    }
    app.getGroupHelper( ).selectGroup( );
    app.getGroupHelper( ).deleteSelectedGroup( );
    app.getGroupHelper( ).returnToGroupPage();
  }

}
