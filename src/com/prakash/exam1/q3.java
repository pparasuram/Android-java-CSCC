package com.prakash.exam1;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by PARASUP on 10/2/2016.
 */
public class q3 {
    static List<String> combine(List<String> firstList, List<String> secondList) {
        List<String> newList = new ArrayList<>();

                for (String item: firstList){
                    newList.add(item);
                };
                for (String item: secondList){
                    newList.add(item);
                };
                return (newList);

    } //static List<String> combine(List<String> firstList, List<String> secondList)
    public static void main(String[] args) {
        List<String> firstList = new ArrayList<>();
        firstList.add ("Cleveland");
        firstList.add ("Columbus");

        List<String> secondList = new ArrayList<>();
        secondList.add ("toledo");
        secondList.add ("france");
        List<String>  combinedList = new ArrayList<>();
        combinedList = combine(firstList,secondList);
        for (String item: combinedList){
            System.out.println(item);
        }
    }
}
