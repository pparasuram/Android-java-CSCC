package com.prakash.week_08;

import java.util.ArrayList;

/**
 * Created by PARASUP on 10/18/2016. exercise 8
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

class BusinessContact extends Contact {
    private String phoneNo;

    BusinessContact(String name, String email, String phoneNo) {
        super(name, email);
        this.phoneNo = phoneNo;
    }

    @Override
    public void display() {
        super.display();
        System.out.println("phone number: " + phoneNo);
    }
} // class BusinessContact extends Contact {}
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

public class Main {
    public static void main(String[] args) {
        /*
        Contact contact = new Contact("prakashN","ppN@abc.com");
        BusinessContact bContact = new BusinessContact("appleN","tomatoN@xyz.com", "614-111-3333");
        contact.display();
        bContact.display();
        */
        Contact contact = new Contact("prakashN","ppN@abc.com");
        BusinessContact bContact = new BusinessContact("appleN","tomatoN@xyz.com", "614-111-3333");
        ContactsCollection contactsList = new ContactsCollection();
        contactsList.add(contact);
        contactsList.add(bContact);
        contactsList.display();
    } // public static void main(String[] args)
}
