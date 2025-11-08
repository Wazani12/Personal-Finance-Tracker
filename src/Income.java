package PersonalFinanceTracker;
import java.time.LocalDate;  // For constructor



public class Income extends Transaction{
    private String source;
    public Income(double amount, LocalDate date, Category category, String source) {
        super(amount, TransactionType.INCOME, date, category);
        this.source = source;
    }

    public String getSource() { return source; }
    public void setSource(String source) { this.source = source; }

    @Override
    public String getDetails() {
        return "Income: $" + getAmount() + " from " + source + " on " + getDate() + " [" + getCategory() + "]";
    }
}
