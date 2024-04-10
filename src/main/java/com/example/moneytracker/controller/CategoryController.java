package com.example.moneytracker.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.example.moneytracker.model.Category;
import com.example.moneytracker.service.CategoryService;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@RequestMapping(value = "/api/v1/category")
public class CategoryController {
    @Autowired
    CategoryService categoryService;
    
    @GetMapping()
    public Iterable<Category> getAllGategory() {
        return categoryService.getAllGategory();
    }

    @GetMapping("/{categoryID}")
    public Optional<Category> getCategoryById(@PathVariable("categoryID") Long categoryID) {
        Optional<Category> result = categoryService.getCategoryById(categoryID);
        if(result.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "This category does not exist");
        }
        return result;
    }

    @GetMapping("")
    public Optional<Category> getCategoryByNmae(@RequestParam String categoryName) {
        Optional<Category> result = categoryService.getCategoryByName(categoryName);
        if(result.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "This category does not exist");
        }
        return result;
    }

    @PostMapping()
    public String addCategory(@RequestBody String entity) {
        //TODO: process POST request
        
        return entity;
    }

    @PutMapping("/{categoryID}")
    public String updateCategory(@PathVariable String id, @RequestBody String entity) {
        //TODO: process PUT request
        
        return entity;
    }
    
    @DeleteMapping("/{categoryId}")
    public void deleteCategoryById() {
    }

    @DeleteMapping("/{categoryName}")
    public void deleteCategoryByName() {
    }
    
}
