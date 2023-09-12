package com.leminhos.order.model.dto;

import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class OrderRequest {
    private String skuCodeProduct;
    private Integer amount;

}
