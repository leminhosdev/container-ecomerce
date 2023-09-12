package com.leminhos.order.controller;

import com.leminhos.order.model.Order;
import com.leminhos.order.model.dto.OrderRequest;
import com.leminhos.order.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/order")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;
    @PostMapping
    public void saveOrder(@RequestBody List<OrderRequest> orderRequestList){

        orderService.saveOrder(orderRequestList);
    }
}
