package com.addressbook;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

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
            System.out.println("4. Search Person by City or State");
            System.out.println("5. View Persons by City or State");
            System.out.println("6. Count Persons by City or State");
            System.out.println("7. Exit System");
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
                    searchPersonByCityOrState(addressBookMap, scanner);
                    break;
                case 5:
                    viewPersonsByCityOrState(addressBookMap, scanner);
                    break;
                case 6:
                    countPersonsByCityOrState(addressBookMap, scanner);
                    break;
                case 7:
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

    public static void searchPersonByCityOrState(Map<String, AddressBook> addressBookMap, Scanner scanner) {
        System.out.print("Enter City or State to search in: ");
        String location = scanner.nextLine();
        System.out.print("Enter First Name of the Person to search for: ");
        String name = scanner.nextLine();

        List<Contact> searchResult = addressBookMap.values().stream()
                .flatMap(ab -> ab.getContacts().stream())
                .filter(c -> c.getCity().equalsIgnoreCase(location) || c.getState().equalsIgnoreCase(location))
                .filter(c -> c.getFirstName().equalsIgnoreCase(name))
                .collect(Collectors.toList());

        if (searchResult.isEmpty()) {
            System.out.println("No person found with name '" + name + "' in '" + location + "'.");
        } else {
            System.out.println("\nSearch Results:");
            searchResult.forEach(System.out::println);
        }
    }

    public static void viewPersonsByCityOrState(Map<String, AddressBook> addressBookMap, Scanner scanner) {
        System.out.println("1. View by City\n2. View by State");
        System.out.print("Choose an option: ");
        int choice = scanner.nextInt();
        scanner.nextLine(); // consume newline

        if (choice == 1) {
            Map<String, List<Contact>> cityDictionary = addressBookMap.values().stream()
                    .flatMap(ab -> ab.getContacts().stream())
                    .collect(Collectors.groupingBy(Contact::getCity));
            
            System.out.println("\n--- Persons grouped by City ---");
            if (cityDictionary.isEmpty()) {
                System.out.println("No contacts found.");
            } else {
                cityDictionary.forEach((city, contacts) -> {
                    System.out.println("City: " + city);
                    contacts.forEach(c -> System.out.println("  " + c.getFirstName() + " " + c.getLastName()));
                });
            }
        } else if (choice == 2) {
            Map<String, List<Contact>> stateDictionary = addressBookMap.values().stream()
                    .flatMap(ab -> ab.getContacts().stream())
                    .collect(Collectors.groupingBy(Contact::getState));
            
            System.out.println("\n--- Persons grouped by State ---");
            if (stateDictionary.isEmpty()) {
                System.out.println("No contacts found.");
            } else {
                stateDictionary.forEach((state, contacts) -> {
                    System.out.println("State: " + state);
                    contacts.forEach(c -> System.out.println("  " + c.getFirstName() + " " + c.getLastName()));
                });
            }
        } else {
            System.out.println("Invalid choice.");
        }
    }

    public static void countPersonsByCityOrState(Map<String, AddressBook> addressBookMap, Scanner scanner) {
        System.out.println("1. Count by City\n2. Count by State");
        System.out.print("Choose an option: ");
        int choice = scanner.nextInt();
        scanner.nextLine(); // consume newline

        if (choice == 1) {
            Map<String, Long> cityCount = addressBookMap.values().stream()
                    .flatMap(ab -> ab.getContacts().stream())
                    .collect(Collectors.groupingBy(Contact::getCity, Collectors.counting()));
            
            System.out.println("\n--- Contact Count by City ---");
            if (cityCount.isEmpty()) {
                System.out.println("No contacts found.");
            } else {
                cityCount.forEach((city, count) -> System.out.println(city + ": " + count));
            }
        } else if (choice == 2) {
            Map<String, Long> stateCount = addressBookMap.values().stream()
                    .flatMap(ab -> ab.getContacts().stream())
                    .collect(Collectors.groupingBy(Contact::getState, Collectors.counting()));
            
            System.out.println("\n--- Contact Count by State ---");
            if (stateCount.isEmpty()) {
                System.out.println("No contacts found.");
            } else {
                stateCount.forEach((state, count) -> System.out.println(state + ": " + count));
            }
        } else {
            System.out.println("Invalid choice.");
        }
    }
}
