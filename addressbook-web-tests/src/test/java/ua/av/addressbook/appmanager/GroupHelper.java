package ua.av.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ua.av.addressbook.model.GroupData;
import ua.av.addressbook.model.Groups;
import java.util.List;

public class GroupHelper extends HelperBase {

  public GroupHelper(WebDriver wd) {
    super( wd );
  }

  public void returnToGroupPage() {
    click( By.linkText( "group page" ) );
  }

  public void submitGroupCreation() {
    click( By.name("submit") );
  }

  public void fillGroupForm(GroupData groupData) {
    type( By.name( "group_name" ), groupData.getgName() );
    type( By.name("group_header"), groupData.getgHeader() );
    type( By.name("group_footer"), groupData.getgFooter() );
  }

  public void initGroupCreation() {
    click( By.name("new") );
  }

  public void deleteSelectedGroup() {
    click( By.name("delete") );
  }

  public void selectById(int id) {
    wd.findElement( By.cssSelector( "input[value='"+ id + "']" )).click();
  }

  public void initGroupModification() {
    click( By.name("edit") );
  }

  public void submitGroupModification() {
    click( By.name("update") );
  }

  public void create(GroupData group) {
    initGroupCreation();
    fillGroupForm(group);
    submitGroupCreation();
    groupCache = null;
    returnToGroupPage();
  }

  public void modify(GroupData group) {
    selectById(group.getId());
    initGroupModification();
    fillGroupForm(group);
    submitGroupModification();
    groupCache = null;
    returnToGroupPage();
  }

  public void delete(GroupData group) {
    selectById(group.getId( ));
    deleteSelectedGroup( );
    groupCache = null;
    returnToGroupPage();
  }

  public boolean isThereAGroup() {
    return isElementPresent( By.name("selected[]") );
  }

  public int count() {
    return wd.findElements( By.name( "selected[]")).size();
  }

  private Groups groupCache = null;

  public Groups all() {
    if (groupCache != null) {
      return new Groups( groupCache );
    }
    groupCache = new Groups();
    List<WebElement> elements = wd.findElements( By.cssSelector("span,group"));
    for (WebElement element : elements) {
      String name = element.getText();
      String header = element.getText();
      String footer = element.getText();
      int id = Integer.parseInt( element.findElement( By.tagName( "input" )).getAttribute( "value" ));
      groupCache.add( new  GroupData( ).withId( id ).withName( name ).withHeader(header).withFooter(footer));
    }
    return new Groups(groupCache);
  }
}
