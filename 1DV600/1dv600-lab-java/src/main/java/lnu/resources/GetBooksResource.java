/**
* <h1>GetBooksResource Class</h1>
* Class that manages the catalog showed in the web app
* and rewrite it.
* @version 2.0
*/
package lnu.resources;

import javax.ws.rs.GET;
import javax.ws.rs.PathParam;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import lnu.models.book;
import lnu.dao.booksDAO;
import lnu.models.catalog;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.JsonGenerationException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Produces(MediaType.APPLICATION_JSON)

@Path("/books")
public class GetBooksResource{
  private booksDAO getBooksDAO;
  private catalog getBooksCatalog;

  //------CONSTRUCTORS------
  public GetBooksResource(){
    getBooksDAO = new booksDAO();
  }

  public GetBooksResource(booksDAO testingResource){
    this.getBooksDAO = testingResource;
  }
  //------METHODS------
  /**
  *<h1>getBooks</h1>
  *It will answer a Json string to the API that will show a list of books to
  *the user.
  */
  @GET
  public String getBooks() throws Exception{

    getBooksCatalog = getBooksDAO.booksFromXML();
    
    return getBooksCatalog.toJson();
  }
}
