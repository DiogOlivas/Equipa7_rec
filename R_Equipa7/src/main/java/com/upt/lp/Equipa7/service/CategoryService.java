package com.upt.lp.Equipa7.service;

import com.upt.lp.Equipa7.DTO.CategoryDTO;
import com.upt.lp.Equipa7.entity.Category;
import com.upt.lp.Equipa7.entity.User;
import com.upt.lp.Equipa7.mapping.CategoryMapper;
import com.upt.lp.Equipa7.repository.CategoryRepository;
import com.upt.lp.Equipa7.repository.UserRepository;

import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;
    private final UserService userService;

    public CategoryService(CategoryRepository categoryRepository, UserService userService) {
        this.categoryRepository = categoryRepository;
        this.userService = userService;
    }

    public List<Category> getAllCategories(){
        return categoryRepository.findAll();
    }

    public Category getCategory(Long id) {
        return categoryRepository.findById(id).orElse(null);
    }

    public Category createCategory(CategoryDTO dto) {

        Category category = CategoryMapper.toEntity(dto);

        User user = userService.getCurrentUser();
        category.setUser(user);

        return categoryRepository.save(category);
    }
    
    public Category updateCategory(Long id, CategoryDTO dto) {
        Category existing = categoryRepository.findById(id)
        		.orElseThrow(() -> new RuntimeException("Category not found."));
        existing.setName(dto.getName());
        existing.setDesc(dto.getDesc());
        existing.setBudget(dto.getBudget());
        //existing.setTransactions(dto.getTransactions());

        return categoryRepository.save(existing);
    }

    public void deleteCategory(Long id) {
        categoryRepository.deleteById(id);
    }
}