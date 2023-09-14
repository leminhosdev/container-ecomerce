package com.leminhos.stock.service;

import com.leminhos.stock.model.Stock;

import com.leminhos.stock.model.dto.StockRequest;
import com.leminhos.stock.model.dto.stockResponse;
import com.leminhos.stock.repository.StockRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Log4j2
public class StockService {
    private final RestTemplate restTemplate;

    private final StockRepository stockRepository;

    public void save(String skuCode, Integer amount){
        String url = "http://localhost:8080/api/v1/product/productexists?skuCode=" + skuCode + "&amount=" + amount;
        ResponseEntity<Boolean> responseEntity = restTemplate.getForEntity(url, Boolean.class);
        Boolean responseBody = responseEntity.getBody();
        if (responseBody) {
            Stock stockFounded = stockRepository.findByProductSkuCode(skuCode)
                    .orElse(Stock.builder().productSkuCode(skuCode).amount(0).build());

            Integer existingAmount = stockFounded.getAmount();
            if (existingAmount == null) {
                existingAmount = 0;
            }

            Integer total = existingAmount + amount;
            stockFounded.setAmount(total);

            stockRepository.save(stockFounded);
        } else {
            throw new IllegalArgumentException("This product skuCode doesn't exist");
        }

    }

    public stockResponse isInStockOrNot(List<String> skuCodeList) {

        List<Stock> byProductSkuCodeIn = stockRepository.findByProductSkuCodeIn(skuCodeList);

        stockResponse stockcheck = stockResponse.builder()
                .isInStock(false)
                .stockProductList(byProductSkuCodeIn)
                .build();

        if(skuCodeList.size() == byProductSkuCodeIn.size()){
            stockcheck.setIsInStock(true);
            return stockcheck;
        } else {
            throw new IllegalStateException("Does not have enough stock");
        }


    }


}
