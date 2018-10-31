/**
* <h1>EditBookResource Class</h1>
* Class that manages modifying a book from the front-end.
* @version 2.0
*/

package lnu.resources;

import javax.ws.rs.Produces;
import javax.ws.rs.Path;
import javax.ws.rs.POST;
import javax.ws.rs.PathParam;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.MediaType;

import java.io.IOException;

import lnu.models.catalog;
import lnu.dao.booksDAO;

@Produces(MediaType.APPLICATION_JSON)
@Path("/books")
public class EditBookResource {
  private booksDAO editDAO;

  //------CONSTRUCTORS------
  public EditBookResource(){
    editDAO = new booksDAO();
  }
  public EditBookResource(booksDAO testing){
    this.editDAO = testing;
  }
  //------METHODS------

  /**
  *<h1>edit</h1>
  * The edit method will search for a book with a determined id and change the
  * book variables for new ones.
  *@param id String id will be compared with all the books inside the book List.
  *@param modifiedBook Object book to replace an old book.
  *@return response 200 if the method succed, response 404 if the method fails.
  */
  @POST
  @Path("{book_id}")
  public Response edit(@PathParam("book_id") String id, String modifiedBook) throws Exception{
    try{

      catalog editCatalog = editDAO.booksFromXML();
      editCatalog.setABook(id, modifiedBook);
      editDAO.rewrite(editCatalog);
      return Response.ok().build();

    }catch(IOException e){
      return Response.status(Response.Status.NOT_FOUND).build();
    }
  }
}
