package com.AM.java_base.controller;

import com.AM.java_base.domain.service.CategoryService;
import com.AM.java_base.application.dto.CategoryRequestDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    private final CategoryService CategoryService;

    public CategoryController(CategoryService CategoryService) {
        this.CategoryService = CategoryService;
    }

    @PostMapping
    public ResponseEntity<Void> registerCategory(@RequestBody CategoryRequestDTO dto) {
        CategoryService.registerCategory(dto);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getCategoryById(@PathVariable Integer id) {
        return ResponseEntity.ok(CategoryService.getCategoryById(id));
    }

    @GetMapping
    public ResponseEntity<?> getAllCategories() {
        return ResponseEntity.ok(CategoryService.getAllCategories());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCategoryById(@PathVariable Integer id) {
        CategoryService.deleteCategoryById(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateCategoryById(@PathVariable Integer id, @RequestBody CategoryRequestDTO dto) {
        CategoryService.updateCategoryById(id, dto);
        return ResponseEntity.ok().build();
    }
}
