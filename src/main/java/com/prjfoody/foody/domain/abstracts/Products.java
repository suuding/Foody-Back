package com.prjfoody.foody.domain.abstracts;

import com.prjfoody.foody.domain.types.Category;
import lombok.Data;

import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
@Data
public abstract class Products extends Stuff {

    private Integer price = 0;
    private Integer salePrice = 0;
    private Float saleRate;
    private Boolean saleStatus;
    private Integer quantity;
    @Enumerated(EnumType.STRING)
    private Category category;
    private Integer grade;

    public void calcSaleRate(){
        if (this.price <= 0 || this.salePrice <= 0)
            return;

        float saleRate =  (float)Math.floor((double) (1 - (float)this.salePrice / (float)this.price) * 100);
        this.setSaleRate(saleRate);

        this.setSaleStatus(saleRate > 0);

    }
}
