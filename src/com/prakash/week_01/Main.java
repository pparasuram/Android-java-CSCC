package com.prakash.week_01;
// package
public class Main {

    public static void main(String[] args) {
	// write your code here
        String ciyName = "Columbus";
        int zipCode = 43215;
        float [] temperatures = {32, 25, 27, 40, 45};

        float averageTemp = (temperatures[0] + temperatures[1] + temperatures [2]
                + temperatures [3] + temperatures [4]) / 5;
        System.out.println("City: " + ciyName);
        System.out.println("Zip code: " + zipCode);
        System.out.println("Average temperature: " + averageTemp);
    }
}
