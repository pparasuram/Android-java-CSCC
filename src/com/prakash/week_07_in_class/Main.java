package com.prakash.week_07_in_class;

/**
 * Created by PARASUP on 10/16/2016.
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
public class Main {
    public static void main(String[] args) {
        Contact contact = new Contact("prakash","pp@abc.com");
        BusinessContact bContact = new BusinessContact("apple","tomato@xyz.com", "614-111-2222");
        contact.display();
        bContact.display();
    } // public static void main(String[] args)
}