package ua.annav.rest;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import org.apache.http.client.fluent.Executor;
import org.apache.http.client.fluent.Request;
import org.apache.http.message.BasicNameValuePair;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;
import java.util.Set;

import static org.testng.Assert.assertEquals;

public class RestTests extends TestBase {


  @Test
  public void testCreateIssue() throws IOException {
    Set<Issue> oldIssues = getIssue();
    Issue newIssue = new Issue().withSubject("Test Issue").withDescription("New test issue");
    int issueId = createIssue(newIssue);
    Set<Issue> newIssues = getIssue();
    oldIssues.add(newIssue.withId(issueId));
    assertEquals(newIssues,oldIssues);
/*
    for (Issue issue : oldIssues) {
      System.out.println(issue);
    }
*/
  }


  @Test
  public void testIssueStatus () {
    int issueId = 631;

    try {
      skipIfNotFixed(issueId);
      System.out.println("Do something");

    } catch (Exception e) {
      System.out.println("Exception: " + e.getMessage());
    }
  }

}
