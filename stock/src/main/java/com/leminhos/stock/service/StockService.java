package com.leminhos.stock.service;

import com.leminhos.stock.model.Stock;
import com.leminhos.stock.repository.StockRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
@Log4j2
public class StockService {
    private final RestTemplate restTemplate;

    private final StockRepository stockRepository;

    public void save(String skuCode, Integer balance){
        String url = "http://localhost:8080/api/v1/product/oi";
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(url, String.class);
        String responseBody = responseEntity.getBody();
        log.info(responseBody);
        // Stock stock = Stock.builder().balance(balance).productSkuCode(skuCode).build();
       // stockRepository.save(stock);

    }
}
