package com.leminhos.stock.model.dto;

import com.leminhos.stock.model.Stock;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class stockResponse {

    private List<Stock> stockProductList;
    private Boolean isInStock;

}
