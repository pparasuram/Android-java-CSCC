package com.prakash.Study_Notes;

/**
 * Created by prakash on 11/13/2016.
 *  Two objects are equal in this sense if they occupy the same location in memory.
 *  This is known as an identity check
 *  and two objects that are equal based on an identity check are said to have reference equality.
 *
 *  Composition offers an alternative to implementation inheritance. Rather than extending the Contact class,
 *  BetterContact can wrap the class by keeping a private field representing a Contact object.
 *
 *  Abstract methods are declared methods lacking a body or implementation.
 *  Abstract methods are declared by prefixing a method header with the  abstract  reserved word.
 *  Abstract methods must be declared in abstract classes. Abstract classes are classes that
 *  may or may not contain abstract methods and cannot be used to create instances directly;
 *  Once we declare a method as abstract, we must declare the class containing
 *  the method as abstract as well.
 *  abstract class Animal {
 *  abstract public void speak();
 *  }
 *
 *      @Override
 *      public void speak() {
 *     System.out.println("Bat sounds!");
 *     }
 *
 *  methods declared in an interface type are implicitly publicly accessible; prefixing the method declaration
 *  with  private  or  protected  will result in an error.
 * Another important thing to note is that while we can define fields in an interface, their values cannot change,
 * that is, all interface fields are constants.
 * We can make use of an interface when defining a class using the  implements  reserved word.
 *
 *  interface Flier {
 *      void takeoff();
 *      void fly();
 *      void land();
 *      }
 *
 *  class Airplane implements Flier{}
 *
 *  class Picture extends File implements Displayable, Shareable {
 *  }
 */
class Shape {
    public void draw() {
        System.out.println("Drawing a shape.");
    }
}

class Triangle extends Shape {
    @Override
    public void draw() {
        System.out.println("Drawing a triangle.");
    }
}

class Rectangle extends Shape {
    @Override
    public void draw() {
        System.out.println("Drawing a rectangle.");
    }
}

class Circle extends Shape {
    @Override
    public void draw() {
        System.out.println("Drawing a circle.");
    }
}


public class Main {
    public static void main(String[] args) {
        Shape[] shapes = new Shape[] { new Triangle(), new Rectangle(), new Circle(), new Shape()};
        for (Shape shape: shapes) {
            shape.draw();
        }
    }
}