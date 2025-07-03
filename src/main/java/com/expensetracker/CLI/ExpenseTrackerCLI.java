package com.expensetracker.CLI;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.expensetracker.model.Expense;
import com.expensetracker.service.ExpenseService;

public class ExpenseTrackerCLI {

    
    private static final ExpenseService expenseService = new ExpenseService();
    private static final List<Expense> expenses = new ArrayList<>();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
      
        System.out.println("Welcome to the Expense Tracker and Management CLI!");

        boolean running = true;
        while (running) {
            System.out.println("Choose a option:");
            System.out.println("1. Add Expense");
            System.out.println("2. Show Total Expense");
            System.out.println("3. Show Expense by Category");
            System.out.println("4. Show Expense Trend");
            System.out.println("5. Show Highest & Lowest Spending Categories");
            System.out.println("6. Exit");

            String userInput = scanner.nextLine();
            switch (userInput) {
                case "1":
                    addExpense();
                    break;
                case "2":
                    System.out.println("Total Expense: $" + expenseService.getTotalExpense(expenses));
                    break;
                case "3":
                    printCategoryTotals(expenseService.getTotalExpenseByCategory(expenses));
                    break;
                case "4":
                    printTrend(expenseService.getExpenseByDate(expenses));
                    break;
                case "5":
                    printHighLow(expenseService.getHighestAndLowestSpendCategory(expenses));
                    break;
                case "6":
                    running = false;
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void addExpense() {
        System.out.print("Enter category: ");
        String category = scanner.nextLine();

        System.out.print("Enter item: ");
        String item = scanner.nextLine();

        System.out.print("Enter amount: ");
        double amount = Double.parseDouble(scanner.nextLine());

        System.out.print("Enter date (YYYY-MM-DD): ");
        LocalDate date = LocalDate.parse(scanner.nextLine());

        expenses.add(new Expense(category, amount, item, date));
        System.out.println("Expense added!");
    }

    private static void printCategoryTotals(Map<String, Double> totals) {
        System.out.println("Expense by Category:");
        for (Map.Entry<String, Double> entry : totals.entrySet()) {
            System.out.println(entry.getKey() + ": $" + entry.getValue());
        }
    }

    private static void printTrend(Map<LocalDate, Double> trend) {
        System.out.println("Expense Trend by Date:");
        for (Map.Entry<LocalDate, Double> entry : trend.entrySet()) {
            System.out.println(entry.getKey() + ": $" + entry.getValue());
        }
    }

    private static void printHighLow(Map<String, String> result) {
        System.out.println("Highest Spend Category: " + result.get("highest"));
        System.out.println("Lowest Spend Category: " + result.get("lowest"));
    }

}

