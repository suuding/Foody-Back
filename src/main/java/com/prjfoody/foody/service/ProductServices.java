package com.prjfoody.foody.service;

import com.prjfoody.foody.domain.Product;
import com.prjfoody.foody.domain.Users;
import com.prjfoody.foody.domain.abstracts.Stuff;
import com.prjfoody.foody.repository.Repositories;
import com.prjfoody.foody.modules.Validation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@Qualifier("ProductService")
@Slf4j
public class ProductServices implements Services<Product>{

    private final Repositories<Product> repository;
    private final Validation validation;


    public ProductServices(@Qualifier("ProductRepository") Repositories<Product> repository, Validation validation) {
        this.repository = repository;
        this.validation = validation;
    }

    @Override
    public List<Product> select(Product product, Users users) {
        // todo: users 가져오기
        log.info("succ : "+product.getId());
        log.info("succ : "+product.getTitle());
        return repository.select(product, users);
    }

    @Override
    public Boolean create(Product product, Users user) {

        product.initStuff(user);
        product.setGrade(0);
        product.setSaleStatus(false);

        product.calcSaleRate();

        return repository.create(product, user);
    }

    @Override
    public Boolean update(Product product, Users user) {
        if(!validation.validUser(user))
            return false;

        if(validation.validOwnStuff(product, user)){
            product.setLastDateTime(LocalDateTime.now());
            product.calcSaleRate();

            return repository.update(product, user);
        }

        return false;
    }

    @Override
    public Boolean delete(Long id, Users user) {

        if(!validation.validUser(user))
            return false;

        Product product = new Product();
        product.setId(id);
        product.setOwner(user);

        if(validation.validOwnStuff(product, user))
            return repository.delete(id, user);

        return false;
    }

}
