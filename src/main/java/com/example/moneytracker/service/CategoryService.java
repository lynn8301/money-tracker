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

    public void addCategory(Category newCategory) {
        categoryRepository.save(newCategory);
    }

    public void updateCategory(Long categoryId, Category categoryChange) {
        Category category = categoryRepository.findById(categoryId)
        .orElseThrow(RuntimeException::new);
        if(categoryChange.getName() != null) category.setName(categoryChange.getName());
        if(categoryChange.getType() != null) category.setType(categoryChange.getType());

        categoryRepository.save(category);
    }

    public void deleteById(Long categoryId) {
        categoryRepository.deleteById(categoryId);
    }
}
