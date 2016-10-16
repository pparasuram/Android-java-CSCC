package com.prakash.week_06;

/**
 * Created by PARASUP on 10/11/2016.
 */
class Arithmetic {
    public static double average (double[] values) throws Exception {
        double sum =0;
        if (values.length == 0) {
            throw new Exception("cannot divide by zero");
        }
        for (double data:values){
            sum += data;
        }
        return (sum/values.length);
    }
}
public class InClass {
    public static void main(String[] args) {
        double [] someValues = {1};
        double average;
        try {
            average = Arithmetic.average(someValues);
        }
        catch (Exception e) {
            System.out.println("exception " + e + " occurred");
            average =0;
        }
        System.out.println("average is " + average);
    } // public static void main(String[] args)
}
