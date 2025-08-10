package com.elevate.library;

import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;

/**
 * Abstract User class demonstrating Inheritance and Polymorphism
 * - Base class for all user types
 * - Provides common functionality and abstract methods
 * - Demonstrates polymorphic behavior
 */
public abstract class User {
    // Protected fields for inheritance (accessible to subclasses)
    protected String userId;
    protected String name;
    protected String email;
    protected List<String> borrowedBookIds;
    protected LocalDate registrationDate;
    
    // Constructor
    public User(String userId, String name, String email) {
        this.userId = validateUserId(userId);
        this.name = validateName(name);
        this.email = validateEmail(email);
        this.borrowedBookIds = new ArrayList<>();
        this.registrationDate = LocalDate.now();
    }
    
    // Getter methods (accessible to all users)
    public String getUserId() {
        return userId;
    }
    
    public String getName() {
        return name;
    }
    
    public String getEmail() {
        return email;
    }
    
    public List<String> getBorrowedBookIds() {
        return new ArrayList<>(borrowedBookIds); // Return copy to maintain encapsulation
    }
    
    public LocalDate getRegistrationDate() {
        return registrationDate;
    }
    
    public int getCurrentBooksCount() {
        return borrowedBookIds.size();
    }
    
    // Abstract methods for polymorphism (must be implemented by subclasses)
    public abstract int getMaxBooksAllowed();
    public abstract int getLoanDuration();
    public abstract String getUserType();
    public abstract double getLateFeeRate();
    
    // Virtual methods that can be overridden by subclasses
    public void displayUserInfo() {
        System.out.println("User ID: " + userId);
        System.out.println("Name: " + name);
        System.out.println("Email: " + email);
        System.out.println("User Type: " + getUserType());
        System.out.println("Registration Date: " + registrationDate);
        System.out.println("Current Books: " + getCurrentBooksCount() + "/" + getMaxBooksAllowed());
    }
    
    // Common business logic methods
    public boolean canBorrowBook() {
        return getCurrentBooksCount() < getMaxBooksAllowed();
    }
    
    public boolean borrowBook(String bookId) {
        if (!canBorrowBook()) {
            return false;
        }
        if (borrowedBookIds.contains(bookId)) {
            return false; // Already borrowed
        }
        borrowedBookIds.add(bookId);
        return true;
    }
    
    public boolean returnBook(String bookId) {
        return borrowedBookIds.remove(bookId);
    }
    
    public boolean hasBorrowedBook(String bookId) {
        return borrowedBookIds.contains(bookId);
    }
    
    // Protected validation methods for subclasses
    protected String validateUserId(String userId) {
        if (userId == null || userId.trim().isEmpty()) {
            throw new IllegalArgumentException("User ID cannot be null or empty");
        }
        return userId.trim().toUpperCase();
    }
    
    protected String validateName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be null or empty");
        }
        return name.trim();
    }
    
    protected String validateEmail(String email) {
        if (email == null || email.trim().isEmpty()) {
            throw new IllegalArgumentException("Email cannot be null or empty");
        }
        // Simple email validation
        String emailPattern = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";
        if (!email.matches(emailPattern)) {
            throw new IllegalArgumentException("Invalid email format");
        }
        return email.trim().toLowerCase();
    }
    
    // Override equals and hashCode
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        User user = (User) obj;
        return userId.equals(user.userId);
    }
    
    @Override
    public int hashCode() {
        return userId.hashCode();
    }
    
    @Override
    public String toString() {
        return String.format("%s{userId='%s', name='%s', email='%s', borrowedBooks=%d}",
                getClass().getSimpleName(), userId, name, email, getCurrentBooksCount());
    }
}

/**
 * Regular User class demonstrating Inheritance
 * - Extends User class
 * - Implements abstract methods with specific behavior
 * - Has limited privileges
 */
class RegularUser extends User {
    private static final int MAX_BOOKS = 3;
    private static final int LOAN_DURATION_DAYS = 14;
    private static final double LATE_FEE_RATE = 0.50; // $0.50 per day
    
    public RegularUser(String userId, String name, String email) {
        super(userId, name, email);
    }
    
    @Override
    public int getMaxBooksAllowed() {
        return MAX_BOOKS;
    }
    
    @Override
    public int getLoanDuration() {
        return LOAN_DURATION_DAYS;
    }
    
    @Override
    public String getUserType() {
        return "Regular User";
    }
    
    @Override
    public double getLateFeeRate() {
        return LATE_FEE_RATE;
    }
    
    @Override
    public void displayUserInfo() {
        super.displayUserInfo();
        System.out.println("Loan Duration: " + getLoanDuration() + " days");
        System.out.println("Late Fee Rate: $" + getLateFeeRate() + " per day");
    }
}

/**
 * Premium User class demonstrating Inheritance and Polymorphism
 * - Extends User class
 * - Implements abstract methods with enhanced behavior
 * - Has additional privileges
 */
class PremiumUser extends User {
    private static final int MAX_BOOKS = 10;
    private static final int LOAN_DURATION_DAYS = 30;
    private static final double LATE_FEE_RATE = 0.25; // $0.25 per day (reduced rate)
    
    private boolean hasRenewalPrivilege;
    private int renewalCount;
    
    public PremiumUser(String userId, String name, String email) {
        super(userId, name, email);
        this.hasRenewalPrivilege = true;
        this.renewalCount = 0;
    }
    
    @Override
    public int getMaxBooksAllowed() {
        return MAX_BOOKS;
    }
    
    @Override
    public int getLoanDuration() {
        return LOAN_DURATION_DAYS;
    }
    
    @Override
    public String getUserType() {
        return "Premium User";
    }
    
    @Override
    public double getLateFeeRate() {
        return LATE_FEE_RATE;
    }
    
    // Additional methods specific to Premium users
    public boolean canRenewBooks() {
        return hasRenewalPrivilege && renewalCount < 2;
    }
    
    public boolean renewBook(String bookId) {
        if (!canRenewBooks() || !hasBorrowedBook(bookId)) {
            return false;
        }
        renewalCount++;
        return true;
    }
    
    public int getRenewalCount() {
        return renewalCount;
    }
    
    @Override
    public void displayUserInfo() {
        super.displayUserInfo();
        System.out.println("Loan Duration: " + getLoanDuration() + " days");
        System.out.println("Late Fee Rate: $" + getLateFeeRate() + " per day");
        System.out.println("Renewal Privilege: " + (hasRenewalPrivilege ? "Yes" : "No"));
        System.out.println("Renewals Used: " + renewalCount + "/2");
    }
    
    // Override toString to include premium-specific info
    @Override
    public String toString() {
        return String.format("%s{userId='%s', name='%s', email='%s', borrowedBooks=%d, renewals=%d}",
                getClass().getSimpleName(), userId, name, email, getCurrentBooksCount(), renewalCount);
    }
}
