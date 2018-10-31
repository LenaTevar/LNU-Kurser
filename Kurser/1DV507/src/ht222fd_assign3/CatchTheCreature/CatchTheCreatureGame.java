package ht222fd_assign3.CatchTheCreature;

import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.util.Random;
/*Using the same grid as Up and Down. Catch the X-Wing!
* */
public class CatchTheCreatureGame extends GridPane{

    /*Variables that determine the size of the grid.
    * */
    private int size = 7;
    private int recSize = 100;
    private int counter = 0;

    /*Player:*/
    private Random rnd = new Random();
    private int currentX = rnd.nextInt(size);
    private int currentY = rnd.nextInt(size);
    private Image img = new Image("ht222fd_assign3/UpDown/XW.png");
    private ImageView imgV = new ImageView(img);
    private Group group = new Group(imgV);


    public int getSize(){
        return size;
    }



    public CatchTheCreatureGame(){
        this.creator();
    }//end constructor

    public CatchTheCreatureGame creator(){
        this.setStyle("-fx-background-color: #4D7A97");
        this.setOnMouseClicked(e -> this.mouseHandler(e));

        for (int i = 0; i < size ; i++) {
            for (int j = 0; j < size; j++) {
                if (currentX == i && currentY == j){
                    this.add(group, i, j);
                }
                else {
                    Rectangle rec = new Rectangle();
                    rec.setWidth(recSize);
                    rec.setHeight(recSize);
                    rec.setFill(Color.TRANSPARENT);
                    this.add(rec, i, j);
                }
            }
        }
        return this;
    }


    /*Dear Lena from the future:
    * e.getX() gives you size in pixels inside the scene when we want
    * rows and columns, so you only need to divide the
    * pixels / size of the recSize and it will give you
    * the row and the column.
    * */

    public void mouseHandler (MouseEvent e){
        int x = (int) e.getX()/recSize;
        int y = (int) e.getY()/recSize;

        if (currentX == x && currentY == y){

            currentY = rnd.nextInt(size);
            currentX = rnd.nextInt(size);
            counter++;
        }
        this.getChildren().removeAll(this.getChildren());
        creator();

    }//end handleInput

    public int getCounter(){
        return counter;
    }

}
