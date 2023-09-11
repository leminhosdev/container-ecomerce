package com.leminhos.stock.service;

import com.leminhos.stock.model.Stock;
import com.leminhos.stock.repository.StockRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StockService {

    private final StockRepository stockRepository;

    public void save(String skuCode, Integer balance){
        Stock stock = Stock.builder().balance(balance).productSkuCode(skuCode).build();
        stockRepository.save(stock);
    }
}
