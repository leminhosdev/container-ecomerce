package com.leminhos.product.controller;

import com.leminhos.product.model.Product;
import com.leminhos.product.model.dto.ProductDTO;
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
    public void save(@RequestBody Product product){
        productService.save(product);
    }

    @GetMapping
    public List<ProductDTO> findAll(){
        return productService.findAll();
    }
    @DeleteMapping
    public void delete(Long id){
        productService.delete(id);
    }
}
