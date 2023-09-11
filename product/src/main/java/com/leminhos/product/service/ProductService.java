package com.leminhos.product.service;

import com.leminhos.product.mapper.ProductMapper;
import com.leminhos.product.model.Product;
import com.leminhos.product.model.dto.ProductDTO;
import com.leminhos.product.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;


    public void save(Product product) {
        productRepository.save(product);
    }

    public List<ProductDTO> findAll(){
        List<Product> products = productRepository.findAll();
        return productMapper.fromListProductToListProductDTO(products);
    }
    public void delete(Long id) {
        productRepository.deleteById(id);
    }

}
