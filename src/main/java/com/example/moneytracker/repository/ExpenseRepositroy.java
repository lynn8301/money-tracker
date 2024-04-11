package com.example.moneytracker.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.example.moneytracker.model.Expense;

public interface ExpenseRepositroy  extends CrudRepository<Expense, Long>{
    List<Expense> findAll();
    Optional<Expense> findById(Long id);
}