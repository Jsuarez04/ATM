import java.time.LocalDateTime;

public class Account {
    private String accountNumber;
    private User accountHolder;
    private double balance;
    private LocalDateTime creationDate;
    private boolean isActive;
    private double transactionLimit;
    private String accountType;

    public Account(String accountNumber, User accountHolder, double balance, LocalDateTime creationDate, boolean isActive, double transactionLimit, String accountType) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = balance;
        this.creationDate = creationDate;
        this.isActive = isActive;
        this.transactionLimit = transactionLimit;
        this.accountType = accountType;
    }

    public void setAccountHolder(User accountHolder) {
        this.accountHolder = accountHolder;
    }

    public double getBalance() {
        return balance;
    }

    public double getTransactionLimit() {
        return transactionLimit;
    }

    public User getAccountHolder() {
        return accountHolder;
    }

    public boolean isActive() {
        return isActive;
    }

    public boolean withDraw(double amount) {
        //Manejo de errores
        if(!isActive){
            System.out.println("Account is not active");
            return false;
        }
        if (amount<0){
            throw new IllegalArgumentException("Amount must be positive");
        }
        if (amount > transactionLimit){
            System.out.println("Transaction limit exceeded");
            return false;
        }
        if (amount > balance){
            System.out.println("Insufficient balance");
            return false;
        }
        balance -= amount;
        return true;
    }

    public boolean deposit(double amount){
        if(!isActive){
            System.out.println("Account is not active");
            return false;
        }
        if(amount<0){
            throw new IllegalArgumentException("Amount must be positive");
        }
        balance += amount;
        return true;
    }
}
