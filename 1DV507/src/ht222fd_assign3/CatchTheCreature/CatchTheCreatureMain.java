package ht222fd_assign3.CatchTheCreature;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
/*-------------------READ ME-------------------*/
/*
* I couldn't find why it doesn't work for you!!!
* It works for me. I will add a small video showing
* what happens when I run this.
* */
public class CatchTheCreatureMain extends Application{
    private Label countLabel;
    private String text = "Times caught: ";

    public static void main(String[] args) { launch(args); }

    @Override
    public void start(Stage primaryStage) throws Exception {

        primaryStage.setTitle("Catch the X-Wing");

        /*Create the game*/
        CatchTheCreatureGame game = new CatchTheCreatureGame();

        /*Create the counter label*/
        countLabel = new Label(text + game.getCounter());
        countLabel.setMaxWidth(200);
        countLabel.setTextFill(Color.BLACK);


        BorderPane root = new BorderPane();
        root.setTop(countLabel);
        root.setCenter(game);
        /*Whenever you click the button, refresh the counter.
        * Because the counter is inside "game" it will answer how many times you caught the XWing.
        * */
        root.setOnMouseClicked(e -> countLabel.setText(text + game.getCounter()));

        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();

    }

}
