package lnu.models;

import java.io.IOException;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import java.io.*;

import lnu.dao.booksDAO;
/*Refactoring summer 2017:
Comment: Why not using the catalog to handle with writing,
deleting, etc... It may take a lot of work, but you already
know how to use xml and you have time to do it. */

@XmlRootElement(name = "catalog")
@XmlAccessorType(XmlAccessType.FIELD)
public class catalog {

  @XmlElement(name = "book")
  private List<book> booksList;
  private booksDAO catalogDAO;
  private ObjectMapper catalogMapper;




  /*---CONSTRUCTOR---*/
  public catalog(){
    catalogDAO = new booksDAO();
  }

    /*---GETTERS AND SETTERS---*/

    /*---METHODS---*/
    //Used in GetBooksResource
    public String getBooksJsonString() throws Exception{
      catalogMapper = new ObjectMapper();
      String JsonInString = "";

      try{
        JsonInString += catalogMapper.writeValueAsString(catalogDAO.readXML());
      }catch (JsonGenerationException e) {
					e.printStackTrace();
					System.out.println(e.getMessage());
				} catch (JsonMappingException e) {
					e.printStackTrace();
					System.out.println(e.getMessage());
				} catch (IOException e) {
					e.printStackTrace();
					System.out.println(e.getMessage());
				}

      return "";
    }

    public void addBook(){}
    public void deleteBook(){}
    public void modifyBook(){}

}
