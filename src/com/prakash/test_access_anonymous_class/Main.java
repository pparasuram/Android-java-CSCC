package com.prakash.test_access_anonymous_class;

/**
 * Created by PARASUP on 11/21/2016.
 */
interface A {
    public void display(String s);
}
class Test {
    private Integer intA = 5;
    public void displayA() {
        new A() {
            @Override
            public void display(String str){
                System.out.println(str + " " + intA);
            }
        }.display("hello");
    }
}
public class Main {
    public static void main(String[] args) {
        Test x = new Test();
        x.displayA();
    }
}
