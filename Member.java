/**
 * Abstract Member class demonstrating Inheritance
 * Base class for different types of library members
 */
public abstract class Member {
    protected String memberId;
    protected String name;
    protected String email;
    
    // Constructor
    public Member(String memberId, String name, String email) {
        this.memberId = memberId;
        this.name = name;
        this.email = email;
    }
    
    // Getters
    public String getMemberId() {
        return memberId;
    }
    
    public String getName() {
        return name;
    }
    
    public String getEmail() {
        return email;
    }
    
    // Setters
    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    // Abstract method to be implemented by subclasses (Polymorphism)
    public abstract String getDisplayInfo();
    
    @Override
    public String toString() {
        return String.format("Member{id='%s', name='%s', email='%s'}",
                memberId, name, email);
    }
}
