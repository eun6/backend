package com.example.springboot.domain.product.repository;


import com.example.springboot.domain.product.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
