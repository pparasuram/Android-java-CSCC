package com.prakash.chapter13_pre_exam_class_exercise_1;
class CheckingAccount
{
    private int balance;

    public CheckingAccount(int initialBalance)
    {
        balance = initialBalance;
    }

    public int withdraw(int amount)
    {
        if (amount <= balance)
        {
            try {
                Thread.sleep((int) (Math.random() * 200));
            }
            catch (InterruptedException ie) {
            }

            balance -= amount;
        }
        return balance;
    }
}
class Runn implements Runnable {
    public Runn(CheckingAccount account) {
        this.account = account;
    }
    CheckingAccount account;
        @Override
        public void run () {

        synchronized (account) {
            String name = Thread.currentThread().getName();
            for (int i = 0; i < 10; i++) {
                System.out.println(name + " tries to withdraw $10, balance: " +
                        account.withdraw(10));
            }

        }
    }
}
public class Main {
    public static void main(String[] args) {
        CheckingAccount account = new CheckingAccount(100);
        Runn r = new Runn(account);
        Thread thdHusband = new Thread(r);
        thdHusband.setName("Husband");

        Thread thdWife = new Thread(r);
        thdWife.setName("Wife");

        thdHusband.start();
        thdWife.start();
    }
}
