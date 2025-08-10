import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Library Management System - Main Library class
 * Demonstrates OOP concepts: Encapsulation, Inheritance, and Polymorphism
 */
public class Library {
    private List<Book> books;
    private List<Member> members;
    private List<Transaction> transactions;
    private Scanner scanner;
    
    public Library() {
        this.books = new ArrayList<>();
        this.members = new ArrayList<>();
        this.transactions = new ArrayList<>();
        this.scanner = new Scanner(System.in);
        initializeSampleData();
    }
    
    private void initializeSampleData() {
        // Add sample books
        addBook(new Book("B001", "To Kill a Mockingbird", "Harper Lee", "Fiction", true));
        addBook(new Book("B002", "1984", "George Orwell", "Dystopian Fiction", true));
        addBook(new Book("B003", "Pride and Prejudice", "Jane Austen", "Romance", true));
        addBook(new Book("B004", "The Great Gatsby", "F. Scott Fitzgerald", "Classic", false));
        addBook(new Book("B005", "Java Programming", "John Smith", "Programming", true));
        
        // Add sample members
        addMember(new Student("M001", "Alice Johnson", "alice@email.com", "S12345"));
        addMember(new Faculty("M002", "Dr. Bob Wilson", "bob@email.com", "Computer Science"));
        addMember(new Student("M003", "Charlie Brown", "charlie@email.com", "S12346"));
    }
    
    public void addBook(Book book) {
        books.add(book);
    }
    
    public void addMember(Member member) {
        members.add(member);
    }
    
    public void displayAllBooks() {
        System.out.println("\n=== ALL BOOKS ===");
        System.out.println(String.format("%-8s %-25s %-20s %-15s %-10s", 
            "Book ID", "Title", "Author", "Category", "Available"));
        System.out.println("-".repeat(80));
        
        for (Book book : books) {
            System.out.println(String.format("%-8s %-25s %-20s %-15s %-10s", 
                book.getBookId(), book.getTitle(), book.getAuthor(), 
                book.getCategory(), book.isAvailable() ? "Yes" : "No"));
        }
    }
    
    public void displayAllMembers() {
        System.out.println("\n=== ALL MEMBERS ===");
        System.out.println(String.format("%-8s %-20s %-25s %-10s %-15s", 
            "Member ID", "Name", "Email", "Type", "Details"));
        System.out.println("-".repeat(85));
        
        for (Member member : members) {
            System.out.println(member.getDisplayInfo());
        }
    }
    
    public void borrowBook() {
        System.out.print("Enter Member ID: ");
        String memberId = scanner.nextLine();
        System.out.print("Enter Book ID: ");
        String bookId = scanner.nextLine();
        
        Member member = findMemberById(memberId);
        Book book = findBookById(bookId);
        
        if (member == null) {
            System.out.println("Member not found!");
            return;
        }
        
        if (book == null) {
            System.out.println("Book not found!");
            return;
        }
        
        if (!book.isAvailable()) {
            System.out.println("Book is already borrowed!");
            return;
        }
        
        book.setAvailable(false);
        Transaction transaction = new Transaction(member, book, "BORROW");
        transactions.add(transaction);
        
        System.out.println("Book borrowed successfully!");
        System.out.println("Transaction ID: " + transaction.getTransactionId());
    }
    
    public void returnBook() {
        System.out.print("Enter Book ID: ");
        String bookId = scanner.nextLine();
        
        Book book = findBookById(bookId);
        if (book == null) {
            System.out.println("Book not found!");
            return;
        }
        
        if (book.isAvailable()) {
            System.out.println("Book is already available!");
            return;
        }
        
        book.setAvailable(true);
        
        // Find the borrow transaction and create return transaction
        for (Transaction transaction : transactions) {
            if (transaction.getBook().getBookId().equals(bookId) && 
                transaction.getType().equals("BORROW")) {
                Transaction returnTransaction = new Transaction(
                    transaction.getMember(), book, "RETURN");
                transactions.add(returnTransaction);
                break;
            }
        }
        
        System.out.println("Book returned successfully!");
    }
    
    public void displayTransactions() {
        System.out.println("\n=== TRANSACTION HISTORY ===");
        System.out.println(String.format("%-15s %-10s %-25s %-25s %-15s %-20s", 
            "Transaction ID", "Type", "Member", "Book", "Date", "Time"));
        System.out.println("-".repeat(110));
        
        for (Transaction transaction : transactions) {
            System.out.println(transaction.getTransactionDetails());
        }
    }
    
    private Member findMemberById(String memberId) {
        for (Member member : members) {
            if (member.getMemberId().equals(memberId)) {
                return member;
            }
        }
        return null;
    }
    
    private Book findBookById(String bookId) {
        for (Book book : books) {
            if (book.getBookId().equals(bookId)) {
                return book;
            }
        }
        return null;
    }
    
    public void displayMenu() {
        System.out.println("\n====== LIBRARY MANAGEMENT SYSTEM ======");
        System.out.println("1. Display All Books");
        System.out.println("2. Display All Members");
        System.out.println("3. Borrow Book");
        System.out.println("4. Return Book");
        System.out.println("5. Display Transaction History");
        System.out.println("6. Exit");
        System.out.print("Choose an option (1-6): ");
    }
    
    public void run() {
        System.out.println("Welcome to the Library Management System!");
        
        while (true) {
            displayMenu();
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline
            
            switch (choice) {
                case 1:
                    displayAllBooks();
                    break;
                case 2:
                    displayAllMembers();
                    break;
                case 3:
                    borrowBook();
                    break;
                case 4:
                    returnBook();
                    break;
                case 5:
                    displayTransactions();
                    break;
                case 6:
                    System.out.println("Thank you for using Library Management System!");
                    return;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }
    
    public static void main(String[] args) {
        Library library = new Library();
        library.run();
    }
}
