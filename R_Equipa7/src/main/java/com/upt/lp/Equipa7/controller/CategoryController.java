package com.upt.lp.Equipa7.controller;

import com.upt.lp.Equipa7.entity.Category;
import com.upt.lp.Equipa7.service.CategoryService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/Categories")
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping
    public List<Category> getAll() {
         return categoryService.getAllCategories();
    }

    @GetMapping("/{id}")
    public Category getById(@PathVariable Long id) {
        return categoryService.getCategory(id);
    }

    @PostMapping
    public Category create(@RequestBody Category cat) {
        return categoryService.createCategory(cat);
    }

    @PutMapping("/{id}") 
    public Category update(@PathVariable Long id, @RequestBody Category cat) {
        return categoryService.updateCategory(id, cat);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        categoryService.deleteCategory(id);
    }
}