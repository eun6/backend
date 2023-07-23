package com.example.springboot.domain.product.repository;


import com.example.springboot.domain.product.entity.ProductDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductDetailRepository extends JpaRepository<ProductDetail, Long> {
}
