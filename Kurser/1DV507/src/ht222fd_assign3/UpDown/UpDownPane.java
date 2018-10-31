package ht222fd_assign3.UpDown;

import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;

import java.util.Random;


public class UpDownPane extends GridPane {

    /*Variables that determine the size of the grid.
    * */
    private int size = 10; //number of rows/columns
    private int recSize = 50; //size of xWing

    /*Player:*/

    private int currentX = size/2;
    private int currentY = size/2;
    private Image img = new Image("ht222fd_assign3/UpDown/XW.png", recSize, recSize, false, false);
    private ImageView imgV = new ImageView(img);

    private Group group = new Group(imgV);


    public int getSize(){
        return recSize*size;
    }



    public UpDownPane(){
        this.creator();
    }//end constructor

    public UpDownPane creator(){
        this.setStyle("-fx-background-color: #4D7A97");
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



    public void eventMoving (KeyEvent event){
        if (event.getCode().equals(KeyCode.RIGHT)){
            currentX+=1;
            currentX = checkCurrent(currentX);
        }
        else if (event.getCode().equals(KeyCode.LEFT)){
            currentX -= 1;
            currentX = checkCurrent(currentX);
        }
        /*Dear Lena from the future: If you add to Y, you actually go DOWN
        * NOT UP
        * */
        else if (event.getCode().equals(KeyCode.UP)){
            currentY -= 1;
            currentY = checkCurrent(currentY);
        }
        else if (event.getCode().equals(KeyCode.DOWN)){
            currentY += 1;
            currentY = checkCurrent(currentY);
        }

        this.getChildren().removeAll(this.getChildren());
        creator();

    }//end handleInput

    public int checkCurrent(int currentPosition){
        if (currentPosition < 0){
            return size-1;
        } else if (currentPosition == size) {
            return 0;
        }
        return currentPosition;
    }



}
