package com.addressbook;

public class AddressBookMain {
    public static void main(String[] args) {
        System.out.println("Welcome to Address Book Program");
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        AddressBook addressBook = new AddressBook();

        boolean run = true;
        while (run) {
            System.out.println("\n--- Address Book Menu ---");
            System.out.println("1. Add Contact");
            System.out.println("2. Edit Contact");
            System.out.println("3. Display Contacts");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    addressBook.addContact(scanner);
                    break;
                case 2:
                    System.out.print("Enter First Name of contact to edit: ");
                    String name = scanner.nextLine();
                    addressBook.editContact(name, scanner);
                    break;
                case 3:
                    addressBook.displayContacts();
                    break;
                case 4:
                    run = false;
                    System.out.println("Exiting Address Book.");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

        scanner.close();
    }
}
