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
        return categoryRepository.findbyid(id).orElse(null);
    }

    public Category createCategory(Category cat) {
        return categoryRepository.save(cat);
    }
    public Category updateCategory(Long id, Category cat) {
        Category existing = categoryRepository.findbyid(id)
                .orElseThrow(() -> new RunTimeException("Categoria não foi encontrada."));
        existing.setName(cat.getName());
        existing.setBudget(cat.getBudget());

        return categoryRepository.save(existing);
    }

    public void deleteCategory(Long id) {
        categoryRepository.delete(id);
    }
}