package ht222fd_assign3.Ex1;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
//YES It has its own javadoc ;)

/**
 * Write a program EuclideanMain that takes two integers as input and calculates (and presents) their GCD using this algorithm.<br>
 * The assignment never says that we cannot use FX ;)
 * @author htevar
 */
public class EuclideanMain extends Application {
    Stage window;

    /**
     * Main method that launch the stage.
     * @param args
     */
    public static void main(String[] args) {
        launch(args);
    }

    /**
     * Stage of the program.
     * @param primaryStage
     * @throws Exception
     */
    @Override
    public void start(Stage primaryStage) throws Exception {
        /**
         * Stage called window because I used to mistake the stage with the scene.
         */
        window = primaryStage;
        window.setTitle("Euclidean Algorithm");

        GridPane grid = new GridPane();

        //Images, labels, textbox and stuff
        Image tree = new Image("Helpers/assets/lnuTree.png");
        ImageView treeIV = new ImageView(tree);
        treeIV.setFitWidth(50);
        treeIV.setPreserveRatio(true);

        Text sceneTitle = new Text("Assignment 3 \nGenerate GCD \nStudent: ht222fd");
        Label lbl1 = new Label("Add two integers");
        TextField first = new TextField();
        TextField second = new TextField();
        Button btn1 = new Button("GCD");
        Label answer = new Label("");
        answer.setStyle("-fx-font-size: 14px");
        answer.setStyle("-fx-font-weight: bold");

        /*btn1 event:
         * It tries to parse the strings to integers:
          *     True: calls method GCD and returns integer
          *     False: throws error message in scene
         */

        btn1.setOnAction(event -> {
            String a = first.getText();
            String b = second.getText();

            try{
                int firstInt = Integer.parseInt(a);
                int secondInt = Integer.parseInt(b);
                int gcd = GCD(firstInt,secondInt);

                answer.setText(Integer.toString(gcd));
            }
            catch (NumberFormatException e){
                answer.setText("Please use only Integers");
                first.clear();
                second.clear();
            }

        });

        //GRID LAYOUT
        grid.setPadding(new Insets(5,5,5,5));
        grid.setVgap(10);
        grid.setHgap(10);

        grid.add(treeIV,0,0);
        grid.add(sceneTitle, 1,0);
        grid.add(lbl1, 0,1);
        grid.add(first,0,2);
        grid.add(second, 1,2);
        grid.add(btn1, 0,3);
        grid.add(answer, 1,3);
        //Scene and window
        Scene mainSc = new Scene(grid, 300, 200);
        window.setScene(mainSc);
        window.show();
    }
    /**
     * Recursive method of the Euclidean Algorithm I found... somewhere in the internet. Probably wikipedia.<br>
     *     Handling with the user input done in the button event handler.
     * @return greatest common divisor of two integers
     */

    public int GCD(int a , int b){
        if (b == 0){
            return a;
        }
        else{
            return GCD(b, a%b);
        }
    }//end GCD
}
