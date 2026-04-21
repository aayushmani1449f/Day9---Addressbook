package com.addressbook;

public class AddressBookMain {
    public static void main(String[] args) {
        System.out.println("Welcome to Address Book Program");
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        AddressBook addressBook = new AddressBook();

        addressBook.addContact(scanner);
        addressBook.displayContacts();

        scanner.close();
    }
}
