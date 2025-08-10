# Library Management System (OOP Java)

A comprehensive Java library management system demonstrating core Object-Oriented Programming concepts including **Encapsulation**, **Inheritance**, and **Polymorphism**.

## 📋 Features

- **Book Management**: Add, view, and manage book inventory
- **Member Management**: Handle different types of library members (Students, Faculty)
- **Transaction System**: Track book borrowing and returning
- **Interactive CLI**: User-friendly command-line interface
- **OOP Implementation**: Demonstrates all three pillars of OOP

## 🏗️ Architecture & OOP Concepts

### Encapsulation
- **Book Class**: Private fields with public getters/setters
- **Member Class**: Protected fields for inheritance
- **Transaction Class**: Private transaction details with controlled access

### Inheritance
- **Member** (Abstract base class)
  - **Student** (extends Member)
  - **Faculty** (extends Member)

### Polymorphism
- Abstract method `getDisplayInfo()` implemented differently by Student and Faculty
- Runtime method binding for member-specific display information

## 🚀 How to Compile and Run

### Prerequisites
- Java Development Kit (JDK) 8 or higher
- Command line terminal

### Step 1: Compile the Java Files

```bash
# Navigate to the project directory
cd library-management-oop-java

# Compile all Java files
javac *.java
```

### Step 2: Run the Application

```bash
# Run the main Library class
java Library
```

## 📖 Sample Input/Output

### Application Startup
```
Welcome to the Library Management System!

====== LIBRARY MANAGEMENT SYSTEM ======
1. Display All Books
2. Display All Members
3. Borrow Book
4. Return Book
5. Display Transaction History
6. Exit
Choose an option (1-6): 
```

### Viewing All Books (Option 1)
```
=== ALL BOOKS ===
Book ID  Title                     Author               Category        Available 
--------------------------------------------------------------------------------
B001     To Kill a Mockingbird     Harper Lee           Fiction         Yes       
B002     1984                      George Orwell        Dystopian Fiction Yes       
B003     Pride and Prejudice       Jane Austen          Romance         Yes       
B004     The Great Gatsby          F. Scott Fitzgerald  Classic         No        
B005     Java Programming          John Smith           Programming     Yes  
```

### Viewing All Members (Option 2)
```
=== ALL MEMBERS ===
Member ID Name                 Email                     Type       Details        
-------------------------------------------------------------------------------------
M001     Alice Johnson         alice@email.com           Student    Student ID: S12345
M002     Dr. Bob Wilson        bob@email.com             Faculty    Department: Computer Science
M003     Charlie Brown         charlie@email.com         Student    Student ID: S12346
```

### Borrowing a Book (Option 3)
```
Enter Member ID: M001
Enter Book ID: B002
Book borrowed successfully!
Transaction ID: a3f7b94e
```

### Returning a Book (Option 4)
```
Enter Book ID: B002
Book returned successfully!
```

### Transaction History (Option 5)
```
=== TRANSACTION HISTORY ===
Transaction ID  Type       Member                   Book                     Date            Time            
--------------------------------------------------------------------------------------------------------------
a3f7b94e        BORROW     Alice Johnson            1984                     2025-08-10      18:35:22        
b8f2c15d        RETURN     Alice Johnson            1984                     2025-08-10      18:37:45        
```

## 📁 File Structure

```
library-management-oop-java/
├── Library.java          # Main class with application logic
├── Book.java            # Book entity (Encapsulation demo)
├── Member.java          # Abstract base class (Inheritance)
├── Student.java         # Student member type (Inheritance/Polymorphism)
├── Faculty.java         # Faculty member type (Inheritance/Polymorphism)
├── Transaction.java     # Transaction tracking
├── README.md           # This file
└── LICENSE             # MIT License
```

## 🔧 Key Classes Overview

### Library.java
- **Main application class**
- Contains the user interface and core business logic
- Manages collections of books, members, and transactions
- Demonstrates composition and aggregation

### Book.java
- **Encapsulation example**
- Private fields: bookId, title, author, category, available
- Public getters and setters for controlled access
- toString() method for object representation

### Member.java (Abstract)
- **Inheritance base class**
- Protected fields accessible by subclasses
- Abstract method `getDisplayInfo()` for polymorphism
- Common member properties and methods

### Student.java & Faculty.java
- **Inheritance and Polymorphism examples**
- Extend the Member class
- Override `getDisplayInfo()` with class-specific implementations
- Additional properties specific to each member type

### Transaction.java
- **Transaction tracking system**
- Uses UUID for unique transaction IDs
- LocalDateTime for timestamp management
- Formatted output for transaction history

## 🎯 Learning Objectives

This project demonstrates:

1. **Encapsulation**: Data hiding and controlled access through getters/setters
2. **Inheritance**: Code reuse through class hierarchies (Member → Student/Faculty)
3. **Polymorphism**: Method overriding and runtime method binding
4. **Abstraction**: Abstract classes and methods
5. **Composition**: Library "has-a" relationship with Books, Members, Transactions
6. **Java Collections**: ArrayList usage for dynamic data management
7. **Exception Handling**: Basic error handling and validation
8. **Date/Time Handling**: Modern Java time API usage

## 🐛 Troubleshooting

### Compilation Errors
- Ensure all Java files are in the same directory
- Check Java version: `java -version`
- Verify JAVA_PATH environment variable

### Runtime Issues
- Make sure all .class files are generated after compilation
- Run from the correct directory containing compiled classes

## 📄 License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## 👨‍💻 Author

**rohith-36**
- GitHub: [@rohith-36](https://github.com/rohith-36)

---

*This project was created as a demonstration of Object-Oriented Programming principles in Java.*
