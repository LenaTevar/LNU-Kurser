/**
* <h1>AddBooksResource Class</h1>
* Class that manages adding a book from the front-end
* @version 2.0
*/
package lnu.resources;

import lnu.models.catalog;
import lnu.dao.booksDAO;

import java.util.List;
import java.io.IOException;

import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Consumes;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;




@Consumes(MediaType.APPLICATION_JSON)
@Path("/books")
public class AddBookResource {
  private booksDAO addDAO;


  //------CONSTRUCTORS------
  public AddBookResource(){
    addDAO = new booksDAO();
  }

  public AddBookResource(booksDAO testDAO){
    this.addDAO = testDAO;
  }
  //------METHODS------

  /**
  *<h1>Add</h1>
  * The getABook method will search for a book with a determined id.
  *@param id String id will be compared with all the books inside the book List.
  *@return response 200 if the method succed, response 404 if the method fails.
  */
  @PUT
  @Consumes(MediaType.APPLICATION_JSON)
  public Response add(String input) throws Exception{
    try{

      catalog addcatalog = addDAO.booksFromXML();
      addcatalog.addBook(input);
      addDAO.rewrite(addcatalog);
      return Response.ok().build();

    }catch(IOException e){
      return Response.status(Response.Status.NOT_FOUND).build();
    }
  }

}
