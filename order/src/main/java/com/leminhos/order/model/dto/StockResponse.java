package com.leminhos.order.model.dto;

import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class StockResponse {
    private List<Stock> stockProductList;
    private Boolean isInStock;
}
