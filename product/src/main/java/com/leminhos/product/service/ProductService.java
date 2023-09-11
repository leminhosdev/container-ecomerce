package com.leminhos.product.service;

import com.leminhos.product.mapper.ProductMapper;
import com.leminhos.product.model.Product;
import com.leminhos.product.model.dto.ProductRequest;
import com.leminhos.product.model.dto.ProductResponse;
import com.leminhos.product.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;


    public void save(ProductRequest productRequest)  {

        Product productFinded = productRepository.findBySkuCode(productRequest.getSkuCode()).get();
        if(productFinded == null){
            Product product = Product.builder()
                    .name(productRequest.getName())
                    .price(productRequest.getPrice())
                    .skuCode(productRequest.getSkuCode())
                    .build();

            productRepository.save(product);
        } else if (productFinded != null && productRequest.getName().equals(productFinded.getName())
                && productFinded.getPrice().compareTo(productRequest.getPrice()) != 0) {
            Product product = Product.builder()
                    .id(productFinded.getId())
                    .name(productRequest.getName())
                    .price(productRequest.getPrice())
                    .skuCode(productRequest.getSkuCode())
                    .build();

            productRepository.save(product);
        } else {
        throw new IllegalArgumentException("Failed saving product");
        }


    }

    public List<ProductResponse> findAll(){
        List<Product> products = productRepository.findAll();
        return productMapper.fromListProductToListProductResponse(products);
    }
    public void delete(Long id) {
        productRepository.deleteById(id);
    }

}
