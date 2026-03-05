package com.AM.java_base.infrastructure.repository;
import com.AM.java_base.domain.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository  extends JpaRepository<Category, Integer> {
}
