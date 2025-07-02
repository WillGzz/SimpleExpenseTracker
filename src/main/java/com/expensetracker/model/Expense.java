package com.expensetracker.model;

import java.time.LocalDate;

public class Expense {
    
    private String category;
    private double amount;
    private String item;
    private LocalDate date;
    
    public String getCategory() {
        return category;
    }
    public void setCategory(String category) {
        this.category = category;
    }
    public double getAmount() {
        return amount;
    }
    public void setAmount(double amount) {
        this.amount = amount;
    }
    public String getItem() {
        return item;
    }
    public void setItem(String item) {
        this.item = item;
    }
    public LocalDate getDate() {
        return date;
    }
    public void setDate(LocalDate date) {
        this.date = date;
    }
    @Override
    public String toString() {
        return "Expense [category=" + getCategory() + ", amount=" + getAmount() + ", item=" + item + ", date=" + date + "]";
    }

  
    

}
