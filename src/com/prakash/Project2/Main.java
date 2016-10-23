package com.prakash.Project2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/**
 * Created by PARASUP on 10/16/2016. Project 2
 */
class Task {
    // title, description, and priority
    String title;
    String description;
    int priority;
    Task(){
        title = Main.getStringKeyInput("Enter the new task's name.");
        description = Main.getStringKeyInput("Enter the new task's description.");
        priority = Main.getPriorityIntegerKeyInput("Enter the new task's priority");
    }

    public int getPriority() {
        return priority;
    }

    void display(){
        System.out.printf ("Title: " + title + " ");
        System.out.printf("Description: " + description + " " );
        System.out.println("Priority: " + priority);
    }
    /*
    void display(Integer priority) {
        if (this.priority == priority) {
            this.display();
        }
    }
    */
}
public class Main {
    static Scanner scanner = new Scanner(System.in);
    static String keyInput;
    public static void main(String[] args) {
        System.out.println("Welcome to Project 2");
        ArrayList<Task> taskArray = new ArrayList<>();
     //   Task oneTask = new Task();
     //   taskArray.add(oneTask);
     //   oneTask.display();
/*        List<String> tasks = new ArrayList<>(); */
        boolean doneFlag = false;
        int integerKeyInput;
        while (! doneFlag) {
            displayMenu();
            integerKeyInput = getMenuIntegerKeyInput("Menu");
            if (integerKeyInput == 0) {
                doneFlag = true;
                break;
            }
            else {
                // System.out.println("You entered:" + integerKeyInput);
                switch (integerKeyInput) {
                    case 1: taskArray = addATask(taskArray);
                        break;
                    case 2: taskArray = removeATask(taskArray);
                        break;
                    case 3: taskArray = updateATask(taskArray);
                        break;
                    case 4: listAllTasks(taskArray);
                        break;
                    case 5: listPriorityNumberTasks(taskArray);
                        break;
                    case 0:
                        break;
                } // end of switch
            } // end of else

        } // end of while (! doneFlag)
        System.out.println("bye bye from Project 2");
    } // public static void main(String[] args)
    public static ArrayList<Task> addATask(ArrayList<Task> taskArray){
        // int taskNumber;
        // System.out.println("Enter task number: ");
        // taskNumber = getIntegerKeyInput();
        // System.out.println("Enter a description of the new task.");
        Task task = new Task();
        taskArray.add(task);
        return (taskArray);
    } // public static List<String> addATask(List<String> tasks)
    public static ArrayList<Task> removeATask(ArrayList<Task> taskArray) {
        int taskNumber;
        taskNumber = getAnyIntegerKeyInput("Enter the index of the task to remove.");
        if (taskNumber < taskArray.size())
            taskArray.remove(taskNumber);
        return (taskArray);
    } //        public static List<String> removeATask(List<String> tasks) {
    public static ArrayList<Task> updateATask(ArrayList<Task> taskArray){
        int taskNumber;
        taskNumber = getAnyIntegerKeyInput("Enter the index of the task to update.");
        if (taskNumber < taskArray.size()) {
            taskArray.remove (taskNumber);
            Task task = new Task();
            taskArray.add(taskNumber, task);
        }
        return (taskArray);
    } // public static List<String> updateATask(List<String> tasks)
    public static void listAllTasks(List<Task> taskArray){
        int last;
        last = taskArray.size();
        for (int i=0; i < last; i++)
        {
            // Task index: 2, Name: task2, Description: task2 descr, Priority: 2
            System.out.printf("Task index: " + i + ", ");
            taskArray.get(i).display();
        }
    } // public static void listAllTasks(List<String> tasks){
    public static void listPriorityNumberTasks(List<Task> taskArray){
        int priority;
        int last;
        priority = getPriorityIntegerKeyInput("Enter a priority");
        last = taskArray.size();
        for (int i=0; i < last; i++)
        {
            if (taskArray.get(i).getPriority() == priority){
                System.out.printf("Task index: " + i + ", ");
                taskArray.get(i).display();
            }
        }
    }
    public static int getAnyIntegerKeyInput(String promptMessage) {
        int intInput = 0;
        boolean done = false;
        while (!done){
            try{
                System.out.println(promptMessage);
                keyInput = scanner.nextLine();
                intInput = Integer.parseInt(keyInput);
                done = true;
            }
            catch (NumberFormatException e){
                System.out.println("must enter integer try again");
                keyInput = scanner.nextLine();
            }
        } // end of while
        return (intInput);
    }
    public static int getPriorityIntegerKeyInput(String message) {
        int intInput = 0;
        boolean done = false;
        while (!done){
            intInput = getAnyIntegerKeyInput(message);
                if ((intInput < 0) || (intInput > 5)) {
                    System.out.println("Priority must be between 0 and 5");
                }
                else
                    done = true;
            }
        return (intInput);
    }
    public static int getMenuIntegerKeyInput(String message) {
        int intInput = 0;
        boolean done = false;
        while (!done){
            intInput = getAnyIntegerKeyInput(message);
                if ((intInput < 0) || (intInput > 5)) {
                    System.out.println("Must enter between 0 and 5");
                }
                else
                    done = true;
        } // end of while
        return (intInput);
    }
    public static String getStringKeyInput(String message){
        boolean done = false;
        while (!done){
            System.out.println(message);
            keyInput = scanner.nextLine();
            if (keyInput.equals("")) {
                System.out.println("Must enter a value");
            }
            else
                done = true;
        } // end of while
        return (keyInput);
    }
    public static void displayMenu() {
        // body
        System.out.println("Please choose an option:");
        System.out.println("1) Add a task.");
        System.out.println("2) Remove a task.");
        System.out.println("3) Update a task.");
        System.out.println("4) List all tasks.");
        System.out.println("5) List all tasks of a certain priority.");
        System.out.println("0) Exit.");
    } // public static void displayMenu()
} // public class Main
