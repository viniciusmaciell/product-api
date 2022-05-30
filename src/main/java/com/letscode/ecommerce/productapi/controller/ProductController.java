package com.letscode.ecommerce.productapi.controller;

import com.letscode.ecommerce.productapi.domain.Product;
import com.letscode.ecommerce.productapi.domain.ProductRequest;
import com.letscode.ecommerce.productapi.service.ProductService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/v1/products")
@AllArgsConstructor
@Slf4j
public class ProductController {

    private final ProductService service;

    @PostMapping
    public ResponseEntity<Product> addNewProduct(@RequestBody ProductRequest productRequest) {

        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(productRequest));
    }

    @GetMapping
    public ResponseEntity<Page<Product>> getAll(
            @PageableDefault(page = 0, size = 10, sort = "id", direction = Sort.Direction.ASC) Pageable pageable
    ) {
        return ResponseEntity.status(HttpStatus.OK).body(service.getAll(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getOne(@PathVariable(value = "id") String id) {
        return ResponseEntity.status(HttpStatus.OK).body(service.getById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable(value = "id") String id,
                                                 @RequestBody ProductRequest productRequest) {

        return ResponseEntity.status(HttpStatus.OK).body(service.update(id, productRequest));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable(value = "id") String id) {
        return ResponseEntity.status(HttpStatus.OK).body(service.delete(id));
    }
}
