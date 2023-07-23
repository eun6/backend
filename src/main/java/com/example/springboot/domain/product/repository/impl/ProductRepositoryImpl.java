package com.example.springboot.domain.product.repository.impl;

import com.example.springboot.common.querydsl.Querydsl4RepositorySupport;
import com.example.springboot.domain.product.entity.Product;
import com.example.springboot.domain.product.repository.ProductQuerydslRepository;
import com.example.springboot.domain.product.repository.ProductRepository;

public class ProductRepositoryImpl extends Querydsl4RepositorySupport implements ProductQuerydslRepository {
    public ProductRepositoryImpl() {
        super(Product.class);
    }
}
