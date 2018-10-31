/**
* <h1>booksDAO Class</h1>
* The booksDAO class manages the XML document to read it
* and rewrite it.
* @version 2.0
*/
package lnu.dao;

import java.io.File;
import java.util.List;
import lnu.models.*;

import javax.xml.bind.annotation.*;

import javax.xml.bind.*;

public class booksDAO {

    private catalog DAOCatalog;
    private File file = new File ("books.xml");

    //------CONSTRUCTORS------
    public booksDAO(){ }

    public booksDAO(catalog catalog){
      DAOCatalog = catalog;
    }

    //------GETTERS AND SETTERS-------
    public catalog getDAOCatalog() {
        return DAOCatalog;
    }

    public void setDAOCatalog(catalog inputCatalog) {
        this.DAOCatalog = inputCatalog;
    }

    public void setFile(File file){
      this.file = file;
    }

    public File getFile (){
      return this.file;
    }
    //------METHODS------

    /**
    * @return XML document as a catalog.
    */
    public catalog booksFromXML() throws Exception{

          JAXBContext jaxbContext = JAXBContext.newInstance(catalog.class);
          Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
          this.DAOCatalog = (catalog) jaxbUnmarshaller.unmarshal(file);

          return DAOCatalog;
   }

   /**
   *<h2>Rewrite</h2>
   *Marshall a catalog into a file.
   * @param inputCatalog Modified catalog used to rewrite the XML
   *                     document.
   */
   public void rewrite(catalog inputCatalog) throws Exception{

         JAXBContext jaxbContext = JAXBContext.newInstance(catalog.class);
         Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
         jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
         jaxbMarshaller.marshal(inputCatalog, file);
     }


}
