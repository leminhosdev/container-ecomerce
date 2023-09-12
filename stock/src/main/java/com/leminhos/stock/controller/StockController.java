package com.leminhos.stock.controller;

import com.leminhos.stock.model.dto.stockResponse;
import com.leminhos.stock.service.StockService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/stock")
@RequiredArgsConstructor
public class StockController {
    private final StockService stockService;
    @PostMapping
    public void save(@RequestParam("skuCode")String skuCode, @RequestParam("amount")Integer amount){
        stockService.save(skuCode, amount);
    }

    @GetMapping
    public stockResponse isInStockOrNot(@RequestParam("skuCode") List<String> skuCode){
       return stockService.isInStockOrNot(skuCode);
    }
}
