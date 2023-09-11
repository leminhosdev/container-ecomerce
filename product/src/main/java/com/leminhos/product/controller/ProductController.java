package com.leminhos.product.controller;

import com.leminhos.product.model.Product;
import com.leminhos.product.model.dto.ProductRequest;
import com.leminhos.product.model.dto.ProductResponse;
import com.leminhos.product.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/product")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;
    @PostMapping
    public void save(@RequestBody ProductRequest productRequest){
        productService.save(productRequest);
    }
    @GetMapping("/oi")
    public String oi(){
        return "Oi";
    }
    @GetMapping
    public List<ProductResponse> findAll(){
        return productService.findAll();
    }
    @DeleteMapping
    public void delete(@RequestParam("id") Long id){
        productService.delete(id);
    }
}
