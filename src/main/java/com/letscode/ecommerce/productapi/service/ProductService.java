package com.letscode.ecommerce.productapi.service;

import com.letscode.ecommerce.productapi.domain.Product;
import com.letscode.ecommerce.productapi.domain.ProductRequest;
import com.letscode.ecommerce.productapi.repository.ProductRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@Slf4j
@AllArgsConstructor
public class ProductService {

    private final ProductRepository repository;

    public Product save(ProductRequest productRequest) {
        if (!repository.existsByNameAndCode(productRequest.getName(),
                productRequest.getCode())) {
            Product product = new Product();
            BeanUtils.copyProperties(productRequest, product);
            product.setCreationDate(LocalDateTime.now());
            product.setUpdateDate(LocalDateTime.now());
            log.info("Product saved:" + product);
            return repository.save(product);
        }
        throw new RuntimeException("Product already exists");
    }

    public Page<Product> getAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    public Product getById(String id) {
        Optional<Product> productOptional = repository.findById(id);
        return productOptional.orElseThrow(RuntimeException::new);

    }

    public String delete(String id) {
        Optional<Product> productOptional = repository.findById(id);
        var product = productOptional.orElseThrow(RuntimeException::new);
        repository.delete(product);
        log.info("Product with id " + id + " successfully deleted.", id);

        return "Product with id " + id + " successfully deleted.";
    }


    public Product update(String productId, ProductRequest productRequest) {
        Optional<Product> productOptional = repository.findById(productId);
        var product = productOptional.orElseThrow(RuntimeException::new);
        Product productEntity = new Product();

        BeanUtils.copyProperties(productRequest, productEntity);
        productEntity.setId(product.getId());
        productEntity.setManufacturer(product.getManufacturer());
        productEntity.setCreationDate(product.getCreationDate());
        productEntity.setUpdateDate(LocalDateTime.now());

        log.info("Product updated: " + productEntity);

        return repository.save(productEntity);
    }

}

