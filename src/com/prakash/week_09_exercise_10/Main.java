package com.prakash.week_09_exercise_10;

import java.util.*;
import java.util.function.Consumer;

/**
 * Created by prakash on 11/13/2016.
 */
class Contact implements Comparable<Contact> {
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
    @Override
    public int compareTo(Contact o) {
        if (!name.equals(o.name)) {
            return name.compareTo(o.name);
            }
        else {
            return email.compareTo(o.email);
            }
        }
} // class Contact {}
class ContactCollection implements Iterable<Contact> {
    ArrayList<Contact> contactsList = new ArrayList<>();

    public void add(Contact contact) {
        contactsList.add(contact);
    }
    @Override
    public Iterator<Contact> iterator() {
        return new MyIterator();
        // return (contactsList.iterator());
    }
    private class MyIterator implements Iterator<Contact> {
        int here;
        public MyIterator() {
            this.here = 0;
        }

        @Override
        public boolean hasNext() {
            return (here < contactsList.size());
        }

        @Override
        public Contact next() {
            if (here < (contactsList.size())) {
                Contact c = (contactsList.get(here));
                here++;
                return c;
            } else {
                throw new NoSuchElementException();
            }
        }
        @Override
        public void remove() {
            if (here < contactsList.size()) {
                contactsList.remove(here);
            } else {
                throw new UnsupportedOperationException();
            }
        }
    }
}
public class Main {
    public static void main(String[] args) {
        Contact bob = new Contact("bob", "bob@bob.com");
        Contact arthur = new Contact("arthur", "arthur@arthur.com");
        Contact arthur2 = new Contact("arthur2", "aarthur@arthur.com");
        Contact prakash = new Contact("prakash", "prakash1@prakash1.com");
        Contact prakash2 = new Contact("prakash2", "prakash2@prakash1.com");
        ContactCollection contactColl = new ContactCollection();
        Iterator<Contact> it = contactColl.iterator();
        contactColl.add(bob);
        contactColl.add(arthur);
        contactColl.add(arthur2);
        contactColl.add(prakash);
        contactColl.add(prakash2);
        System.out.println("Welcome to exercise 10");
        for (Contact c:contactColl){
            c.display();
        }
        System.out.println("bye bye from exercise 10");
    }
}
