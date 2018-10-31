package ht222fd_assign2.Ex6;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 */
public class MainFxAll extends Application {
    Stage window;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;
        window.setTitle("JavaFX Exercises");

        //Label and buttons to go to the exercises
        Label lbl1 = new Label("Choose one exercise");
        Button btn1 = new Button("One Two Three");
        Button btn2 = new Button("Random Panel");
        Button btn3 = new Button("Display Color");


        //Action Button Random
        btn2.setOnAction(event -> RadomPanel.display());

        btn1.setOnAction(event -> OneTwoThree.display());

        btn3.setOnAction(event -> ColorDisplay.display());



        //Buttons inside a HBox
        HBox boxBtn = new HBox();
        boxBtn.getChildren().addAll(btn1,btn2, btn3);
        boxBtn.setSpacing(30);
        //Hbox inside a VBox with the label
        VBox layout = new VBox();
        layout.getChildren().addAll(lbl1,boxBtn);
        layout.setPadding(new Insets(50,50,50,50));
        layout.setSpacing(30);


        //Scene and window
        Scene mainSc = new Scene(layout, 450, 200);

        window.setScene(mainSc);

        window.show();
    }
}
