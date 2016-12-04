package com.prakash.exam_02_learn;

/**
 * Created by prakash on 11/13/2016.
 */
class WeatherData {
    String cityName;
    int[] temperatures;

    WeatherData(String cityName, int[] temperatures) {
        this.cityName = cityName;
        this.temperatures = temperatures;
    }

    public void displayAverageTemp() {
        int numberOfDays = temperatures.length;

        int sum = 0;
        for (int temp: temperatures) {
            sum += temp;
        }
        try {
            int average = sum / numberOfDays;
            System.out.println("The average temperature in " + cityName + " will be: " + average+ ".");
        }
        catch (ArithmeticException e) {
            System.out.println("Not enough information for " + cityName + ".");
        }
    }
}

public class Main {
    public static void main(String[] args) {
        int[] columbusTemps = {60, 70, 65};
        int[] clevelendTemps = {};

        WeatherData columbus = new WeatherData("Columbus", columbusTemps);
        columbus.displayAverageTemp();

        WeatherData cleveland = new WeatherData("Cleveland", clevelendTemps);
        cleveland.displayAverageTemp();
    }
}



