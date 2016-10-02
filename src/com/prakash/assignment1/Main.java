package com.prakash.assignment1;
import java.io.Console;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by prakash on 9/13/2016.
 */
public class Main {
// Scanner scanner = new Scanner(System.in);
//...
// String name = scanner.nextLine();

        public static void main(String[] args) {
            List<String> tasks = new ArrayList<>();
            // write your code here
            System.out.println("Hello, Assignment 1!");
            boolean doneFlag = false;
            int integerKeyInput;
            while (! doneFlag)
            {
                displayMenu();
                integerKeyInput = getIntegerKeyInput();
                if (integerKeyInput == 0) {
                    doneFlag = true;
                    break;
                }
                else {
                    // System.out.println("You entered:" + integerKeyInput);
                    switch (integerKeyInput) {
                        case 1: tasks = addATask(tasks);
                                break;
                        case 2: tasks = removeATask(tasks);
                                break;
                        case 3: tasks = updateATask(tasks);
                                break;
                        case 4: listAllTasks(tasks);
                                break;
                    } // end of switch
                } // end of else

            } // end of while (! doneFlag)
            System.out.println("Bye Bye, Assignment 1!");
        }  // end of main ()
        public static List<String> addATask(List<String> tasks){
            // int taskNumber;
            String task;
            // System.out.println("Enter task number: ");
            // taskNumber = getIntegerKeyInput();
            System.out.println("Enter a description of the new task.");
            task = getStringKeyInput();
            tasks.add(task);
            return (tasks);
        } // public static List<String> addATask(List<String> tasks)
        public static List<String> removeATask(List<String> tasks) {
            int taskNumber;
            String task;
            System.out.println("Enter the index of the task to remove.");
            taskNumber = getIntegerKeyInput();
            tasks.remove(taskNumber);
            return (tasks);
        } //        public static List<String> removeATask(List<String> tasks) {
        public static List<String> updateATask(List<String> tasks){
            int taskNumber;
            String task;
            System.out.println("Enter the index of the task to update.");
            taskNumber = getIntegerKeyInput();
            System.out.println("Enter the new description of the task.");
            task = getStringKeyInput();
            tasks.remove (taskNumber);
            tasks.add(taskNumber, task);
            return (tasks);
        } // public static List<String> updateATask(List<String> tasks)
        public static void listAllTasks(List<String> tasks){
            int taskNumber;
            String task;
            int last;
            last = tasks.size();
            for (int i=0; i < last; i++)
            {
                System.out.println(i + ". " + tasks.get(i));
            }
        } // public static void listAllTasks(List<String> tasks){
        public static int getIntegerKeyInput(){
                String inString;
                Scanner scanner = new Scanner(System.in);
                inString = scanner.nextLine();
                return (Integer.parseInt(inString));
            }
        public static String getStringKeyInput(){
            String inString;
            Scanner scanner = new Scanner(System.in);
            inString = scanner.nextLine();
            return (inString);
        }
        public static void displayMenu() {
                // body
                System.out.println("Please choose an option:");
                System.out.println("(1) Add a task.");
                System.out.println("(2) Remove a task.");
                System.out.println("(3) Update a task.");
                System.out.println("(4) List all tasks.");
                System.out.println("(0) Exit.");
            } // public static void displayMenu()

} // end of main

