package com.AM.java_base.controller;

import com.AM.java_base.domain.service.ProductService;
import com.AM.java_base.application.dto.ProductRequestDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    public ResponseEntity<Void> registerProduct(@RequestBody ProductRequestDTO dto) {
        productService.registerProduct(dto);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getProductById(@PathVariable  Integer id) {
        return ResponseEntity.ok(productService.getProduct(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateProductById(@PathVariable Integer id, @RequestBody ProductRequestDTO dto) {
        productService.updateProductById(id, dto);
        return ResponseEntity.ok().build();
    }
}
