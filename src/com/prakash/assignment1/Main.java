package com.prakash.assignment1;
import java.io.Console;
import java.util.Scanner;

/**
 * Created by prakash on 9/13/2016.
 */
public class Main {
// Scanner scanner = new Scanner(System.in);
//...
// String name = scanner.nextLine();

        public static void main(String[] args) {
            // write your code here
            System.out.println("Hello, World!");
            boolean doneFlag = false;
            String inString;
            Scanner scanner = new Scanner(System.in);
            int keyInput;
            while (! doneFlag)
            {
                displayMenu();
                inString = scanner.nextLine();
                keyInput = Integer.parseInt(inString);
                if (keyInput == 0) {
                    doneFlag = true;
                    break;
                }
                else
                    System.out.println("You entered:" + keyInput);

            } // end of while (! doneFlag)
            System.out.println("Bye Bye, World!");

        }  // end of main ()
        public static void displayMenu() {
            // body
            System.out.println("Please choose an option:");
            System.out.println("(1) Add a task.");
            System.out.println("(2) Remove a task.");
            System.out.println("(3) Update a task.");
            System.out.println("(4) List all tasks.");
            System.out.println("(0) Exit.");
        }

} // end of main

