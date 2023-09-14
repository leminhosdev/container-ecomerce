package com.leminhos.order.model.dto;

import com.leminhos.order.model.Order;
import jakarta.persistence.*;
import lombok.*;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity
public class Stock {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String productSkuCode;
    private Integer amount;
    @ManyToOne
    private Order order;

}
