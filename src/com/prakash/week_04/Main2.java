package com.prakash.week_04;
import java.util.*;
/**
 * Created by PARASUP on 9/26/2016.
 */
public class Main2 {
/**
 * Created by prakash on 9/20/2016.
 */
        /**
         * @param args the command line arguments
         */
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
                System.out.println("Average temperature for City " + city + " is:");
                int [] tempArray = temperatureMap.get(city);
                double avg = 0;
                for (int i=0;i<tempArray.length;i++){
                    avg+=tempArray[i];
                    // System.out.println("city "+ city + " temp "+ i + " is "+ tempArray[i]);
                }
                avg = avg/(tempArray.length);
                System.out.println("average: "+ avg);
            }
        } // main
        static Map<String, int[]> getTemperatures(List<String> cities){
            Map<String, int[]> temperatureMap = new TreeMap<>();
            Scanner scanner = new Scanner(System.in);
            String keyInput;
            for (String city:cities) {
                int [] tempArray = new int[5];
                System.out.println("Enter temperatures for City:" + city);
                keyInput = scanner.nextLine();
                String [] tempStringArray = keyInput.split(" ");
                for (int i=0; i<tempStringArray.length;i++) {
                    tempArray[i] = Integer.parseInt(tempStringArray[i]);
                    // System.out.println("city "+ city + " temp "+ i + " is "+ tempArray[i]);
                } // for (int i=0; i<tempStringArray.length;i++)
                temperatureMap.put(city, tempArray);
            } // for (String city:cities) {
            return (temperatureMap);
        } // static Map<String, int[]> getTemperatures(List<String> cities){
        public static void displayMenu() {
            // body
            System.out.println("Please enter a City name: enter END to end");
        } // public static void displayMenu()

}
