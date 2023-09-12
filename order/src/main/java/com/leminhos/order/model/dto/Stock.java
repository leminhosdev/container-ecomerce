package com.leminhos.order.model.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Stock {

    private String productSkuCode;
    private Integer amount;
}
