package com.leminhos.product.mapper;

import com.leminhos.product.model.Product;
import com.leminhos.product.model.dto.ProductRequest;
import com.leminhos.product.model.dto.ProductResponse;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class ProductMapper {
    private final ModelMapper mapper;

    public ProductResponse fromProductToProductResponse(Product product){
       return mapper.map(product, ProductResponse.class);
    }

    public List<ProductResponse> fromListProductToListProductResponse(List<Product> products){
        return products.stream()
                .map(product -> fromProductToProductResponse(product))
                .collect(Collectors.toList());

    }
}
