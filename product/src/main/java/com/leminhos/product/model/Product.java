package com.leminhos.product.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true)
    private Long id;
    private String name;
    @Column(unique = true)
    private String skuCode;
    private BigDecimal price;


}
