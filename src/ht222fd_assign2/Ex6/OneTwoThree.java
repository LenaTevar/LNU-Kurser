package ht222fd_assign2.Ex6;


import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class OneTwoThree {
    public static void display(){
        Stage ottStage = new Stage();
        ottStage.setTitle("One Two Three");

        //ONE
        Pane canvas1 = new Pane();
        canvas1.setStyle("-fx-background-color: lightcoral");
        canvas1.setPrefSize(150,50);
        Label lbl1 = new Label("One");
        lbl1.setStyle("-fx-font-weight: bold");
        StackPane stck1 = new StackPane();
        stck1.getChildren().addAll(canvas1,lbl1);
        stck1.setAlignment(lbl1, Pos.CENTER_LEFT);

        //TWO
        Pane canvas2 = new Pane();
        canvas2.setStyle("-fx-background-color: lightskyblue");
        canvas2.setPrefSize(150,50);
        Label lbl2 = new Label("Two");
        lbl2.setStyle("-fx-font-weight: bold");
        StackPane stck2 = new StackPane();
        stck2.getChildren().addAll(canvas2,lbl2);
        stck2.setAlignment(lbl2, Pos.CENTER);

        //THREE
        Pane canvas3 = new Pane();
        canvas3.setStyle("-fx-background-color: mediumaquamarine");
        canvas3.setPrefSize(150,50);
        Label lbl3 = new Label("three");
        lbl3.setStyle("-fx-font-weight: bold");
        StackPane stck3 = new StackPane();
        stck3.getChildren().addAll(canvas3,lbl3);
        stck3.setAlignment(lbl3, Pos.CENTER_RIGHT);

        VBox layout = new VBox();
        layout.getChildren().addAll(stck1,stck2,stck3);

        //Display
        Scene ottSc = new Scene(layout, 450, 250);
        ottStage.setScene(ottSc);
        ottStage.showAndWait();


    }

}
