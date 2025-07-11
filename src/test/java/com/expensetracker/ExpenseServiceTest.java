package com.expensetracker;

import org.junit.jupiter.api.Test;

import com.expensetracker.model.Expense;
import com.expensetracker.service.ExpenseService;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;

public class ExpenseServiceTest {

    private ExpenseService service;
    private List<Expense> expenses;

    @BeforeEach
    public void setUp() {
        service = new ExpenseService();
        expenses = new ArrayList<>();
        expenses.add(new Expense("Food", 10.0, "Pizza", LocalDate.of(2024, 7, 1)));
        expenses.add(new Expense("Transport", 6.0, "Bus", LocalDate.of(2024, 7, 1)));
        expenses.add(new Expense("Food", 15.0, "Burger", LocalDate.of(2024, 7, 2)));
        expenses.add(new Expense("Entertainment", 20.0, "Movie", LocalDate.of(2024, 7, 3)));
        expenses.add(new Expense("Food", 7.0, "Snack", LocalDate.of(2024, 7, 3)));
    }

    @Test
    public void testGetTotalExpense() {
        double total = service.getTotalExpense(expenses);
        assertEquals(58.0, total, 0.001, "Total expense should be 58.0");
    }

    @Test
    public void testGetTotalExpenseByCategory() {
        Map<String, Double> categoryTotals = service.getTotalExpenseByCategory(expenses);
        assertEquals(32.0, categoryTotals.get("Food"), 0.001);
        assertEquals(6.0, categoryTotals.get("Transport"), 0.001);
        assertEquals(20.0, categoryTotals.get("Entertainment"), 0.001);
    }

    @Test
    public void testGetExpenseByDate() {
        Map<LocalDate, Double> dateTotals = service.getExpenseByDate(expenses);
        assertEquals(16.0, dateTotals.get(LocalDate.of(2024, 7, 1)), 0.001);
        assertEquals(15.0, dateTotals.get(LocalDate.of(2024, 7, 2)), 0.001);
        assertEquals(27.0, dateTotals.get(LocalDate.of(2024, 7, 3)), 0.001);
    }

    @Test
    public void testGetHighestAndLowestSpendCategory() {
        Map<String, String> result = service.getHighestAndLowestSpendCategory(expenses);

        assertEquals("Food", result.get("highest"), "Expected highest spending category to be 'Food'");
        assertEquals("Transport", result.get("lowest"), "Expected lowest spending category to be 'Transport'");
    }

}
