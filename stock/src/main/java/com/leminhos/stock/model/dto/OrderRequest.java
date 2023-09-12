package com.leminhos.stock.model.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class OrderRequest {

    private String skuCodeProduct;
    private Integer amount;
}
