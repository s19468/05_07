/*
    Autor: Rafał Tęcza
    Index: s19468
*/
package pjwstk.lab5.zadanie7;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GradesStatistics {

    private static int studentsNumber;
    private static List<Student> students = new ArrayList<Student>();

    public static void init() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            System.out.print("Enter the number of students: ");
            studentsNumber = Integer.valueOf(reader.readLine());

            for(int i = 0; i < studentsNumber; i++) {
                int grade;
                do {
                    int id = i+1;
                    System.out.print("Enter the grade for student " + id + ": ");
                    grade = Integer.valueOf(reader.readLine());
                } while(grade < 0 || grade > 100);

                Student student = new Student(grade);
                students.add(student);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static int[] getGrades() {
        List<Integer> grades = new ArrayList<>();

        for(Student student : students) {
            grades.add(student.getGrade());
        }

        int[] gradesArray = grades.stream().mapToInt(i->i).toArray();
        return gradesArray;
    }

    public static void showAverage() {
        double average = 0;

        for(Student student : students) {
            average = average + student.getGrade();
        }

        average = average/students.size();
        System.out.println("The average is: " + String.format("%.2f", average).replace(",", "."));
    }

    public static void showMedian() {
        int[] grades = getGrades();
        double median = findMedian(grades);

        System.out.println("The median is: " + String.format("%.2f", median).replace(",", "."));
    }

    public static void showMinimum() {
        int[] grades = getGrades();
        int minimum = Integer.MAX_VALUE;

        for(int g : grades) {
            if(g < minimum) {
                minimum = g;
            }
        }
        System.out.println("The minimum is: " + minimum);
    }

    public static void showMaximum() {
        int[] grades = getGrades();
        int maximum = Integer.MIN_VALUE;

        for(int g : grades) {
            if(g > maximum) {
                maximum = g;
            }
        }
        System.out.println("The maximum is: " + maximum);
    }

    public static void showStandardDeviation() {
        int[] array = getGrades();
        double value = 0.0;
        double standardDeviation = 0.0;

        int size = array.length;

        for(double number : array) {
            value += number;
        }

        double mean = value/size;

        for(double num: array) {
            standardDeviation += Math.pow(num - mean, 2);
        }

        System.out.println("The standard deviation is: " + String.format("%.2f", Math.sqrt(standardDeviation/size)).replace(",", "."));
    }

    static double findMedian(int[] array) {
        Arrays.sort(array);
        double median;
        int totalElements = array.length;

        if (totalElements % 2 == 0) {
            int sumOfMiddleElements = array[totalElements / 2] + array[totalElements / 2 - 1];
            median = ((double) sumOfMiddleElements) / 2;
        } else {
            median = (double) array[array.length / 2];
        }
        return median;
    }
}
