package com.example.moneytracker.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.example.moneytracker.model.Expense;
import com.example.moneytracker.model.User;
import com.example.moneytracker.service.ExpenseService;

import jakarta.websocket.server.PathParam;

import org.springframework.web.bind.annotation.GetMapping;



@RestController
@RequestMapping(value = "/api/v1/expense")
public class ExpenseController {
    @Autowired
    ExpenseService expenseService;

    @GetMapping()
    public Iterable<Expense> getAllExpense() {
        return expenseService.gettAllexpnese();
    }

    @GetMapping("/{expneseID}")
    public Optional<Expense> getMethodName(@PathParam("expenseID") Long expenseID) {
        Optional<Expense> result = expenseService.getExpneseById(expenseID);
        if(result.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "This info does not exist");
        }
        return result;
    }
    


}
