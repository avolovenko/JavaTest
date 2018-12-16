package ua.annav.mantis.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


  @Entity
  @Table(name="mantis_user_table")
  public class UserData {
    @Id
    @Column(name = "id")
    private int id ;

    @Column(name = "username")
    private String userName;

    @Column(name = "email")
    private String email;

    public int getId() {return id;  }

    public String getName() { return userName; }

    public String getEmail() { return email; }


    @Override
    public String toString() {
      return "UserData{" +
              "id=" + id +
              ", userName='" + userName + '\'' +
              ", email='" + email + '\'' +
              '}';
    }
  }




