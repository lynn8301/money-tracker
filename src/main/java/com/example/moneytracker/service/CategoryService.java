package com.example.moneytracker.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.moneytracker.model.Category;
import com.example.moneytracker.repository.CategoryRepository;

@Service
public class CategoryService {
    @Autowired
    CategoryRepository categoryRepository;

    public List<Category> getAllGategory(){
        return categoryRepository.findAll();
    }

    public Optional<Category> getCategoryById(Long categoryId){
        return categoryRepository.findById(categoryId);
    }

    public Optional<Category> getCategoryByName(String categoryName) {
        return categoryRepository.findByName(categoryName);

    }
}
