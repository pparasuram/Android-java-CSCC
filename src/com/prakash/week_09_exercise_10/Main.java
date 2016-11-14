package com.prakash.week_09_exercise_10;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by prakash on 11/13/2016.
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
class ContactsCollection {
    ArrayList<Contact> contactsList = new ArrayList<Contact>();
    public void add(Contact contact) {
        contactsList.add (contact);
    }
    public void display() {
        for(int i =0; i < contactsList.size(); i++)
            contactsList.get(i).display();
    }
}

class ContactCollection implements Iterable<Contact> {
    List<Contact> contactsList = new ArrayList<>();

    public ContactCollection(Contact contact) {
        this.contactList.add(contact);
    }

    @Override
    public Iterator<Contact> iterator() {
        return null;
    }
}
public class Main {
}
