/**
*<h1>TestCatalog</h1>
*Junit test for class Catalog
*/
import org.junit.Test;
import org.junit.Before;
import org.mockito.Mockito;

//friend said to avoid wildcards... but I'm new in this that I don't know exactly...
import static org.hamcrest.CoreMatchers.*;
import static io.dropwizard.testing.FixtureHelpers.*;
import static org.assertj.core.api.Assertions.*;
import static org.junit.Assert.*;

import static org.mockito.Mockito.*;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.annotate.JsonView;
import org.codehaus.jackson.map.DeserializationConfig;

import lnu.models.*;
import lnu.dao.booksDAO;

import java.util.List;
import java.util.ArrayList;

import java.io.IOException;

public class TestCatalog{
  private catalog testCatalog;
  private List<book> listMocked;
  //OBS! JsonToString [{}] vs. Json {}
  private book testbook = new book("1", "authorTest", "titleTest", "genreTest", "100", "publish_dateTest", "descriptionTest");
  private String testBookJsonObj = "{\"id\":\"1\",\"author\":\"authorTest\",\"title\":\"titleTest\",\"genre\":\"genreTest\",\"price\":\"100\",\"publish_date\":\"publish_dateTest\",\"description\":\"descriptionTest\"}";
  private String testBookString = "[{\"id\":\"1\",\"author\":\"authorTest\",\"title\":\"titleTest\",\"genre\":\"genreTest\",\"price\":\"100\",\"publish_date\":\"publish_dateTest\",\"description\":\"descriptionTest\"}]";

  private book momoBook = new book("1", "Ende", "Momo", "Fantasy", "999", "1973", "Momo lives in an amphitheatre.");
  private String momoJson = "{\"id\":\"1\",\"author\":\"Ende\",\"title\":\"Momo\",\"genre\":\"Fantasy\",\"price\":\"999\",\"publish_date\":\"1973\",\"description\":\"Momo lives in an amphitheatre.\"}";

  private book bookMocked = mock(book.class);
  @Test
  public void shouldGetAndSetList(){
    testCatalog = mock(catalog.class);
    listMocked = mock(ArrayList.class);
    testCatalog.setBooks(listMocked);

    when(testCatalog.getBooks()).thenReturn(listMocked);

    assertEquals(listMocked, testCatalog.getBooks());
  }

  @Test
  public void shouldReturnAJsonString() throws IOException{
    testCatalog = new catalog(this.setUpSingleList());

    assertEquals(testBookString, testCatalog.toJson());
  }

  @Test
  public void shouldReturnABook(){
    listMocked = mock(ArrayList.class);
    testCatalog = new catalog(listMocked);

    when(listMocked.size()).thenReturn(1);
    when(listMocked.get(anyInt())).thenReturn(bookMocked);
    when(bookMocked.getId()).thenReturn("1");

    assertEquals(bookMocked, testCatalog.getABook("1"));
  }

  @Test
  public void shouldSetABook()throws IOException{
    testCatalog = new catalog(this.setUpSingleList());

    testCatalog.setABook("1", momoJson);
    String temp = testCatalog.getABook("1").toString();
    assertEquals(momoBook.toString(), temp);
  }
  // Error: can not deserialize instance out of START_ARRAY token means that the Json string is wrong!!!
  @Test
  public void shouldAddABook()throws IOException{
    testCatalog = new catalog(this.setUpSingleList());
    testCatalog.addBook(momoJson);

    assertThat(testCatalog.getBooks().size(), is(2));
  }

  @Test
  public void shouldntAddABookThatAlreadyExist()throws IOException{
    testCatalog = new catalog (this.setUpSingleList());
    testCatalog.addBook(testbook);
    assertThat(testCatalog.getBooks().size(), is(1));
  }

  @Test
  public void shouldAddFirstBookChangeID()throws IOException{
    testCatalog = new catalog();

    String bookIdWrong = "{\"id\":\"99\",\"title\":\"Meme\",\"author\":\"Authortest\",\"genre\":\"Genretest\",\"publish_date\":\"2017-04-10\",\"description\":\"Descriptiontest\",\"price\":\"123\"}";
    testCatalog.addBook(bookIdWrong);
    book temp = testCatalog.getABook("1");
    assertEquals(temp.getId(), "1"); //?????? what I'm doing....
  }

  @Test
  public void shouldDeleteABook()throws IOException{
    testCatalog = new catalog(this.setUpSingleList());
    testCatalog.deleteBook("1");
    assertThat(testCatalog.getBooks().size(), is(0));
  }

  private List<book> setUpSingleList(){
    List<book> singleList = new ArrayList();
    singleList.add(testbook);
    return singleList;
  }

}
