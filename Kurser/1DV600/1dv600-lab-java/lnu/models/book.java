package lnu.models;
/*Date: summer 2017 - Refactoring*/

import javax.xml.bind.annotation.*;

@XmlRootElement(name = "book")
@XmlType(propOrder = {"author", "title", "genre", "price", "publishDate", "description"})
public class book{
  private String id;
  private String title;
  private String author;
  private String genre;
  private String publishDate;
  private String description;
  private String price;

  /*---CONSTRUCTOR---*/
  public book (){
    id = "";
    title = "";
    author = "";
    genre = "";
    publishDate = "";
    description = "";
    price = "";
  }

  public book (String id, String title, String author, String genre, String publishDate,
    String description, String price){
      this.id = id;
      this.title = title;
      this.author = author;
      this.genre = genre;
      this.publishDate = publishDate;
      this.description = description;
      this.price = price;
    }

/*---GETTERS N SETTERS---*/
@XmlAttribute
public String getId(){
  return id;
}
public void setId(String id){
  this.id = id;
}

public String getTitle(){
  return title;
}
public void setTitle(String title){
  this.title = title;
}

public String getAuthor(){
  return author;
}
public void setAuthor(String author){
  this.author = author;
}

public String getGenre(){
  return genre;
}
public void setGenre(String genre){
  this.genre = genre;
}

public String getPublishDate(){
  return publishDate;
}
public void setPublishDate(String publishDate){
  this.publishDate = publishDate;
}

public String getDescription(){
  return description;
}
public void setDescription(String description){
  this.description = description;
}

public String getPrice(){
  return price;
}
public void setPrice(String price){
  this.price = price;
}

@Override
public String toString(){
  return "Book: " + title + " - Author: " + author + " - ID: " + id + " - Publish Date: " + publishDate + " - Genre: " + genre + " - Description: " + description;
}



}//end class book
