package com.prakash.exercise_09;

/**
 * Created by PARASUP on 10/29/2016. exercise_09
 */
abstract class Contact {
    private String name;

    public Contact(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
class EmailContact extends Contact {
    private String email;
    public EmailContact(String name, String email) {
        super(name);
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public void display() {
        System.out.println("Emailing: " + email);
    }
}
class PhoneContact extends Contact {
    private String phone;
    public PhoneContact(String name, String phone) {
        super(name);
        this.phone = phone;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
    public void display() {
        System.out.println("Calling: " + phone);
    }
}
public class Main {
    public static void main (String [] args){
        System.out.println("Hello exercise 3");
        EmailContact eContact = new EmailContact("arthur", "aneuman1@cscc.edu");
        PhoneContact pContact = new PhoneContact("bob", "123-456-7890");
        eContact.display();
        pContact.display();
        System.out.println("Bye bye exercise 3");
    }
}
