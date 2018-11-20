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
    assertThat(app.group().count(), equalTo( before.size() +1));
    Groups after = app.group().all();
    assertThat( after, equalTo(
            before.withAdded(group.withId(after.stream().mapToInt( (g) -> g.getId()).max().getAsInt()))));
  }

  @Test
  public void testBadGroupCreation() throws Exception {
    app.goTo( ).groupPage();
    Groups before = app.group().all();
    GroupData group = new GroupData().withName("Group2'");
    app.group( ).create( group );
    assertThat(app.group().count(), equalTo( before.size()));
    Groups after = app.group().all();
    assertThat( after, equalTo(before));
  }

}
