package com.prakash.week_06_inclass;


import java.util.Scanner;

/**
 * Created by PARASUP on 10/11/2016.
 */
class AcceptUserInput{
    Scanner scanner = new Scanner(System.in);
    String keyInput;
    public String promptString(String message) {
            System.out.println(message);
            keyInput = scanner.nextLine();
            return (keyInput);
    }
    public int promptInt(String message) {
        int intInput = 0;
        boolean done = false;
        System.out.println(message);
        keyInput = scanner.nextLine();
        while (!done){
            try{
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
    public double promptDouble(String message) {
        double doubleInput = 0;
        boolean done = false;
        System.out.println(message);
        keyInput = scanner.nextLine();
        while (!done){
            try{
                doubleInput = Double.parseDouble(keyInput);
                done = true;
            }
            catch (NumberFormatException e){
                System.out.println("must enter double try again");
                keyInput = scanner.nextLine();
            }
        } // end of while
        return (doubleInput);
    }
} // class AcceptUserInput{


public class Main {
    public static void main(String[] args) {
        AcceptUserInput input = new AcceptUserInput();
        // System.out.println(input.promptString("Enter a String value"));
        System.out.println(input.promptString("Enter a String value"));
        System.out.println(input.promptInt("Enter a Integer value"));
        System.out.println(input.promptDouble("Enter a Double value"));
    } // public static void main(String[] args)
} // public class Main
