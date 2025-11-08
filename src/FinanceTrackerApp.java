package PersonalFinanceTracker;
import java.time.LocalDate;


public class FinanceTrackerApp {
    public static void main(String[] args) {
        User user = new User("Simo");

        // Adding transactions
        user.addTransaction(new Income(3000, LocalDate.now(), Category.SALARY, "Job"));
        user.addTransaction(new Expense(200, LocalDate.now(), Category.FOOD, "Cash"));
        user.addTransaction(new Expense(500, LocalDate.now(), Category.RENT, "Card"));

        // View summary
        user.viewSummary();

        // Generate report
        user.generateReport();

        // Sort transactions by amount
        user.sortTransactionsByAmount();
        System.out.println("\nTransactions sorted by amount:");
        user.generateReport();
    }
}
