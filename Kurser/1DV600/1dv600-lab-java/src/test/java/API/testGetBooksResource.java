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
import lnu.resources.GetBooksResource;

import java.io.IOException;
import java.io.File;

public class testGetBooksResource{

    private static booksDAO mockedDAO = mock(booksDAO.class);
    private catalog mockedCatalog = mock(catalog.class);
    private static GetBooksResource testingResource = new GetBooksResource(mockedDAO);

  /*
  Check the web page above to understand more about dropwizard and resource testing.
  */
    @ClassRule
    public static final ResourceTestRule resources = ResourceTestRule.builder().addResource(testingResource).build();

    @Test
    public void shouldShowBooks()throws Exception{
      String bookJson = "{\"id\":\"1\",\"author\":\"Ende\",\"title\":\"Momo\",\"genre\":\"Fantasy\",\"price\":\"999\",\"publish_date\":\"1973\",\"description\":\"Momo lives in an amphitheatre.\"}";

      /*
      We have the DAO and catalog mocked, so stunt everything!
      */
      when(mockedDAO.booksFromXML()).thenReturn(mockedCatalog);
      when(mockedCatalog.toJson()).thenReturn(bookJson);
      /*
      Now we test the response as the web page says.
      */
      assertEquals(bookJson, resources.client().target("/books").request()
                  .get(String.class));

    }

}
