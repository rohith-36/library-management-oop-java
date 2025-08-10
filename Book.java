/**
 * Book class demonstrating Encapsulation
 * All fields are private with public getters/setters
 */
public class Book {
    private String bookId;
    private String title;
    private String author;
    private String category;
    private boolean available;
    
    // Constructor
    public Book(String bookId, String title, String author, String category, boolean available) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.category = category;
        this.available = available;
    }
    
    // Getters
    public String getBookId() {
        return bookId;
    }
    
    public String getTitle() {
        return title;
    }
    
    public String getAuthor() {
        return author;
    }
    
    public String getCategory() {
        return category;
    }
    
    public boolean isAvailable() {
        return available;
    }
    
    // Setters
    public void setBookId(String bookId) {
        this.bookId = bookId;
    }
    
    public void setTitle(String title) {
        this.title = title;
    }
    
    public void setAuthor(String author) {
        this.author = author;
    }
    
    public void setCategory(String category) {
        this.category = category;
    }
    
    public void setAvailable(boolean available) {
        this.available = available;
    }
    
    @Override
    public String toString() {
        return String.format("Book{id='%s', title='%s', author='%s', category='%s', available=%s}",
                bookId, title, author, category, available);
    }
}
