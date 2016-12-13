package com.prakash.chapter13_pre_exam_practise_2;
public class Main {
    public static void main(String[] args) {
        Runnable runnable = new Runnable()
        {
            @Override
            public void run() {
                int quotient = 1 / 0;
            }
        };

        Thread threadA = new Thread(runnable);
        System.out.println("Starting threads");
        threadA.start();
        try {
            threadA.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("End of Main.main()");
    }
}