package ht222fd_assign3.histogram;


import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.FileNotFoundException;

public class HistoDisplay {

    /*VARIABLES EVERYWHERE*/
    private static HistoClassFx histoClassDisplay;
    private static final int SIZE = 11;
    private static final String[] category = new String[]{">1", ">10", ">20", ">30", ">40", ">50", ">60", ">70", ">80",
            ">90", "Others"};
    private static int[] histoDisplayCounter = new int[11];


    public static void display(String user) throws FileNotFoundException {
        /*SETTING UP THE STAGE*/
        Stage HistoDisplayStage = new Stage();
        HistoDisplayStage.initModality(Modality.APPLICATION_MODAL);
        HistoDisplayStage.setTitle("Histo");

         /*SETTING UP BAR CHART*/
        final CategoryAxis xAxis = new CategoryAxis();
        final NumberAxis yAxis = new NumberAxis();
        final BarChart<String,Number> bc = new BarChart<String,Number>(xAxis,yAxis);
        bc.setTitle("Title");
        xAxis.setLabel("X");
        yAxis.setLabel("Y");

        histoClassDisplay = new HistoClassFx(user);
        histoDisplayCounter = histoClassDisplay.Counter();

         /*CREATE A SERIE WITH THE COUNTER ARRAY DATA AND THE CATEGORY*/
        XYChart.Series series1 = new XYChart.Series();
        series1.setName("serie");

        for (int i = 0; i <SIZE ; i++) {
            series1.getData().add(new XYChart.Data(category[i], histoDisplayCounter[i]));
        }
        bc.getData().addAll(series1);

        /*GUI LAY-OUT*/
        Scene scene  = new Scene(bc,800,600);
        HistoDisplayStage.setScene(scene);
        HistoDisplayStage.showAndWait();
    }


}
