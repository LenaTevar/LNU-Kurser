package controllers;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import models.Catalogue;

/*
 * Class DAO
 * In charge of the data access object. 
 * Reads and saves two XML files. 
 * One for the catalogue of members and another for the events. 
 * */
public class DAO {
	File catalogueFile = new File("CatalogueDAO.xml");
	
	public DAO() {}


	/*DAO CATALOGUE*/
	public void saveCatalogue(Catalogue catalogue) throws Exception {
		JAXBContext catContext = JAXBContext.newInstance(Catalogue.class);
		Marshaller catMarshaller = catContext.createMarshaller();
		catMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		catMarshaller.marshal(catalogue, catalogueFile);
	}
	
	
	public Catalogue loadCatalogue() throws JAXBException   {
		JAXBContext catContext = JAXBContext.newInstance(Catalogue.class);
		Unmarshaller catunMarshaller = catContext.createUnmarshaller();
		return (Catalogue) catunMarshaller.unmarshal(catalogueFile);
	}

}


