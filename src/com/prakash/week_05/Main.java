package com.prakash.week_05;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by prakash on 10/4/2016.
 */
class Contact {
    String name;
    String email;
    Contact (String name, String email){
        this.name = name;
        this.email = email;
    }
} // end of class Contact

class AddressBook{
    List<Contact> contacts = new ArrayList();
    void add (Contact contact){
            contacts.add (contact);
    } // void add (Contact contact)

    String searchByName (String name) {
            for (Contact entry: contacts) {
                if (entry.name.equals(name)){
                    return entry.email;
                }
            }
            return null;
    } // String searchByName (String name)

} // class AddressBook{
public class Main {
    public static void main (String[] args) {
        AddressBook myAddressBook = new AddressBook();
        Contact arthur = new Contact("arthur", "ar@abc.com");
        Contact bob = new Contact("Bob Smith", "bob@mail.com");

        myAddressBook.add(arthur);
        myAddressBook.add(bob);
        System.out.println("Bob Smith email = " + myAddressBook.searchByName("Bob Smith"));
        System.out.println("arthur email = " + myAddressBook.searchByName("arthur"));
        System.out.println("junk email = " + myAddressBook.searchByName("junk"));
    } // public static void main (String[] args)
}
