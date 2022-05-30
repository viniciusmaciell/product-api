package com.letscode.ecommerce.productapi.repository;

import com.letscode.ecommerce.productapi.domain.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepository extends MongoRepository<Product, String> {
    boolean existsByNameAndCode(String name, String code);
}
