package com.prakash.test_access_anonymous_class_without;

/**
 * Created by PARASUP on 11/21/2016.
 */
interface A {
    public void display(String s);
}
class Test {
    private Integer intA = 5;

    public void displayA() {
        class A {
            public void display(String str) {
                System.out.println(str + " " + intA);
            }
        }
        A y = new A();
        y.display("stuff");
    }
}
public class Main {
    public static void main(String[] args) {
        Test x = new Test();
        x.displayA();
    }
}
