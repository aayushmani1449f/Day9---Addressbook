package com.addressbook;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class AddressBookMain {
    public static void main(String[] args) {
        System.out.println("Welcome to Address Book Program");
        Scanner scanner = new Scanner(System.in);
        Map<String, AddressBook> addressBookMap = new HashMap<>();

        boolean runSystem = true;
        while (runSystem) {
            System.out.println("\n--- Address Book System Menu ---");
            System.out.println("1. Create New Address Book");
            System.out.println("2. Access Existing Address Book");
            System.out.println("3. Display All Address Books");
            System.out.println("4. Exit System");
            System.out.print("Choose an option: ");
            int systemChoice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (systemChoice) {
                case 1:
                    System.out.print("Enter a unique name for the new Address Book: ");
                    String newBookName = scanner.nextLine();
                    if (addressBookMap.containsKey(newBookName)) {
                        System.out.println("Address Book with this name already exists.");
                    } else {
                        addressBookMap.put(newBookName, new AddressBook());
                        System.out.println("Address Book '" + newBookName + "' created successfully.");
                    }
                    break;
                case 2:
                    System.out.print("Enter the name of the Address Book to access: ");
                    String bookName = scanner.nextLine();
                    if (addressBookMap.containsKey(bookName)) {
                        accessAddressBook(bookName, addressBookMap.get(bookName), scanner);
                    } else {
                        System.out.println("Address Book '" + bookName + "' not found.");
                    }
                    break;
                case 3:
                    if (addressBookMap.isEmpty()) {
                        System.out.println("No Address Books available.");
                    } else {
                        System.out.println("\nAvailable Address Books:");
                        for (String name : addressBookMap.keySet()) {
                            System.out.println("- " + name);
                        }
                    }
                    break;
                case 4:
                    runSystem = false;
                    System.out.println("Exiting Address Book System.");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
        scanner.close();
    }

    public static void accessAddressBook(String name, AddressBook addressBook, Scanner scanner) {
        boolean runBook = true;
        while (runBook) {
            System.out.println("\n--- Address Book: " + name + " ---");
            System.out.println("1. Add Contact");
            System.out.println("2. Add Multiple Contacts");
            System.out.println("3. Edit Contact");
            System.out.println("4. Delete Contact");
            System.out.println("5. Display Contacts");
            System.out.println("6. Return to System Menu");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    addressBook.addContact(scanner);
                    break;
                case 2:
                    addressBook.addMultipleContacts(scanner);
                    break;
                case 3:
                    System.out.print("Enter First Name of contact to edit: ");
                    String editName = scanner.nextLine();
                    addressBook.editContact(editName, scanner);
                    break;
                case 4:
                    System.out.print("Enter First Name of contact to delete: ");
                    String deleteName = scanner.nextLine();
                    addressBook.deleteContact(deleteName);
                    break;
                case 5:
                    addressBook.displayContacts();
                    break;
                case 6:
                    runBook = false;
                    System.out.println("Returning to System Menu.");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
