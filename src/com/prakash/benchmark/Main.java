package com.prakash.benchmark;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Main {
    static List<Integer> addEntries(int number, List<Integer> list){
        for (int i = 0; i < number; i++)
            list.add(i);
        return list;
    }

    static long benchmarkAddList(int entries, List<Integer> testList) {
        long startTime = System.currentTimeMillis();
        addEntries(entries, testList);
        long endTime = System.currentTimeMillis();
        return endTime - startTime;
    }

    static long benchmarkIterateList(int entries, List<Integer> testList) {
        addEntries(entries, testList);
        long startTime = System.currentTimeMillis();
        long sum = 0;
        for (int entry: testList) {
            sum += entry;
        }
        long endTime = System.currentTimeMillis();
        return endTime - startTime;
    }


    static void benchmark() {
        int testEntries = 1000000;  //1 million
        List<Integer> arrayList = new ArrayList<>();
        List<Integer> linkedList = new LinkedList<>();

        long arrayAddTime = benchmarkAddList(testEntries, arrayList);
        long linkedAddTime = benchmarkAddList(testEntries, linkedList);

        arrayList = new ArrayList<>();
        linkedList = new LinkedList<>();

        long arrayIterateTime = benchmarkIterateList(testEntries, arrayList);
        long linkedIterateTime = benchmarkIterateList(testEntries, linkedList);

        System.out.println("Time (ms) to add to ArrayList: " + arrayAddTime);
        System.out.println("Time (ms) to add to LinkedList: " + linkedAddTime);
        System.out.println("Time (ms) to iterate ArrayList: " + arrayIterateTime);
        System.out.println("Time (ms) to iterate LinkedList: " + linkedIterateTime);

    }
    public static void main(String[] args) {
        benchmark();
    }
}