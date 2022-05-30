package com.letscode.ecommerce.productapi.domain;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ProductResponse {

    private String id;
    private String code;
    private String name;
    private String description;
    private String manufacturer;
    private BigDecimal value;

}
