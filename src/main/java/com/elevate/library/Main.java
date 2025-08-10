package com.elevate.library;

import java.time.LocalDate;
import java.util.Scanner;

/**
 * Main class to demonstrate the Library Management System
 * Showcases OOP principles: Encapsulation, Inheritance, and Polymorphism
 */
public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static Library library = new Library();

    public static void main(String[] args) {
        System.out.println("=== Welcome to Library Management System ===");
        System.out.println("This system demonstrates OOP concepts:");
        System.out.println("1. Encapsulation - Data hiding and access control");
        System.out.println("2. Inheritance - RegularUser and PremiumUser extend User");
        System.out.println("3. Polymorphism - Different user types behave differently\n");
        
        // Initialize with sample data
        initializeSampleData();
        
        // Main menu loop
        boolean running = true;
        while (running) {
            displayMenu();
            int choice = getChoice();
            
            switch (choice) {
                case 1:
                    displayAllBooks();
                    break;
                case 2:
                    issueBook();
                    break;
                case 3:
                    returnBook();
                    break;
                case 4:
                    displayAllUsers();
                    break;
                case 5:
                    addNewBook();
                    break;
                case 6:
                    addNewUser();
                    break;
                case 7:
                    demonstratePolymorphism();
                    break;
                case 8:
                    running = false;
                    System.out.println("Thank you for using the Library Management System!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
            
            if (running) {
                System.out.println("\nPress Enter to continue...");
                scanner.nextLine();
            }
        }
        
        scanner.close();
    }
    
    private static void initializeSampleData() {
        // Adding sample books
        library.addBook(new Book("B001", "The Great Gatsby", "F. Scott Fitzgerald"));
        library.addBook(new Book("B002", "To Kill a Mockingbird", "Harper Lee"));
        library.addBook(new Book("B003", "1984", "George Orwell"));
        library.addBook(new Book("B004", "Pride and Prejudice", "Jane Austen"));
        library.addBook(new Book("B005", "The Catcher in the Rye", "J.D. Salinger"));
        
        // Adding sample users
        library.addUser(new RegularUser("U001", "Alice Johnson", "alice@email.com"));
        library.addUser(new PremiumUser("U002", "Bob Smith", "bob@email.com"));
        library.addUser(new RegularUser("U003", "Carol Davis", "carol@email.com"));
        library.addUser(new PremiumUser("U004", "David Wilson", "david@email.com"));
        
        System.out.println("Sample data initialized successfully!");
    }
    
    private static void displayMenu() {
        System.out.println("\n=== Library Management System Menu ===");
        System.out.println("1. Display All Books");
        System.out.println("2. Issue Book");
        System.out.println("3. Return Book");
        System.out.println("4. Display All Users");
        System.out.println("5. Add New Book");
        System.out.println("6. Add New User");
        System.out.println("7. Demonstrate Polymorphism");
        System.out.println("8. Exit");
        System.out.print("Enter your choice (1-8): ");
    }
    
    private static int getChoice() {
        try {
            int choice = Integer.parseInt(scanner.nextLine());
            return choice;
        } catch (NumberFormatException e) {
            return -1;
        }
    }
    
    private static void displayAllBooks() {
        System.out.println("\n=== All Books ===");
        library.displayAllBooks();
    }
    
    private static void issueBook() {
        System.out.println("\n=== Issue Book ===");
        System.out.print("Enter Book ID: ");
        String bookId = scanner.nextLine();
        System.out.print("Enter User ID: ");
        String userId = scanner.nextLine();
        
        library.issueBook(bookId, userId);
    }
    
    private static void returnBook() {
        System.out.println("\n=== Return Book ===");
        System.out.print("Enter Book ID: ");
        String bookId = scanner.nextLine();
        System.out.print("Enter User ID: ");
        String userId = scanner.nextLine();
        
        library.returnBook(bookId, userId);
    }
    
    private static void displayAllUsers() {
        System.out.println("\n=== All Users ===");
        library.displayAllUsers();
    }
    
    private static void addNewBook() {
        System.out.println("\n=== Add New Book ===");
        System.out.print("Enter Book ID: ");
        String bookId = scanner.nextLine();
        System.out.print("Enter Title: ");
        String title = scanner.nextLine();
        System.out.print("Enter Author: ");
        String author = scanner.nextLine();
        
        Book newBook = new Book(bookId, title, author);
        library.addBook(newBook);
        System.out.println("Book added successfully!");
    }
    
    private static void addNewUser() {
        System.out.println("\n=== Add New User ===");
        System.out.print("Enter User ID: ");
        String userId = scanner.nextLine();
        System.out.print("Enter Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Email: ");
        String email = scanner.nextLine();
        System.out.print("Is this a premium user? (y/n): ");
        String isPremium = scanner.nextLine().toLowerCase();
        
        User newUser;
        if (isPremium.equals("y") || isPremium.equals("yes")) {
            newUser = new PremiumUser(userId, name, email);
        } else {
            newUser = new RegularUser(userId, name, email);
        }
        
        library.addUser(newUser);
        System.out.println("User added successfully!");
    }
    
    private static void demonstratePolymorphism() {
        System.out.println("\n=== Demonstrating Polymorphism ===");
        System.out.println("\nShowing how different user types behave differently:");
        
        // Get users to demonstrate polymorphism
        User regularUser = library.findUser("U001");
        User premiumUser = library.findUser("U002");
        
        if (regularUser != null && premiumUser != null) {
            System.out.println("\n1. Regular User Info:");
            regularUser.displayUserInfo();
            System.out.println("   Max books allowed: " + regularUser.getMaxBooksAllowed());
            System.out.println("   Loan duration: " + regularUser.getLoanDuration() + " days");
            
            System.out.println("\n2. Premium User Info:");
            premiumUser.displayUserInfo();
            System.out.println("   Max books allowed: " + premiumUser.getMaxBooksAllowed());
            System.out.println("   Loan duration: " + premiumUser.getLoanDuration() + " days");
            
            System.out.println("\n3. Polymorphic behavior demonstration:");
            System.out.println("   Same method call, different behaviors based on user type!");
        } else {
            System.out.println("Sample users not found. Please ensure sample data is initialized.");
        }
    }
}
