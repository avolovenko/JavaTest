package ua.annav.rest;

import java.util.Objects;

public class Issue {

  private int id;
  private String subject;
  private String description;
  private String state;
  private String state_name;

  public int getId() {
    return id;
  }

  public Issue withId(int id) {
    this.id = id;
    return this;
  }

  public String getSubject() {
    return subject;
  }

  public Issue withSubject(String subject) {
    this.subject = subject;
    return this;
  }

  public String getDescription() {
    return description;
  }

  public Issue withDescription(String description) {
    this.description = description;
    return this;
  }

  public String getState() {
    return state;
  }

  public Issue withState(String state) {
    this.state = state;
    return this;
  }

  @Override
  public String toString() {
    return "Issue{" +
            "id=" + id +
            ", subject='" + subject + '\'' +
            ", description='" + description + '\'' +
            ", state='" + state + '\'' +
            ", state_name='" + state_name + '\'' +
            '}';
  }
}