package com.prjfoody.foody.domain;

import com.prjfoody.foody.domain.abstracts.Products;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Product extends Products {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "productId")
    private Long id;
    private String productImageUrl;

}
