package com.leminhos.stock.controller;

import com.leminhos.stock.service.StockService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/stock")
@RequiredArgsConstructor
public class StockController {
    private final StockService stockService;
    public void save(@RequestParam("skuCode")String skuCode, @RequestParam("balance")Integer balance){
        stockService.save(skuCode, balance);
    }
}
