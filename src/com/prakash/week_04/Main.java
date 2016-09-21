package com.prakash.week_04;

import java.util.*;

/**
 * Created by prakash on 9/20/2016.
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("week 4 hi!");
        boolean done = false;
        // List<String> cities = new LinkedList<>();
        // LinkedList<LinkedList<YourClass>> list = new LinkedList<LinkedList<YourClass>>();
        List<String> cities = new LinkedList<>();
        Map<String, int[]> temperatureMap = new TreeMap<>();
        Scanner scanner = new Scanner(System.in);
        String keyInput;
        while (! done) {
            displayMenu();
            keyInput = scanner.nextLine();
            if (keyInput.equals("END")) {
                break;
            }
            cities.add(keyInput);
        } // end of while
        temperatureMap = getTemperatures(cities);
        for (String city:cities) {
            System.out.println("Average temperature for City " + city + "is:");
            int [] tempArray = temperatureMap.get(city);
            int avg = 0;
            for (int i=0;i<tempArray.length;i++){
                avg+=tempArray[i];
            }
            avg = avg/(tempArray.length+1);
            System.out.println("average: "+ avg);
        }
    }
    static Map<String, int[]> getTemperatures(List<String> cities){
        Map<String, int[]> temperatureMap = new TreeMap<>();
        Scanner scanner = new Scanner(System.in);
        String keyInput;
        int [] tempArray = new int[5];
        for (String city:cities) {
            System.out.println("Enter temperatures for City:" + city);
            keyInput = scanner.nextLine();
            String [] tempStringArray = keyInput.split(" ");

            for (int i=0; i<tempStringArray.length;i++) {
                tempArray[i] = Integer.parseInt(tempStringArray[i]);
            }
            temperatureMap.put (city, tempArray);
        }
        return (temperatureMap);
    }

    public static void displayMenu() {
        // body
        System.out.println("Please enter a City name: enter END to end");
    }

}
