package ua.av.addressbook.tests;

import org.testng.annotations.Test;
import ua.av.addressbook.model.ContactData;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

public class ContactPhoneTest extends TestBase {

  @Test
  public void testContactPhone() {
    app.goTo( ).ContactPage( );
    ContactData contact = app.contact( ).all( ).iterator( ).next( );
    ContactData contactInfoFromEditForm = app.contact( ).infoFromEditForm( contact );

    assertThat( contact.getAllPhones( ), equalTo(mergePhones(contactInfoFromEditForm)));
    /*assertThat( contact.getPhoneMobile( ), equalTo( cleaned( contactInfoFromEditForm.getPhoneMobile( ) ) ) );
    assertThat( contact.getPhoneWork( ), equalTo( cleaned( contactInfoFromEditForm.getPhoneWork( ) ) ) );*/
  }

  private String mergePhones(ContactData contact) {
    return Arrays.asList( contact.getPhoneHome(), contact.getPhoneMobile(), contact.getPhoneWork())
            .stream().filter( (s) -> ! s.equals( "" ))
            .map( ContactPhoneTest::cleaned )
            .collect( Collectors.joining( "\n") );
  }

  public static String cleaned(String phone) {
    return phone.replaceAll("\\s", "" ).replaceAll( "[-()]", "" );
  }

}
