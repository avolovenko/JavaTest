package ua.av.addressbook.tests;

import org.testng.annotations.Test;
import ua.av.addressbook.model.GroupData;
import ua.av.addressbook.model.Groups;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class GroupCreationTest extends TestBase {

  @Test
  public void testGroupCreation() throws Exception {
    app.goTo( ).groupPage();
    Groups before = app.group().all();
    GroupData group = new GroupData().withName("Group2").withHeader("Header2").withFooter("Footer2");
    app.group( ).create( group );
    Groups after = app.group().all();
    assertThat(after.size(), equalTo( before.size() +1));
    assertThat( after, equalTo(
            before.withAdded(group.withId(after.stream().mapToInt( (g) -> g.getId()).max().getAsInt()))));
  }

}
