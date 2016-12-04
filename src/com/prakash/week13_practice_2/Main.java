package com.prakash.week13_practice_2;

public class Main {
    public static void main(String[] args) {
        Runnable runnable = new Runnable()
        {
            @Override
            public void run() {
                try {
                    int quotient = 1 / 0;
                } catch (ArithmeticException e) {
                    System.out.println("Arithmetic exception");
                }
            }
        };

        Thread threadA = new Thread(runnable);
        System.out.println("Starting threads");
        threadA.start();
        try {
            threadA.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
            System.out.println("!!! hit exception !!!");
        }
        System.out.println("End of Main.main()");
    }
}