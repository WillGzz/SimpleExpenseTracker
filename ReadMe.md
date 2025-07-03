#  Project: Simple Expense Tracker App

## Background  
This project is a command-line based Java application that allows users to track and manage their daily expenses 
by entering the expense category, amount, item, and purchase date. The core purpose of the app is to calculate overall
 expenses, break them down by category and date, and identify spending patterns.

## Features

- **Add Expense**: Users can input new expenses by category, amount, item, and date.
- **View Total Expenses**: Displays the overall spending.
- **Category Breakdown**: View total expenses by category.
- **Expense Trends**: Summarize how much was spent on different dates.
- **High/Low Spending Categories**: Identifies the categories with the most and least spending.

---

## Design and Architecture

The application follows a clean, layered architecture consisting of:

- **Model Layer**: Defines the data being used (ex: expense class).
- **Service Layer**: Contains the core logic for processing expenses (`ExpenseService`).
- **CLI Layer**: Handles user input/output interactions through the terminal.
- **Test Layer**: Contains unit tests that validate core logic.

This structure promotes code reusability, testability, and clarity.

---

## Technologies Used

### Language:
- Java 17

### Libraries & Tools:
- JUnit 5 (for unit testing)
- Maven (for dependency management and build automation)


## Process to Run, Test, and Verify

### Prerequisites:
- Java 17 or higher
- Maven installed

###  Clone and Build:
```bash
git clone https://github.com/your-username/SimpleExpenseTrackerApp.git
cd SimpleExpenseTrackerApp
mvn compile
```
Run directly from VS Code by pressing the Run button on ExpenseTrackerCLI.java.

 ### Run Unit Tests:

 ```bash

mvn test

```

### Test Data and Seed Data

Test Data is provided in the ExpenseServiceTest.java class to verify core functions using in-memory expenses.

Seed Data can be initialized manually in the CLI by entering example expenses to simulate user input:

"Food", 12.50, "Sandwich", 2024-07-01 (YYYY-MM-DD)

"Transport", 5.00, "Subway", 2022-03-01
