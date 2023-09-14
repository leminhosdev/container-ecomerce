package com.leminhos.stock.model.dto;

import com.leminhos.stock.model.Stock;
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
