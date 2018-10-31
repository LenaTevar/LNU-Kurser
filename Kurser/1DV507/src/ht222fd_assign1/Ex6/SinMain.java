package ht222fd_assign1.Ex6;


import org.knowm.xchart.QuickChart;
import org.knowm.xchart.SwingWrapper;
import org.knowm.xchart.XYChart;

import java.util.Scanner;

/*
* Write a program SinMain.java plotting the curve y = (1 + x/pi)*cos(x)*cos(40*x) in the range 0 <= x <= 2*pi.
* */
public class SinMain {
    public static void main(String[] args) throws Exception {

        Scanner in = new Scanner(System.in);

        System.out.print("Add number of points: ");

        int numberOfPoints = userCheck(in);
        double[] xData = new double[numberOfPoints];
        double[] yData = new double[numberOfPoints];
        double chartDivider = (Math.PI*2/numberOfPoints);
        double temp;

        System.out.println("Calculating curve with " + numberOfPoints + " number of points.");

        for (int i = 0; i < numberOfPoints  ; i++) {
            /*Dear Lena from the past:
            * IT IS NOT xData[i] += chartDivider * i!!!
            * */
            temp = chartDivider * i;
            xData[i] = temp;
            yData[i] = (1 + xData[i]/Math.PI) * Math.cos(xData[i]) * Math.cos(xData[i] * 40);

        }

        // Create Chart
        XYChart chart = QuickChart.getChart("Ugly Function", "X", "Y", "y = (1 + x/pi)*cos(x)*cos(40*x)", xData, yData);

        // Show it
        new SwingWrapper(chart).displayChart();

    }

    private static int userCheck(Scanner input) {
        while (!input.hasNextInt()) {
            System.out.print("Please enter an integer: ");
            input.next();
        }
        return input.nextInt();

    }

}
