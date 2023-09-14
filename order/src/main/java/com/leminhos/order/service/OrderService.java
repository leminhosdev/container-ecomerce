package com.leminhos.order.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.leminhos.order.model.Order;
import com.leminhos.order.model.dto.OrderRequest;
import com.leminhos.order.model.dto.Stock;
import com.leminhos.order.model.dto.StockRequest;
import com.leminhos.order.model.dto.StockResponse;
import com.leminhos.order.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Log4j2
public class OrderService {
    private final RestTemplate restTemplate;
    private final OrderRepository orderRepository;
    public void saveOrder(List<Stock> stockList) {
        List<String> skuCodeList = makeStringList(stockList);

        //StockRequest stockRequest = new StockRequest(skuCodeList, stockList);
        String skuCodesAsString = String.join(",", skuCodeList);
        String url = "http://localhost:8081/api/v1/stock?skuCodeList="+ skuCodesAsString;
        ResponseEntity<StockResponse> responseEntity = restTemplate.getForEntity(url, StockResponse.class);
        StockResponse responseBody = responseEntity.getBody();
        log.info(responseBody.getIsInStock());
        List<Stock> stockProductList = responseBody.getStockProductList();


        Map<String, Integer> stockMap = stockProductList.stream()
                .collect(Collectors.toMap(Stock::getProductSkuCode, Stock::getAmount));


        for (Stock stock : stockList) {
            String productSkuCode = stock.getProductSkuCode();
            int amountLista1 = stock.getAmount();
            Integer amountLista2 = stockMap.get(productSkuCode);

            if (amountLista2 != null && amountLista1 > amountLista2) {
                throw new IllegalStateException("the product "+ productSkuCode+ " Does not have enough stock");
            }

        }
        Order order = Order.builder().stockList(stockList).build();
        orderRepository.save(order);
    }
    private List<String> makeStringList(List<Stock> stockList){
        List<String> skuCodeList = stockList.stream()
                .map(stock -> stock.getProductSkuCode()).collect(Collectors.toList());

        return skuCodeList;
    }

}
