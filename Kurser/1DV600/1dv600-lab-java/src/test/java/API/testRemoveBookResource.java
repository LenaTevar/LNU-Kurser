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
import lnu.resources.RemoveBookResource;

import java.io.IOException;
import java.io.File;


public class testRemoveBookResource{

      private static booksDAO mockedDAO = mock(booksDAO.class);
      private catalog mockedCatalog = mock(catalog.class);
      private static RemoveBookResource testingResource = new RemoveBookResource(mockedDAO);

    /*
    Check the web page above to understand more about dropwizard and resource testing.
    */
      @ClassRule
      public static final ResourceTestRule resources = ResourceTestRule.builder().addResource(testingResource).build();

      @Test
      public void shouldRemoveBook() throws Exception{
        String id = "1";
        when(mockedDAO.booksFromXML()).thenReturn(mockedCatalog);
        doNothing().when(mockedCatalog).deleteBook(id);
        doNothing().when(mockedDAO).rewrite(mockedCatalog);

        assertThat(resources.client().target("/books/" + id).request().delete()
                  .getStatus()).isEqualTo(200);
      }
      @Test
      public void shouldThrowError() throws Exception{
        String id = "1";
        when(mockedDAO.booksFromXML()).thenReturn(mockedCatalog);
        doThrow(new IOException()).when(mockedCatalog).deleteBook(id);

        assertThat(resources.client().target("/books/" + id).request().delete()
                  .getStatus()).isEqualTo(404);
      }
}
