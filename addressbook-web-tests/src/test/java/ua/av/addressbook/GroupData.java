package ua.av.addressbook;

public class GroupData {
  private final String gName;
  private final String gHeader;
  private final String gFooter;

  public GroupData(String gName, String gHeader, String gFooter) {
    this.gName = gName;
    this.gHeader = gHeader;
    this.gFooter = gFooter;
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
}
