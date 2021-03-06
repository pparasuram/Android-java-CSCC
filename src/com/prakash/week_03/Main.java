package com.prakash.week_03;

import java.util.Scanner;

/**
 * Created by prakash on 9/13/2016.
 */
public class Main {
    public static void main(String[] args) {
        // write your code here
        System.out.println("Hello Week 3 exercise ");
        boolean doneFlag = false;
        double keyInput;
        while (! doneFlag)
        {
            displayMenu();
            if ((keyInput = getKey()) == -460.0) {
                doneFlag = true;
                break;
            }
            else
                System.out.println("Fahrenheit " + keyInput + " is Celsius " + celsius(keyInput));
        } // end of while (! doneFlag)
        System.out.println("Bye Bye, Week 3!");

    }  // end of main ()
    public static void displayMenu() {
        // body
        System.out.println("Please enter a temperature in Fahrenheit:");
        System.out.println("-460 to Exit.");
    }
    public static double celsius(double fahrenheit) {
        return ((fahrenheit-32)*5/9);
    }
    public static double getKey(){
        String inString;
        Scanner scanner = new Scanner(System.in);
        inString = scanner.nextLine();
        return (Double.parseDouble(inString));
    }
}
