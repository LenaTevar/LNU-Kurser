package lnu.models;
import javax.xml.bind.annotation.*;


@XmlRootElement(name = "book")
public class book {
  private String id;
  private String author;
  private String title;
  private String genre;
  private String price;
  private String publish_date;
  private String description;


  public book (){}
  public book (String id, String author, String title, String genre,
                    String price, String publish_date, String description){
                      this.id = id;
                      this.author = author;
                      this.title = title;
                      this.genre = genre;
                      this.price = price;
                      this.publish_date = publish_date;
                      this.description = description;


                    }

  public String toString(){
    String temp = "ID: " + id + " - Author: " + author + " - Title: " + title +
                  " - Genre: " + genre + " - Price: " + price +
                  " - Publish Date: " + publish_date + " - Description: " + description;
    return temp;
  }

//------GETTERS AND SETTERS------
  @XmlAttribute
  public String getId(){
    return id;
  }
  public void setId(String id) {
        this.id = id;
    }

  public String getAuthor(){
      return author;
    }
  public void setAuthor(String author){
      this.author = author;
    }

  public String getTitle(){
    return title;
  }
  public void setTitle(String title){
    this.title = title;
  }

  public String getGenre(){
    return genre;
  }
  public void setGenre(String genre){
    this.genre = genre;
  }

  public String getPrice(){
    return price;
  }
  public void setPrice(String price){
    this.price = price;
  }

  public String getPublish_date(){
    return publish_date;
  }
  public void setPublish_date(String publish_date){
    this.publish_date = publish_date;
  }

  public String getDescription(){
    return description;
  }
  public void setDescription(String description){
    this.description = description;
  }


}
