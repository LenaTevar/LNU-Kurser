package ht222fd_assign2.Ex6;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 *
 */
public class ColorDisplay {
    public static void display(){

        Stage colorStg = new Stage();
        colorStg.initModality(Modality.APPLICATION_MODAL);
        colorStg.setTitle("Color Thing");


        //First Label and pane
        Rectangle canvas1 = new Rectangle(0,0,500,50);
        canvas1.setFill(Color.RED);

        Label lblCanvas1 = new Label("Color Display");
        lblCanvas1.setStyle("-fx-font-weight: bold");
        lblCanvas1.setStyle("-fx-stroke: white");
        lblCanvas1.setStyle("-fx-stroke-width: 2px");
        lblCanvas1.setFont(new Font(30));
        StackPane stack1 = new StackPane();
        stack1.getChildren().addAll(canvas1, lblCanvas1);
        stack1.setAlignment(canvas1, Pos.TOP_LEFT);

        //Stacking text fields with their labels
        TextField txt1 = new TextField();
        Label lbl1 = new Label("Red");
        lbl1.setFont(new Font(20));
        VBox group1 = new VBox();
        group1.getChildren().addAll(txt1,lbl1);

        TextField txt2 = new TextField();
        Label lbl2 = new Label("Green");
        lbl2.setFont(new Font(20));
        VBox group2 = new VBox();
        group2.getChildren().addAll(txt2,lbl2);

        TextField txt3 = new TextField();
        Label lbl3 = new Label("Blue");
        lbl3.setFont(new Font(20));
        VBox group3 = new VBox();
        group3.getChildren().addAll(txt3,lbl3);

        //packing the three groups in one hbox
        HBox Colorgroup = new HBox();
        Colorgroup.setPadding(new Insets(10,10,10,10));
        Colorgroup.setSpacing(10);
        Colorgroup.getChildren().addAll(group1,group2,group3);

        //Button and stuff
        Pane canvas2 = new Pane();
        canvas2.setPrefSize(150,50);
        Button btn = new Button("Display Color");
        Label error = new Label(" ");
        VBox btnNerror = new VBox();
        btnNerror.setAlignment(Pos.CENTER);
        btnNerror.getChildren().addAll(btn,error);
        StackPane buttonGroup = new StackPane();
        buttonGroup.getChildren().addAll(canvas2,btnNerror);

        //Button Event
        btn.setOnAction(event -> {

            try{
                int red = Integer.parseInt(txt1.getText());
                int green = Integer.parseInt(txt2.getText());
                int blue = Integer.parseInt(txt3.getText());

                if (!checkRGB(red) && !checkRGB(green) && !checkRGB(blue)) {
                    canvas1.setFill(Color.rgb(red,green,blue,.99));
                }
                else{
                    error.setText("RGB number = [0 - 255]");
                }
            }
            catch (NumberFormatException x){
                error.setText("Error: " + x );
            }
        });

        VBox layout = new VBox();
        layout.getChildren().addAll(stack1, Colorgroup, buttonGroup);


        //Display
        Scene colorSc = new Scene(layout,500,300);
        colorStg.setScene(colorSc);
        colorStg.showAndWait();


    }//display
    private static boolean checkRGB(int n){
        return (n < 0 || n > 255); //n = negative or bigger than 255 == true
    }

}//ColorDisplay
