package com.example.moneytracker.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
