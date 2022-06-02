package com.letscode.ecommerce.productapi.repository;

import com.letscode.ecommerce.productapi.domain.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends MongoRepository<Product, String> {
    boolean existsByNameAndCode(String name, String code);
}
