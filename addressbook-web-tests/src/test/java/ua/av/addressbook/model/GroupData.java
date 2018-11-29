package ua.av.addressbook.model;

import com.google.gson.annotations.Expose;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamOmitField;
import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;

@XStreamAlias("group")
@Entity
@Table(name="group_list")
public class GroupData {
  @XStreamOmitField
  @Id
  @Column(name = "group_id")
  private int id = Integer.MAX_VALUE;

  @Expose
  @Column(name = "group_name")
  private String gName;

  @Expose
  @Column(name = "group_header")
  @Type(type="text")
  private String gHeader;

  @Expose
  @Column(name = "group_footer")
  @Type(type="text")
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
