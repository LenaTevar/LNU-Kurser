/**
*<h1>TestDAO</h1>
*This class manages the junit test for the DAO class.
*@see testXML.xml document that cointains one book, Momo by Michel Ende.
*<h2>Common Mistakes</h2>
<ul>
  <li>Json poorly wrintte
  <li>File poorly written
  <li>"written" poorly written
</ul>
*/
package dao;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;


import static io.dropwizard.testing.FixtureHelpers.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import static org.mockito.Mockito.*;

import lnu.dao.booksDAO;
import lnu.models.*;

import java.io.IOException;
import java.io.File;

public class TestDAO{
  private File file = new File ("src/test/java/testXML.xml");
  private booksDAO testDAO;
  private String momoJson = "[{\"id\":\"1\",\"author\":\"Ende\",\"title\":\"Momo\",\"genre\":\"Fantasy\",\"price\":\"999\",\"publish_date\":\"1973\",\"description\":\"Momo lives in an amphitheatre.\"}]";

  @Before
  public void setUpTest(){
    testDAO = new booksDAO();
    testDAO.setFile(file);
  }

  @Test
  public void shouldGetACatalogFromXML() throws Exception{
    catalog testCatalog = testDAO.booksFromXML();
    assertEquals(momoJson, testCatalog.toJson());
  }

  @Test
  public void shouldRewriteTheXML() throws Exception{
    catalog differentCatalog = this.setUpCatalog();

    testDAO.rewrite(differentCatalog);
    catalog testCatalog = testDAO.booksFromXML();
    assertEquals(differentCatalog.toJson(), testCatalog.toJson());
  }

  private catalog setUpCatalog() throws Exception{
    catalog temp = new catalog();
    temp.addBook(new book("1","Cline","Ready Player One","Science Fiction","200","2014","A story about how much millenials love the 80s"));
    return temp;
  }

  @After
  public void fixAfterTest() throws Exception{
    catalog temp = new catalog();
    temp.addBook(new book ("1", "Ende", "Momo", "Fantasy", "999", "1973", "Momo lives in an amphitheatre."));
    testDAO.rewrite(temp);

  }

}
/*
<?xml version="1.0"?>
<catalog>
    <book id="1">
      <author>Ende</author>
      <title>Momo</title>
      <genre>Fantasy</genre>
      <price>100</price>
      <publish_date>1973</publish_date>
      <description>In the ruins of an amphitheatre just outside an unnamed city lives Momo, a little girl of mysterious origin.</description>
    </book>
</catalog>
*/
