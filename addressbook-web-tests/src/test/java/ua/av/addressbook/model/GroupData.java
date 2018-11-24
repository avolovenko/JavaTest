package ua.av.addressbook.model;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamOmitField;

import java.util.Objects;

@XStreamAlias("group")
public class GroupData {
  @XStreamOmitField
  private int id = Integer.MAX_VALUE;
  private String gName;
  private String gHeader;
  private String gFooter;

  public GroupData withId(int id) {
    this.id = id;
    return this;
  }

  public GroupData withName(String gName) {
    this.gName = gName;
    return this;
  }

  public GroupData withHeader(String gHeader) {
    this.gHeader = gHeader;
    return this;
  }

  public GroupData withFooter(String gFooter) {
    this.gFooter = gFooter;
    return this;
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
    return id == groupData.id &&
            Objects.equals( gName, groupData.gName );
  }

  @Override
  public int hashCode() {
    return Objects.hash( id, gName );
  }
}
