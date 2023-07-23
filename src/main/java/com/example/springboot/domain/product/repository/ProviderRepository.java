package com.example.springboot.domain.product.repository;


import com.example.springboot.domain.product.entity.Provider;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProviderRepository extends JpaRepository<Provider, Long> {
}
