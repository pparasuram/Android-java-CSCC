package com.prakash.chapter13_pre_exam_practise3_thread_exception;

class Runn implements Runnable {

    @Override
    public void run() {
        int quotient = 1 / 0;
    }
}
class ThreadException implements Thread.UncaughtExceptionHandler {
    @Override
    public void uncaughtException(Thread t, Throwable e) {
        System.out.println("Caught throwable " + e + " for thread "
                + t);
    }
}
public class Main {
    public static void main(String[] args) {
        Runn runnable = new Runn();
        ThreadException tE = new ThreadException();
        Thread.setDefaultUncaughtExceptionHandler(tE);
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