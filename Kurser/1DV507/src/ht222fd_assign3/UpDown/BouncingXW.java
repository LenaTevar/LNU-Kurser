package ht222fd_assign3.UpDown;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Bounds;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;

/*OBS!!!! THIS IS NOT A VG EXERCISE
* I copied and pasted this from stack overflow because I though it was funny
* but I don't have time to investigate how to make it work with my X-Wing. Well.. at least it was funny.
* Welp... I did it! hahahaha
* Stack Overflow -> http://stackoverflow.com/questions/20022889/how-to-make-the-ball-bounce-off-the-walls-in-javafx
* */

public class BouncingXW extends Application {

    public static Pane canvas;
    private Image img = new Image("ht222fd_assign3/UpDown/XW.png");
    private ImageView imgV = new ImageView(img);


    @Override
    public void start(final Stage primaryStage) {

        canvas = new Pane();
        final Scene scene = new Scene(canvas, 800, 600);

        primaryStage.setTitle("Game");
        primaryStage.setScene(scene);
        primaryStage.show();

        imgV.relocate(1,1);
        canvas.getChildren().addAll(imgV);

        final Timeline loop = new Timeline(new KeyFrame(Duration.millis(10), new EventHandler<ActionEvent>() {
            /*If Darth Vader is following us, please increase the speed in deltaX and Y*/
            double deltaX = 3;
            double deltaY = 3;


            @Override
            public void handle(final ActionEvent t) {
                imgV.setLayoutX(imgV.getLayoutX() + deltaX);
                imgV.setLayoutY(imgV.getLayoutY() + deltaY);

                final Bounds bounds = canvas.getBoundsInLocal();
                /*Image origin is up-left corner. If the image X is bigger than the maximum of the
                scene minus the size of the Xwing (or it will disappear), go in opposite direction.
                I hardcoded 100 because I already know the size if the image, but I don´t know
                how to get that size with commands.
                * */
                final boolean atRightBorder = imgV.getLayoutX() >= (bounds.getMaxX() - 100);
                final boolean atLeftBorder = imgV.getLayoutX() <= (bounds.getMinX());//empty because the origin point position
                final boolean atBottomBorder = imgV.getLayoutY() >= (bounds.getMaxY() - 100);
                final boolean atTopBorder = imgV.getLayoutY() <= (bounds.getMinY());

                if (atRightBorder || atLeftBorder) {
                    deltaX *= -1;
                }
                if (atBottomBorder || atTopBorder) {
                    deltaY *= -1;
                }

            }
        }));

        loop.setCycleCount(Timeline.INDEFINITE);
        loop.play();
    }

    public static void main(final String[] args) {
        launch(args);
    }
}