package com.example.springboot.domain.product.service;


import com.example.springboot.domain.product.dto.ProductReqeustDto.ProductDto;
import com.example.springboot.domain.product.dto.ProductResponseDto.ProductResponseDto;

public interface ProductService {

    ProductResponseDto getProduct(Long number);

    ProductResponseDto saveProduct(ProductDto productDto);

    ProductResponseDto changeProductName(Long number, String name) throws Exception;

    void deleteProduct(Long number) throws Exception;

}