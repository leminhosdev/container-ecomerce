package com.leminhos.order.model;

import com.leminhos.order.model.dto.OrderRequest;
import com.leminhos.order.model.dto.Stock;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToMany(mappedBy = "order")
    private List<Stock> stockList;
}
