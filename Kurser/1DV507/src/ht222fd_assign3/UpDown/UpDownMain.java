package ht222fd_assign3.UpDown;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;


/*What would be super cool but I don't know if I can do it? A pop up asking the number of rows/columns and the
* size of the XWing*/
public class UpDownMain extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Up and Down");
        UpDownPane grid = new UpDownPane();

        int size = grid.getSize();

        Scene scene = new Scene(grid, size, size);
        scene.setOnKeyPressed(event -> grid.eventMoving(event));
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
