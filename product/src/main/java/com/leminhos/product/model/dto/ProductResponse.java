package com.leminhos.product.model.dto;

import lombok.*;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class ProductResponse {

    private Long id;
    private String name;
    private String skuCode;
    private BigDecimal price;

}
