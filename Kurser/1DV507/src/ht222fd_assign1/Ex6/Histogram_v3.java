package ht222fd_assign1.Ex6;

import org.knowm.xchart.PieChart;
import org.knowm.xchart.PieChartBuilder;
import org.knowm.xchart.SwingWrapper;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/*MAIN CLASS HISTOGRAM_V3:
* Xchart piechart.
 *OBS! Class HistogramClass handle the exercise from Java 1.
* */

public class Histogram_v3 {
    public static void main(String[] args) throws FileNotFoundException {
        File fileUser = new File("C:\\Users\\hteva\\IdeaProjects\\1DV507\\src\\ht222fd_assign3\\histogram\\Histo.txt");

        HistogramClass reader = new HistogramClass(fileUser);
        int[] histoPie = reader.Counter();

        PieChart chart = new PieChartBuilder().width(800).height(600).build();

        chart.setTitle("Pie is a lie");

        chart.addSeries("1-10", histoPie[0]);
        chart.addSeries("11-20", histoPie[1]);
        chart.addSeries("21-30", histoPie[2]);
        chart.addSeries("31-40",histoPie[3]);
        chart.addSeries("41-50",histoPie[4]);
        chart.addSeries("51-60",histoPie[5]);
        chart.addSeries("61-70",histoPie[6]);
        chart.addSeries("71-80",histoPie[7]);
        chart.addSeries("81-90",histoPie[8]);
        chart.addSeries("91-100",histoPie[9]);
        chart.addSeries(">100",histoPie[10]);

        new SwingWrapper(chart).displayChart();
    }//end main

}
