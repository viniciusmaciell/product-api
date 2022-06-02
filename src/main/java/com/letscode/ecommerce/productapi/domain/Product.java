package com.letscode.ecommerce.productapi.domain;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Document(collection = "product")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Product {
    @Id
    private String id;

    private String name;
    private String code;
    private String description;
    private String manufacturer;
    private BigDecimal value;
    private LocalDateTime creationDate;
    private LocalDateTime updateDate;

}