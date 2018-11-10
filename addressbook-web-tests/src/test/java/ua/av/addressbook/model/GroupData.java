package ua.av.addressbook.model;

import java.util.Objects;

public class GroupData {
  private final String id;
  private final String gName;
  private final String gHeader;
  private final String gFooter;

  public GroupData(String id,String gName, String gHeader, String gFooter) {
    this.id = id;
    this.gName = gName;
    this.gHeader = gHeader;
    this.gFooter = gFooter;
  }

  public GroupData(String gName, String gHeader, String gFooter) {
    this.id = null;
    this.gName = gName;
    this.gHeader = gHeader;
    this.gFooter = gFooter;
  }

  public String getId() {
    return id;
  }

  public String getgName() {
    return gName;
  }

  public String getgHeader() {
    return gHeader;
  }

  public String getgFooter() {
    return gFooter;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass( ) != o.getClass( )) return false;
    GroupData groupData = (GroupData) o;
    return Objects.equals( id, groupData.id ) &&
            Objects.equals( gName, groupData.gName );
  }

  @Override
  public int hashCode() {
    return Objects.hash( id, gName );
  }

  @Override
  public String toString() {
    return "GroupData{" +
            "Id='" + id + '\'' +
            ", gName='" + gName + '\'' +
            '}';
  }

}
