package ht222fd_assign3.histogram;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileNotFoundException;

/*I followed the same strategy that I did in Assignment 2.
A main stage that handle the input and when the event is called
then it calls a different stage (HistoDisplay).
* */

public class HistoMainFx extends Application {
    private HistoDisplay histoDisplayMain;
    @Override
    public void start(Stage primaryStage) throws Exception {


        primaryStage.setTitle("A title");
        Label text = new Label("Insert Path");
        TextField textF = new TextField();
        Button textB = new Button("Get Chart");

        HBox root = new HBox();
        root.setPadding(new Insets(20, 20, 20, 20));
        root.setSpacing(20);
        root.getChildren().addAll(text,textF, textB);


        textB.setOnAction(event -> {
            try {
                histoDisplayMain = new HistoDisplay();
                histoDisplayMain.display(textF.getText());
            }
            catch (FileNotFoundException e){
                Alert error = new Alert(Alert.AlertType.ERROR);
                error.setContentText(e.getMessage());
                error.showAndWait();
                e.printStackTrace();
            }
        });




        Scene scene = new Scene(root, 400, 150);
        primaryStage.setScene(scene);
        primaryStage.show();
    }



    public static void main(String[] args) {
        launch(args);

    }
}
