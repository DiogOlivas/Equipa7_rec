package com.upt.lp.Equipa7.service;

import com.upt.lp.Equipa7.entity.Category;
import com.upt.lp.Equipa7.repository.CategoryRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<Category> getAllCategories(){
        return categoryRepository.findAll();
    }

    public Category getCategory(Long id) {
        return categoryRepository.findById(id).orElse(null);
    }

    public Category createCategory(Category cat) {
        return categoryRepository.save(cat);
    }
    public Category updateCategory(Long id, Category cat) {
        Category existing = categoryRepository.findById(id)
        		.orElseThrow(() -> new RuntimeException("Category not found."));
        existing.setName(cat.getName());
        existing.setDesc(cat.getDesc());
        existing.setBudget(cat.getBudget());
        existing.setTransactions(cat.getTransactions());

        return categoryRepository.save(existing);
    }

    public void deleteCategory(Long id) {
        categoryRepository.deleteById(id);
    }
}