package PersonalFinanceTracker;
import java.time.LocalDate;


public class Expense extends Transaction{
    private String paymentMethod;

    public Expense(double amount, LocalDate date, Category category, String paymentMethod) {
        super(amount, TransactionType.EXPENSE, date, category);
        this.paymentMethod = paymentMethod;
    }

    public String getPaymentMethod() { return paymentMethod; }
    public void setPaymentMethod(String paymentMethod) { this.paymentMethod = paymentMethod; }

    @Override
    public String getDetails() {
        return "Expense: $" + getAmount() + " paid via " + paymentMethod + " on " + getDate() + " [" + getCategory() + "]";
    }
}
