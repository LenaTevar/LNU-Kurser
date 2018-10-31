package Helpers;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;


/**
 * Helper intro FX
 */
public class MyMainFx extends Application {
    Stage window;

    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) throws Exception {

        window = primaryStage;
        window.setTitle("TEMPLATE EXERCISES");

        GridPane grid = new GridPane();

        //Images, labels, textbox and stuff

        //OBS!! Change the path.
        Image tree = new Image("Helpers/assets/lnuTree.png");
        ImageView treeIV = new ImageView(tree);
        treeIV.setFitWidth(50);
        treeIV.setPreserveRatio(true);




        //GRID LAYOUT
        grid.setPadding(new Insets(5,5,5,5));
        grid.setVgap(10);
        grid.setHgap(10);

        grid.add(treeIV,0,0);


        //Scene and window
        Scene mainSc = new Scene(grid, 300, 200);
        window.setScene(mainSc);
        window.show();
    }
}

