// Use this file to write and read the xml file.
// http://www.journaldev.com/1234/jaxb-tutorial-example-to-convert-object-to-xml-and-xml-to-object
// javax.xml.bind is added as a part of the sdk from java7 and forward.
/*Date: summer 2017 - Refactoring*/

package lnu.dao;

import lnu.models.*;

import java.util.List;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class booksDAO{
  public List<book> books; // needed? 27 jun
  public catalog catalogDAO; //needed? 27 jun
  private File FILE = new File ("/books.xml");

/*---CONSTRUCTOR---*/
public booksDAO (){}

//testing
public booksDAO(File file){
  this.FILE = file;
}


/*---METHODS---*/

public catalog  readXML () throws Exception {
  /*
  Date: 27 jun
  Comment: Dear Lena from the past, what *** is this.
  I'm going to leave this here just to shame you.

  File file = new File(FILE_BOOKS);

  */

  JAXBContext jaxbContext = JAXBContext.newInstance(catalog.class);
	Unmarshaller jaxvUnmarshaller = jaxbContext.createUnmarshaller();
	return (catalog) jaxvUnmarshaller.unmarshal(FILE);
}

public void writeXML (catalog newCatalog) throws Exception {
  /*
  Date: 27 jun
  Comment: I can't even

  File file = new File("books.xml");
  */
  JAXBContext jaxbContext = JAXBContext.newInstance(catalog.class);
  Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
  jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);//Boolean.TRUE
  jaxbMarshaller.marshal(newCatalog, FILE);
  }

}
