/**
*<h1>test AddBooksResource</h1>
*This class manages the junit test for the AddBooksResource class.
*@see http://www.dropwizard.io/0.9.0/docs/manual/testing.html
*/


package API;

import org.junit.Test;
import org.junit.Before;
import org.junit.ClassRule;


import static io.dropwizard.testing.FixtureHelpers.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import static org.mockito.Mockito.*;

import io.dropwizard.testing.junit.ResourceTestRule;

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;

import lnu.dao.booksDAO;
import lnu.models.*;
import lnu.resources.AddBookResource;

import java.io.IOException;
import java.io.File;


public class testAddBookResource {

  private static booksDAO mockedDAO = mock(booksDAO.class);
  private catalog mockedCatalog = mock(catalog.class);
  private static AddBookResource testingResource = new AddBookResource(mockedDAO);

/*
Check the web page above to understand more about dropwizard and resource testing.
*/
  @ClassRule
  public static final ResourceTestRule resources = ResourceTestRule.builder().addResource(testingResource).build();

  @Test
  public void shouldAddABook()throws Exception{
    String bookToAdd = "{\"id\":\"1\",\"author\":\"Ende\",\"title\":\"Momo\",\"genre\":\"Fantasy\",\"price\":\"999\",\"publish_date\":\"1973\",\"description\":\"Momo lives in an amphitheatre.\"}";

    /*
    We have the DAO and catalog mocked, so stunt everything!
    */
    when(mockedDAO.booksFromXML()).thenReturn(mockedCatalog);
    doNothing().when(mockedCatalog).addBook(bookToAdd);
    doNothing().when(mockedDAO).rewrite(mockedCatalog);

    /*
    Now we test the response as the web page says.
    */

    assertThat(resources.client().target("/books").request()
              .put(Entity.entity(bookToAdd, MediaType.APPLICATION_JSON))
              .getStatus()).isEqualTo(200);
  }

  @Test
  public void shouldThrowError()throws Exception{
    String bookToAdd = "{\"id\":\"1\",\"author\":\"Ende\",\"title\":\"Momo\",\"genre\":\"Fantasy\",\"price\":\"999\",\"publish_date\":\"1973\",\"description\":\"Momo lives in an amphitheatre.\"}";
    when(mockedDAO.booksFromXML()).thenReturn(mockedCatalog);
    doThrow(new IOException()).when(mockedCatalog).addBook(bookToAdd);

    assertThat(resources.client().target("/books").request()
                .put(Entity.entity(bookToAdd, MediaType.APPLICATION_JSON))
                .getStatus()).isEqualTo(404);
  }
/*
Rinse and repeat with all resources.
*/
}
