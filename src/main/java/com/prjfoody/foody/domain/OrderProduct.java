package com.prjfoody.foody.domain;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class OrderProduct {
    @Id
    @GeneratedValue
    @Column(name = "orderProductId")
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "orderId")
    private Orders order;
    @ManyToOne(fetch = FetchType.LAZY)
    private Product product;

    private int quantity;

    private int realprice;
}
