package PersonalFinanceTracker;
import java.util.Map;
import java.util.HashMap;


class Budget {
    private double monthlyLimit;
    private Map<Category, Double> categoryLimits;

    public Budget(double monthlyLimit) {
        this.monthlyLimit = monthlyLimit;
        this.categoryLimits = new HashMap<>();
    }

    public void setCategoryLimit(Category category, double limit) {
        categoryLimits.put(category, limit);
    }

    public boolean checkLimit(Transaction t) {
        if(t.getAmount() > monthlyLimit) return false;
        if(categoryLimits.containsKey(t.getCategory()) && t.getAmount() > categoryLimits.get(t.getCategory())) return false;
        return true;
    }

    public double getMonthlyLimit() { return monthlyLimit; }
    public void setMonthlyLimit(double monthlyLimit) { this.monthlyLimit = monthlyLimit; }

    public Map<Category, Double> getCategoryLimits() { return categoryLimits; }
}

