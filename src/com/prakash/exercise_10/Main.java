package com.prakash.exercise_10;
import java.util.NoSuchElementException;
import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

/**
 * Created by PARASUP on 10/30/2016 exercise_10
 */
class Contact {
    private String name;
    private String email;

    Contact(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public void display() {
        System.out.println("Name: " + name);
        System.out.println("email: " + email);
    }
} // class Contact {}

class ContactCollection extends Contact implements Iterable<String> {
    ContactCollection(String name, String email) {
        super(name, email);
    }

    @Override
    public Iterator<String> iterator() {
        return null;
    }

    @Override
    public void forEach(Consumer<? super String> action) {

    }

    @Override
    public Spliterator<String> spliterator() {
        return null;
    }
}
public class Main {
    public static void main(String[] args) {
    }
}