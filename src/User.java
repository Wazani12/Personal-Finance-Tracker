package PersonalFinanceTracker;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.Collections;
import java.util.Comparator;



public class User implements Reportable{
    private String name;
    private ArrayList<Transaction> transactions;

    public User(String name) {
        this.name = name;
        this.transactions = new ArrayList<>();
    }

    public void addTransaction(Transaction t) {
        transactions.add(t);
    }

    public void removeTransaction(Transaction t) {
        transactions.remove(t);
    }

    public final void viewSummary() {
        Analytics analytics = new Analytics();
        System.out.println("Total Income: $" + analytics.totalIncome());
        System.out.println("Total Expenses: $" + analytics.totalExpenses());
        System.out.println("Category Breakdown: " + analytics.breakdownByCategory());
    }

    // ===== INNER CLASS =====
    class Analytics {
        public double totalIncome() {
            double total = 0;
            for(Transaction t : transactions) {
                if(t.getType() == TransactionType.INCOME) total += t.getAmount();
            }
            return total;
        }

        public double totalExpenses() {
            double total = 0;
            for(Transaction t : transactions) {
                if(t.getType() == TransactionType.EXPENSE) total += t.getAmount();
            }
            return total;
        }

        public Map<Category, Double> breakdownByCategory() {
            Map<Category, Double> breakdown = new HashMap<>();
            for(Transaction t : transactions) {
                breakdown.put(t.getCategory(), breakdown.getOrDefault(t.getCategory(), 0.0) + t.getAmount());
            }
            return breakdown;
        }
    }


    // ===== IMPLEMENT INTERFACE =====
    @Override
    public void generateReport() {
        System.out.println("==================================================");
        System.out.println("             Transactions Report for " + name);
        System.out.println("==================================================");
        System.out.printf("%-10s | %-8s | %-10s | %-12s | %-20s%n",
                "Type", "Amount", "Date", "Category", "Details");
        System.out.println("--------------------------------------------------");

        for(Transaction t : transactions) {
            String details = "";
            if(t instanceof Income) {
                details = ((Income) t).getSource();
            } else if(t instanceof Expense) {
                details = ((Expense) t).getPaymentMethod();
            }

            System.out.printf("%-10s | $%-7.2f | %-10s | %-12s | %-20s%n",
                    t.getType(), t.getAmount(), t.getDate(), t.getCategory(), details);
        }

        System.out.println("--------------------------------------------------");

        Analytics analytics = new Analytics();
        System.out.printf("Total Income: $%.2f%n", analytics.totalIncome());
        System.out.printf("Total Expenses: $%.2f%n", analytics.totalExpenses());

        System.out.println("==================================================");
    }


    // ===== ANONYMOUS CLASS EXAMPLE =====
    public void sortTransactionsByAmount() {
        Collections.sort(transactions, new Comparator<Transaction>() {
            @Override
            public int compare(Transaction t1, Transaction t2) {
                return Double.compare(t1.getAmount(), t2.getAmount());
            }
        });
    }
}
