/**
* <h1>catalog Class</h1>
* The catalog class manages the List of books
* and the use cases of the project.
* @version 2.0
*/
package lnu.models;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.annotate.JsonView;
import org.codehaus.jackson.map.DeserializationConfig;

import javax.xml.bind.annotation.*;

import java.io.IOException;
import javax.ws.rs.NotFoundException;

import java.util.List;
import java.util.ArrayList;

import lnu.models.book;
import lnu.dao.booksDAO;

@XmlRootElement(name = "catalog")
public class catalog {

  @XmlElement(name = "book")
  private List<book> booksList;
  //Mapper static to be referenced without an instance of this class.
  private static ObjectMapper myMapper;

  //------CONSTRUCTORS------
  public catalog(){
    booksList = new ArrayList<book>();
    myMapper = new ObjectMapper();
  }

  public catalog(List<book> list){
    this.booksList = list;
    catalog.myMapper = new ObjectMapper();
  }
  //------GETTERS-SETTERS------
  public List<book> getBooks() {
    return booksList;
  }

  public void setBooks(List<book> books) {
    this.booksList = books;
  }
  //------METHODS------
  /**
  *<h1>toJson</h1>
  *The toJson method translates a complete List of books
  *into a json string.
  *@return Json String
  */
  public String toJson() throws IOException{
    String jsonString = "";
    myMapper = new ObjectMapper();
    jsonString += myMapper.writeValueAsString(booksList);
    return jsonString;
  }

/**
*<h1>getABook</h1>
* The getABook method will search for a book with a determined id.
*@param id String id will be compared with all the books inside the book List.
*@return book
*/
public book getABook(String id) throws NotFoundException{

    for (int i = 0; i <booksList.size(); i++ ) {
       book temp = booksList.get(i);
      if (temp.getId().equals(id)){
        return  temp;
      }
    }
    throw new NotFoundException();
}

/**
*<h1>setABook</h1>
* This method searches for a book inside a List and replaces that book
* for a new one.
*@param id String id that will be compared with all the books inside the book list.
*@param bookIn Json string. It will be converted in Object book and used to modify
*             the found book.
*/
public void setABook(String id, String bookIn)throws IOException{

  book updatedBook = this.stringToBook(bookIn);

    for (int i = 0; i < booksList.size(); i++ ) {
      if (booksList.get(i).getId().equals(id)){
        replaceBook(booksList.get(i), updatedBook);
      }

    }
}

/**
*<h1>addBook<h/1>
*This method adds a book to the list, with a defined id.
*<p>If the bookList is empty, it will give the id 1 to the book</p>
*<p>If the book already exist, it will return. </p>
*<p>If the List is not empty and the book doesn't exist, it will add the next id
* to the added book.</p>
*<p>TO DO: Make another method to fix the if elses</p>
*@param String StringBook JSON strin used to add a book.
*<h2>Overload</h2>
*@param book Used for testing purposes.
*/
public void addBook(String stringBook) throws IOException{

  book temp = this.stringToBook(stringBook);

  if (booksList.isEmpty()){
    temp.setId("1");
    booksList.add(temp);
  }
  else if(this.bookExist(temp)){
    return;
  }
  else{
    String lastID = booksList.get(booksList.size()-1).getId();
    Integer lastIDInt = Integer.parseInt(lastID) + 1;
    temp.setId(Integer.toString(lastIDInt));
    booksList.add(temp);
  }

}

public void addBook(book bookIn) throws IOException{
  if (booksList.isEmpty()){
    bookIn.setId("1");
    booksList.add(bookIn);
  }
  else if(this.bookExist(bookIn)){
    return;
  }
  else{
    String lastID = booksList.get(booksList.size()-1).getId();
    Integer lastIDInt = Integer.parseInt(lastID) + 1;
    bookIn.setId(Integer.toString(lastIDInt));
    booksList.add(bookIn);
  }
}

/**
*<h1>deleteBook</h1>
*This method deletes a book from the list, with a defined id.
*@param String id string that defines the id of the book to be erased.
*/
public void deleteBook(String id) throws IOException{
  for (int i = 0; i < booksList.size(); i++ ) {
    if (booksList.get(i).getId().equals(id))
      booksList.remove(i);
  }
}

/**
*<h1>toString</h1>
*@return String of books
*/
@Override
public String toString(){
  String temp = "LIST OF BOOKS: ";
  for (book books : booksList ) {
    temp += "/n" + books.toString();
  }
  return temp;
}

/**
*<h1>stringToBook</h1>
*Helper method to create an Object Book from a Json string.
*@param stringIn Json string to be converted in a Book.
*/
  private book stringToBook(String stringIn) throws IOException{
    return catalog.myMapper.readValue(stringIn, book.class);
  }

/**
*<h1>bookExist</h1>
*Helper method to determine if a book with a title already exists in the list.
*@param bookToAdd Book we want to add but we want to check if it exist in the list.
*/
  private boolean bookExist(book bookToAdd){
    for (int i = 0; i < booksList.size(); i++ ){
      book temp = booksList.get(i);
      if(temp.getTitle().equals(bookToAdd.getTitle())){
        return true;
      }
    }
    return false;
  }
/**
*<h1>replaceBook</h1>
*Helper method to replace all the variables of a book.
*Following the book "Clean Code": If your "if" has more than one line, make a method.
*/
  private void replaceBook(book oldbook, book newBook){

    oldbook.setAuthor(newBook.getAuthor());
    oldbook.setTitle(newBook.getTitle());
    oldbook.setGenre(newBook.getGenre());
    oldbook.setPrice(newBook.getPrice());
    oldbook.setPublish_date(newBook.getPublish_date());
    oldbook.setDescription(newBook.getDescription());
  }

}
