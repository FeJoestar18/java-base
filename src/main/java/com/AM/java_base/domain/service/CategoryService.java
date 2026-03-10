package com.AM.java_base.domain.service;

import org.springframework.stereotype.Service;
import com.AM.java_base.application.dto.CategoryRequestDTO;
import com.AM.java_base.domain.entities.Category;
import com.AM.java_base.infrastructure.repository.CategoryRepository;

import java.util.List;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public void registerCategory(CategoryRequestDTO dto) {
        var category = Category.builder()
                .name(dto.getName())
                .description(dto.getDescription())
                .build();

        categoryRepository.save(category);
    }

    public void deleteCategoryById(Integer id) {
        categoryRepository.deleteById(id);
    }

    public Category getCategoryById(Integer id) {
        Category category = categoryRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Category not found with id: " + id)
                );

        return category;
    }

    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    public void updateCategoryById(Integer id, CategoryRequestDTO dto) {
        Category category = getCategoryById(id);

        if(dto.getName() != null) {
            category.setName(dto.getName());
        }
        if(dto.getDescription() != null) {
            category.setDescription(dto.getDescription());
        }

    }
}
