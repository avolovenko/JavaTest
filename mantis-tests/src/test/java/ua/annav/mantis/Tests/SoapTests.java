package ua.annav.mantis.Tests;

import org.testng.annotations.Test;
import ua.annav.mantis.model.Issue;
import ua.annav.mantis.model.Project;

import javax.xml.rpc.ServiceException;
import java.net.MalformedURLException;
import java.rmi.RemoteException;
import java.util.Set;

import static org.testng.Assert.assertEquals;

public class SoapTests extends TestBase {

  @Test (enabled = false)
  public void testGetProjects() throws MalformedURLException, ServiceException, RemoteException {
    Set<Project> projects = app.soap().getProjects();
    System.out.println(projects.size());
    for (Project project : projects) {
      System.out.println(project.getName());
    }
  }

  @Test (enabled = false)
  public void testCreateIssue() throws RemoteException, ServiceException, MalformedURLException {
    Set<Project> projects = app.soap().getProjects();
    Issue issue = new Issue().withSummary("Test issue")
            .withDescription("Test issue description").withProject(projects.iterator().next());
    Issue created = app.soap().addIssue(issue);
    assertEquals(issue.getSummary(), created.getSummary());
  }

  @Test
  public void testIssueStatus () {
    int issueId = 1;

    try {
      skipIfNotFixed(issueId);
      System.out.println("Do something");

    } catch (Exception e) {
      System.out.println("Exception: " + e.getMessage());
    }


  }
}