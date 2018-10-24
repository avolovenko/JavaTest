package ua.av.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ua.av.addressbook.model.GroupData;

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

  public void selectGroup() {
    click( By.xpath("(//input[@name='selected[]'])[1]") );
  }

  public void initGroupModification() {
    click( By.name("edit") );
  }

  public void submitGroupModification() {
    click( By.name("update") );
  }
}
