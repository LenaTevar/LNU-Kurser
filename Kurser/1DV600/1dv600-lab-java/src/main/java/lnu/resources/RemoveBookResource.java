/**
* <h1>RemoveBookResource Class</h1>
* Class that manages deleting a book from the front-end.
* @version 2.0
*/
package lnu.resources;

import javax.ws.rs.Produces;
import javax.ws.rs.Path;
import javax.ws.rs.DELETE;
import javax.ws.rs.PathParam;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.MediaType;

import java.io.IOException;

import lnu.models.catalog;
import lnu.dao.booksDAO;



@Produces(MediaType.APPLICATION_JSON)

@Path("/books")
public class RemoveBookResource {
  private booksDAO removeDAO;

  //------CONSTRUCTORS------
  public RemoveBookResource(){
    removeDAO = new booksDAO();
  }

  public RemoveBookResource(booksDAO testing){
    removeDAO = testing;
  }
  //------METHODS------
  /**
  *<h1>deleteBook</h1>
  * The deleteBook method will search for a book with a determined id and delete it.
  *@param id String id to search a book and delete it.
  *@return response 200 if the method succed, response 404 if the method fails.
  */
  @DELETE
  @Path("{book_id}")
  public Response deleteBook(@PathParam("book_id") String id) throws Exception{
    try{
      catalog removeCatalog = removeDAO.booksFromXML();
      removeCatalog.deleteBook(id);
      removeDAO.rewrite(removeCatalog);
      return Response.ok().build();
    }catch(IOException e){
      return Response.status(Response.Status.NOT_FOUND).build();
    }
  }
}
