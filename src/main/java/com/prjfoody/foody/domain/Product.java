package com.prjfoody.foody.domain;

import com.prjfoody.foody.domain.abstracts.Products;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
public class Product extends Products {
    @Id
    @GeneratedValue
    @Column(name = "productId")
    private Long id;
    private String productImageUrl;

}
