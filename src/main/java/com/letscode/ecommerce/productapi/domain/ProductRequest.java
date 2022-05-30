package com.letscode.ecommerce.productapi.domain;

import lombok.*;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
public class ProductRequest {

    private String name;
    private String code;
    private String description;
    private String manufacturer;
    private BigDecimal value;

}
