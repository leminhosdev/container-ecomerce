package com.leminhos.stock.controller;

import com.leminhos.stock.service.StockService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/stock")
@RequiredArgsConstructor
public class StockController {
    private final StockService stockService;
    @PostMapping
    public void save(@RequestParam("skuCode")String skuCode, @RequestParam("balance")Integer balance){
        stockService.save(skuCode, balance);
    }
}
