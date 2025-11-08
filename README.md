# Personal Finance Tracker

A **console-based Personal Finance Tracker** in Java that helps users manage incomes, expenses, budgets, and generate reports using **full OOP concepts**.

## Features

- Track **Income** and **Expense** transactions with categories.
- Manage **Budgets** and category limits.
- View **transaction reports** in a clean, table-like console output.
- Analyze **total income, total expenses, and category breakdown** using inner classes.
- Implements:
    - **Inheritance & Polymorphism** (`Transaction`, `Income`, `Expense`)
    - **Interfaces** (`Reportable`)
    - **Enums** (`Category`, `TransactionType`)
    - **Encapsulation** (private fields with getters/setters)
    - **Static members** (transaction counter)
    - **Final methods** (`viewSummary()`)
    - **Anonymous classes** for sorting transactions

## Usage

1. Compile all `.java` files in the `src/` folder:

```bash
javac PersonalFinanceTracker/*.java
