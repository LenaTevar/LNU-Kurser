package ht222fd_assign1.Ex6;

import org.knowm.xchart.CategoryChart;
import org.knowm.xchart.CategoryChartBuilder;
import org.knowm.xchart.SwingWrapper;
import java.io.File;
import java.io.FileNotFoundException;

/*MAIN CLASS HISTOGRAM_V2
* Xchart Histogram.
* *OBS! Class HistogramClass handle the exercise from Java 1.
* */

public class Histogram_v2 {
    public static void main(String[] args) throws FileNotFoundException {

        File inputFile = new File("C:\\Users\\hteva\\IdeaProjects\\1DV507\\src\\ht222fd_assign3\\histogram\\Histo.txt");
//        int[] histoArr = Counting(inputFile);

        HistogramClass reader = new HistogramClass(inputFile);
        int [] histoArr = reader.Counter();

        int[] yData = new int[]{10, 20, 30, 40, 50, 60, 70, 80, 90, 100, 999};

        CategoryChart chart = new CategoryChartBuilder().width(800).height(600).title("Score Histogram").xAxisTitle("Score").yAxisTitle("Number").build();

        chart.addSeries("Histogram", yData, histoArr);


        new SwingWrapper(chart).displayChart();
    }//end main
}
