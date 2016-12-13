package com.prakash.week13_pre_exam_practise_1;
class R implements Runnable {
    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        int count = 0;
        while (count < 10) {
            System.out.println(name + ": " + count++);
            try {
                Thread.sleep(500);
            }
            catch(InterruptedException e) {
                System.out.println(e);
            }
        }
    }
}
public class Main {
    public static void main(String[] args) {
        R r = new R();
        Thread threadA = new Thread(r);
        Thread threadB = new Thread(r);
        System.out.println("Starting threads");
        threadA.start();
        threadB.start();
        try {
            threadA.join();
            threadB.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("End of Main.main()");
    }
}