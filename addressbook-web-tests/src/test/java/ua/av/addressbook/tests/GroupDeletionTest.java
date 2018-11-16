package ua.av.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ua.av.addressbook.model.GroupData;

import java.util.List;

public class GroupDeletionTest extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    app.goTo( ).groupPage(); //"Group1", "GroupHeader1", "GroupFooter1"
    if (app.group().list().size() == 0) {
      app.group().create(new GroupData().withName( "Group1" ));
    }
  }

  @Test
  public void testGroupDeletion() throws Exception {
    List<GroupData> before = app.group().list();
    int index = before.size() -1;
    app.group().delete( index );
    List<GroupData> after = app.group().list();
    Assert.assertEquals(after.size(), before.size() -1);

    before.remove( index);
    Assert.assertEquals( after, before );
  }

}
