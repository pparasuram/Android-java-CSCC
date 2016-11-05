package com.prakash.week_09_in_class;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by PARASUP on 10/25/2016. Contact
 */
abstract class Contact{
    private String name;

    public Contact(String name) {
        this.name = name;
    }
    abstract public void contact();
}
class EmailContact extends Contact{
    private String email;

    public EmailContact(String name, String email) {
        super(name);
        this.email = email;
    }

    @Override
    public void contact() {
        System.out.println("Emailing: " + email);
    }
}
class PhoneContact extends Contact{
    private String phoneNumber;

    public PhoneContact(String name, String phoneNumber) {
        super(name);
        this.phoneNumber = phoneNumber;
    }

    @Override
    public void contact() {
        System.out.println("Calling: " + phoneNumber);
    }
}

public class Main {
    public static void main (String [] args){
        PhoneContact bob = new PhoneContact("Bob", "123-456-7890");
        EmailContact sue = new EmailContact("Sue", "sue@email.com");
        List<Contact> contacts = new ArrayList<>();
        contacts.add(bob);
        contacts.add(sue);
        for (Contact c: contacts) {
            c.contact();
        }
    }
}
