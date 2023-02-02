package com.prjfoody.foody.domain;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Basket {
    @Id @GeneratedValue
    @Column(name = "basketId")
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userId")
    private Users user;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "productId")
    private Product product;
}
