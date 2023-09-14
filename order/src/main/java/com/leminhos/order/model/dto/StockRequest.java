package com.leminhos.order.model.dto;

import lombok.*;

import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class StockRequest {

    private List<String> skuCodeList;
    private List<Stock> stockList;
}
