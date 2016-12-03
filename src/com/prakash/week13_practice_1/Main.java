package com.prakash.week13_practice_1;
class SomeRun implements Runnable {
    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        int count = 0;
        while (count < 10) {
            System.out.println(name + ": " + count++);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
public class Main {
    public static void main(String[] args) {
        SomeRun r = new SomeRun();
/*        Runnable runnable = new Runnable()
        {
            @Override
            public void run() {
                String name = Thread.currentThread().getName();
                int count = 0;
                while (count < 10)
                    System.out.println(name + ": " + count++);
            }
        };
*/
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