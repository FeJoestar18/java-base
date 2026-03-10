package com.AM.java_base.domain.service;

import com.AM.java_base.application.dto.ProductRequestDTO;
import com.AM.java_base.domain.entities.Product;
import com.AM.java_base.infrastructure.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public void registerProduct(ProductRequestDTO dto) {
        var product = com.AM.java_base.domain.entities.Product.builder()
                .name(dto.getName())
                .description(dto.getDescription())
                .price(dto.getPrice())
                .build();

        productRepository.save(product);
    }

    public void deleteProductById(Integer id) {
        productRepository.deleteById(id);
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product getProduct(Integer id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Product not found with id: " + id)
                );

        return product;
    }

    public void updateProductById(Integer id, ProductRequestDTO dto) {
        Product product = getProduct(id);

        if(dto.getName() != null) {
            product.setName(dto.getName());
        }
        if(dto.getDescription() != null) {
            product.setDescription(dto.getDescription());
        }
        if(dto.getPrice() != null) {
            product.setPrice(dto.getPrice());
        }

    }
}
