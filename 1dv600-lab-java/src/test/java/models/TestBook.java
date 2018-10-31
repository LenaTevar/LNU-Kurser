/**
*<h1>TestBook</h1>
*Junit test for the class book.
*/
package models;

import lnu.models.book;

import org.junit.*;

import com.fasterxml.jackson.databind.ObjectMapper;

import static org.junit.Assert.assertEquals;
import static io.dropwizard.testing.FixtureHelpers.*;
import static org.assertj.core.api.Assertions.assertThat;

public class TestBook{

  private book dummyBook;
  private String id = "99";
  private String title = "testTitle";
  private String author = "testAuthor";
  private String genre = "testGenre";
  private String publishDate = "testDate";
  private String description = "testingDescription";
  private String price = "testPrice";

  private String bookToString = "ID: " + id + " - Author: " + author + " - Title: " + title +
                " - Genre: " + genre + " - Price: " + price +
                " - Publish Date: " + publishDate + " - Description: " + description;

  @Before
  public void setBook(){
    dummyBook = new book();
  }


/*----------TESTING----------*/
//Use selfdescriptive methods (Clean Code R.C.Martin)
  @Test
  public void shouldSetAndGetID(){
    dummyBook.setId(id);
    assertEquals(dummyBook.getId(), id);
  }

  @Test
  public void ShouldSetAndGetTitle(){
    dummyBook.setTitle(title);
    assertEquals(dummyBook.getTitle(), title);
  }

  @Test
  public void ShouldSetAndGetAuthor(){
    dummyBook.setAuthor(author);
    assertEquals(dummyBook.getAuthor(), author);
  }

  @Test
  public void ShouldSetAndGetGenre(){
    dummyBook.setGenre(genre);
    assertEquals(dummyBook.getGenre(), genre);
  }

  @Test
  public void ShouldSetAndGetPublishDate(){
    dummyBook.setPublish_date(publishDate);
    assertEquals(dummyBook.getPublish_date(), publishDate);
  }

  @Test
  public void ShouldSetAndGetDescription(){
    dummyBook.setDescription(description);
    assertEquals(dummyBook.getDescription(), description);
  }

  @Test
  public void ShouldSetAndGetPrice(){
    dummyBook.setPrice(price);
    assertEquals(dummyBook.getPrice(), price);
  }

  @Test
  public void shouldReturnString(){
    dummyBook.setId(id);
    dummyBook.setTitle(title);
    dummyBook.setAuthor(author);
    dummyBook.setGenre(genre);
    dummyBook.setPublish_date(publishDate);
    dummyBook.setDescription(description);
    dummyBook.setPrice(price);
    assertEquals(dummyBook.toString(), bookToString);
  }

}
