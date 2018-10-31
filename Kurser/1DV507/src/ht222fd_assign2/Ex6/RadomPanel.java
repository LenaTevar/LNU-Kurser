package ht222fd_assign2.Ex6;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.util.Random;

/**
 *
 */
public class RadomPanel extends BorderPane {
   public static void display(){
        Stage rdnStage = new Stage();

       //blocks events to other windows
       rdnStage.initModality(Modality.APPLICATION_MODAL);
       rdnStage.setTitle("Random Number");
       rdnStage.setMinWidth(300);

       Label rdnLbl = new Label("Click the button!");
       rdnLbl.setFont(new Font(20));
       Pane pane1 = new Pane();
       pane1.getChildren().add(rdnLbl);

       Button rdnBtn = new Button("Click");
       Pane pane2 = new Pane();
       pane2.getChildren().add(rdnBtn);
        rdnBtn.setOnAction(e ->
        {
            Random rn = new Random();
            int number = rn.nextInt(100)+1;
            rdnLbl.setText(Integer.toString(number));
        });

       //VBOX layout
       VBox layOut = new VBox();
       layOut.getChildren().addAll(pane1,pane2);
       layOut.setPadding(new Insets(50, 50, 50, 50));
       layOut.setSpacing(30);

       //Display
       Scene rndSc = new Scene(layOut, 450, 200);
       rdnStage.setScene(rndSc);
       rdnStage.showAndWait();

   }

}
