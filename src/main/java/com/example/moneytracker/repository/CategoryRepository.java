package com.example.moneytracker.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.example.moneytracker.model.Category;

public interface CategoryRepository extends CrudRepository<Category, Long> {
    List<Category> findAll();
    Optional<Category> findById(Long id);
    Optional<Category> findByName(String categortName);

    @Modifying
    @Query("delete from Category where id = :id")
    void deleteById(@Param("id") Long id);
}