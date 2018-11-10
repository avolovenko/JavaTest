package ua.av.addressbook.model;

import java.util.Objects;

public class GroupData {
  public void setId(int id) {
    this.id = id;
  }

  private int id;
  private final String gName;
  private final String gHeader;
  private final String gFooter;

  public GroupData(int id,String gName, String gHeader, String gFooter) {
    this.id = id;
    this.gName = gName;
    this.gHeader = gHeader;
    this.gFooter = gFooter;
  }

  public GroupData(String gName, String gHeader, String gFooter) {
    this.id = Integer.MAX_VALUE;
    this.gName = gName;
    this.gHeader = gHeader;
    this.gFooter = gFooter;
  }

  public int getId() {return id;  }

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
  public String toString() {
    return "GroupData{" +
            "Id='" + id + '\'' +
            ", gName='" + gName + '\'' +
            '}';
  }
  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass( ) != o.getClass( )) return false;
    GroupData groupData = (GroupData) o;
    return Objects.equals( gName, groupData.gName );
  }

  @Override
  public int hashCode() {
    return Objects.hash( gName );
  }

}
