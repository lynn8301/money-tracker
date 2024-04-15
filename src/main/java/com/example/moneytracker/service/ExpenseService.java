package com.example.moneytracker.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.moneytracker.repository.ExpenseRepositroy;
import com.example.moneytracker.model.Expense;

@Service
public class ExpenseService {
    @Autowired
    ExpenseRepositroy expenseRepositroy;

    public List<Expense> gettAllexpnese() {
        return expenseRepositroy.findAll();
    }

    public Optional<Expense> getExpneseById(Long expenseID) {
        return expenseRepositroy.findById(expenseID);
    }
    
    public void addExpense(Expense newExpense) {
        expenseRepositroy.save(newExpense);
    }

    public void updateExpense(Long expneseID, Expense expenseChange) {
        Expense expense = expenseRepositroy.findById(expneseID)
        .orElseThrow(RuntimeException::new);
        if(expenseChange.getAmount() != null) expense.setAmount(expenseChange.getAmount());
        if(expenseChange.getCategory() != null) expense.setCategory(expenseChange.getCategory());
        if(expenseChange.getUser() != null) expense.setCategory(expenseChange.getCategory());

        expenseRepositroy.save(expenseChange);
    }
}
