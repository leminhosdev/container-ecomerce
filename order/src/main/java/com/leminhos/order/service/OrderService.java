package com.leminhos.order.service;

import com.leminhos.order.model.dto.OrderRequest;
import com.leminhos.order.model.dto.StockResponse;
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
public class OrderService {
    private final RestTemplate restTemplate;
    public void saveOrder(List<OrderRequest> orderRequestList) {
        List<String> skuCodeList = makeStringList(orderRequestList);
        String skuCodesAsString = String.join(",", skuCodeList);
        String url = "http://localhost:8081/api/v1/stock?skuCodeList="+ skuCodesAsString;
        ResponseEntity<StockResponse> responseEntity = restTemplate.getForEntity(url, StockResponse.class);
        StockResponse responseBody = responseEntity.getBody();
        log.info(responseBody.getIsInStock());
    }
    private List<String> makeStringList(List<OrderRequest> orderRequestList){
        List<String> skuCodeList = orderRequestList.stream()
                .map(orderRequest -> orderRequest.getSkuCodeProduct()).collect(Collectors.toList());

        return skuCodeList;
    }
}
