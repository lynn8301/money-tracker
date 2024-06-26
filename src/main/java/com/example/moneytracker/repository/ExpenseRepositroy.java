package com.example.moneytracker.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.example.moneytracker.model.Expense;

public interface ExpenseRepositroy extends CrudRepository<Expense, Long>{
    List<Expense> findAll();
    Optional<Expense> findById(Long id);
}