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
import lnu.resources.EditBookResource;

import java.io.IOException;
import java.io.File;


public class testEditBookResource {


    private static booksDAO mockedDAO = mock(booksDAO.class);
    private catalog mockedCatalog = mock(catalog.class);
    private static EditBookResource testingResource = new EditBookResource(mockedDAO);

  /*
  Check the web page above to understand more about dropwizard and resource testing.
  */
    @ClassRule
    public static final ResourceTestRule resources = ResourceTestRule.builder().addResource(testingResource).build();
    /*
    Remember you need book + id. USE POST NOT PUT OR WILL GET 405
    */
    @Test
    public void shouldModifyABook()throws Exception{
      String id = "1";
      String bookJson = "{\"id\":\"1\",\"author\":\"Ende\",\"title\":\"Momo\",\"genre\":\"Fantasy\",\"price\":\"999\",\"publish_date\":\"1973\",\"description\":\"Momo lives in an amphitheatre.\"}";
      when(mockedDAO.booksFromXML()).thenReturn(mockedCatalog);
      doNothing().when(mockedCatalog).setABook("1", bookJson);
      doNothing().when(mockedDAO).rewrite(mockedCatalog);

      assertThat(resources.client().target("/books/" + id).request()
                .post(Entity.entity(bookJson, MediaType.APPLICATION_JSON))
                .getStatus()).isEqualTo(200);
    }

    @Test
    public void shouldThrowError() throws Exception{
      String id = "1";
      String bookJson = "{\"id\":\"1\",\"author\":\"Ende\",\"title\":\"Momo\",\"genre\":\"Fantasy\",\"price\":\"999\",\"publish_date\":\"1973\",\"description\":\"Momo lives in an amphitheatre.\"}";
      when(mockedDAO.booksFromXML()).thenReturn(mockedCatalog);
      doThrow(new IOException()).when(mockedCatalog).setABook("1", bookJson);

      assertThat(resources.client().target("/books/" + id).request()
                .post(Entity.entity(bookJson, MediaType.APPLICATION_JSON))
                .getStatus()).isEqualTo(404);
    }



}
