package com.leminhos.stock.repository;

import com.leminhos.stock.model.Stock;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface StockRepository extends JpaRepository<Stock, Long> {
    Optional<Stock> findByProductSkuCode(String skuCode);
    List<Stock> findByProductSkuCodeIn(List<String> skuCode);
}
