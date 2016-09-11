package com.prakash.week_02;

/**
 * Created by prakash on 9/6/2016.
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello");
        int[][] tempHumArray = {{45, 29, 10, 22, 41, 28, 33}, {95, 60, 25, 5, 0, 75, 90}};
        String [] daysOfTheWeek = {"Monday","Tuesday", "Wednesday", "Thursday","Friday","Saturday","Sunday"};
        // System.out.println("temperature.length " + temperature.length);
        // System.out.println("temperature[0].length " + temperature[0].length);
        for (int i = 0; i < tempHumArray[0].length; i++) {
                // tempHumArray[0][i]);
            if (tempHumArray[0][i] <32 && tempHumArray[1][i] > 50)
            {
                System.out.println(daysOfTheWeek[i] + " has a high probability fo Snow");
            }
        }
    }
}
