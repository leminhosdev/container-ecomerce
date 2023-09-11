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

    public void save(String skuCode, Integer amount){
        String url = "http://localhost:8080/api/v1/product/productexists?skuCode="+skuCode+"&amount="+amount;
        ResponseEntity<Boolean> responseEntity = restTemplate.getForEntity(url, Boolean.class);
        Boolean responseBody = responseEntity.getBody();
        if(responseBody){
            Stock stockFounded = stockRepository.findByProductSkuCode(skuCode).get();
            Stock stock = Stock.builder()
                    .amount(amount)
                    .productSkuCode(skuCode).build();

            if(stockRepository.findByProductSkuCode(skuCode).isPresent()){
                if(stockFounded.getAmount() == null) {stockFounded.setAmount(0);}
                Integer total = stockFounded.getAmount() + amount;
                stock.setId(stockFounded.getId());
               stock.setAmount(amount);

               stockRepository.save(stock);
           } else {
                stockRepository.save(stock);
            }
        } else {
            throw new IllegalArgumentException("This product skuCode doesn't exists");
        }

    }
}
