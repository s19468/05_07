/*
    Autor: Rafał Tęcza
    Index: s19468
*/
package pjwstk.lab5.zadanie7;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        GradesStatistics.init();
        int[] grades = GradesStatistics.getGrades();
        System.out.println("The grades are: " + Arrays.toString(grades));

        GradesStatistics.showAverage();
        GradesStatistics.showMedian();
        GradesStatistics.showMinimum();
        GradesStatistics.showMaximum();
        GradesStatistics.showStandardDeviation();
    }

}
