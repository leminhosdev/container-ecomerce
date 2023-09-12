package com.leminhos.order.model.dto;



import com.leminhos.order.model.Order;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;


@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class OrderRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String skuCodeProduct;
    private Integer amount;

    @ManyToOne
    private Order order;

}
