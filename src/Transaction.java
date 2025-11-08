package PersonalFinanceTracker;
import java.time.LocalDate;


public abstract class Transaction {
    private double amount;
    private TransactionType type;
    private LocalDate date;
    private Category category;

    private static int transactionCounter = 0;

    public Transaction(double amount, TransactionType type, LocalDate date, Category category) {
        this.amount = amount;
        this.type = type;
        this.date = date;
        this.category = category;
        transactionCounter++;
    }

    public abstract String getDetails();

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public TransactionType getType() {
        return type;
    }

    public void setType(TransactionType type) {
        this.type = type;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public static int getTransactionCounter() {
        return transactionCounter;
    }
}
