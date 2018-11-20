package ua.av.addressbook.tests;

import org.testng.annotations.Test;
import ua.av.addressbook.model.ContactData;
import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

public class ContactDataTest extends TestBase {

  @Test
  public void testContactDataComparison() {
    app.goTo( ).ContactPage( );
    ContactData contact = app.contact( ).all( ).iterator( ).next( );
    ContactData contactInfoFromEditForm = app.contact( ).infoFromEditForm( contact );

    assertThat( contact.getAllPhones( ), equalTo(mergePhones(contactInfoFromEditForm)));
    assertThat( contact.getAddress(), equalTo( contactInfoFromEditForm.getAddress()) );
    assertThat( contact.getAllEmails(), equalTo( mergeEmails(contactInfoFromEditForm)));
  }

  private String mergePhones(ContactData contact) {
    return Arrays.asList( contact.getPhoneHome(), contact.getPhoneMobile(), contact.getPhoneWork())
            .stream().filter( (s) -> ! s.equals( "" ))
            .map( ContactDataTest::cleaned )
            .collect( Collectors.joining( "\n") );
  }

  public static String cleaned(String phone) {
    return phone.replaceAll("\\s", "" ).replaceAll( "[-()]", "" );
  }

  private String mergeEmails(ContactData contact) {
    return Arrays.asList( contact.getEmailAddress(), contact.getEmailAddress2(), contact.getEmailAddress3())
            .stream().filter( (s) -> ! s.equals( "" ))
            .collect( Collectors.joining("\n") );
  }

}
