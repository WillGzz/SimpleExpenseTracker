package com.expensetracker.service;
import java.util.List;
import java.util.Map;
import java.time.LocalDate;
import java.util.HashMap;

import com.expensetracker.model.Expense;

public class ExpenseService {
   

public double getTotalExpense (List<Expense> expenses){

    double total = 0;
    for (Expense expense : expenses){
    
        total += expense.getAmount();
    }
  
    return total;

}

public Map<String, Double> getTotalExpenseByCategory(List<Expense> expenses){
     HashMap<String, Double> totalByCategory = new HashMap<String, Double>();
     for (int i = 0; i < expenses.size(); i++){

         String category = expenses.get(i).getCategory();
         Double expenseAmount = expenses.get(i).getAmount();

        if (totalByCategory.containsKey(category)){
            totalByCategory.put(category, totalByCategory.get(category) + expenseAmount);
        }
        else{
            totalByCategory.put(category, expenseAmount);
        }
         
     }   

    return totalByCategory;
}


public Map<LocalDate, Double> getExpenseByDate(List<Expense> expenses){

     HashMap<LocalDate, Double> totalByDate = new HashMap<LocalDate, Double>();
     for (int i = 0; i < expenses.size(); i++){

         LocalDate date = expenses.get(i).getDate();
         Double expenseAmount = expenses.get(i).getAmount();

        if (totalByDate.containsKey(date)){
            totalByDate.put(date, totalByDate.get(date) + expenseAmount);
        }
        else{
            totalByDate.put(date, expenseAmount);
        }
         
     }   

    return totalByDate;
}


public Map<String, String> getHighestAndLowestSpendCategory(List<Expense> expenses) {
    Map<String, Double> totals = getTotalExpenseByCategory(expenses);

    String highest = null, lowest = null;
    double max = Double.MIN_VALUE, min = Double.MAX_VALUE;

    for (Map.Entry<String, Double> entry : totals.entrySet()) {
        double value = entry.getValue();
        if (value > max) {
            max = value;
            highest = entry.getKey();
        }
        if (value < min) {
            min = value;
            lowest = entry.getKey();
        }
    }
    Map<String, String> result = new HashMap<>();
    result.put("highest", highest);
    result.put("lowest", lowest);
    return result;
 
}


}
