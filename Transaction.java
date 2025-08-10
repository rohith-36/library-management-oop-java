import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

/**
 * Transaction class for tracking library operations
 */
public class Transaction {
    private String transactionId;
    private Member member;
    private Book book;
    private String type; // BORROW or RETURN
    private LocalDateTime timestamp;
    
    public Transaction(Member member, Book book, String type) {
        this.transactionId = UUID.randomUUID().toString().substring(0, 8);
        this.member = member;
        this.book = book;
        this.type = type;
        this.timestamp = LocalDateTime.now();
    }
    
    // Getters
    public String getTransactionId() {
        return transactionId;
    }
    
    public Member getMember() {
        return member;
    }
    
    public Book getBook() {
        return book;
    }
    
    public String getType() {
        return type;
    }
    
    public LocalDateTime getTimestamp() {
        return timestamp;
    }
    
    public String getTransactionDetails() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return String.format("%-15s %-10s %-25s %-25s %-15s",
                transactionId,
                type,
                member.getName(),
                book.getTitle(),
                timestamp.format(formatter));
    }
    
    @Override
    public String toString() {
        return String.format("Transaction{id='%s', member='%s', book='%s', type='%s', timestamp='%s'}",
                transactionId, member.getName(), book.getTitle(), type, timestamp);
    }
}
