package com.leminhos.product.mapper;

import com.leminhos.product.model.Product;
import com.leminhos.product.model.dto.ProductDTO;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class ProductMapper {
    private final ModelMapper mapper;

    public ProductDTO fromProductToProductDTO(Product product){
       return mapper.map(product, ProductDTO.class);
    }
    public List<ProductDTO> fromListProductToListProductDTO(List<Product> products){
        return products.stream()
                .map(product -> fromProductToProductDTO(product))
                .collect(Collectors.toList());

    }
}
