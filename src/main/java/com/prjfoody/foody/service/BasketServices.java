package com.prjfoody.foody.service;

import com.prjfoody.foody.domain.Basket;
import com.prjfoody.foody.domain.Product;
import com.prjfoody.foody.domain.Users;
import com.prjfoody.foody.modules.Validation;
import com.prjfoody.foody.repository.Repositories;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Qualifier("BasketService")
@Slf4j
public class BasketServices implements Services<Basket> {

    private final Repositories<Basket> repository;
    private final Validation validation;


    public BasketServices(@Qualifier("BasketRepository") Repositories<Basket> repository, Validation validation) {
        this.repository = repository;
        this.validation = validation;
    }

    @Override
    public List<Basket> select(Basket basket, Users user) {
        return repository.select(basket, user);
    }

    @Override
    public Boolean create(Basket basket, Users user) {
        basket.setUser(user);
        return repository.create(basket, user);
    }

    @Override
    public Boolean update(Basket basket, Users user) {
        if(basket != null && basket.getUser() != null && basket.getUser().getId() == user.getId())
            return repository.update(basket, user);
        return false;
    }

    @Override
    public Boolean delete(Long id, Users user) {
        Basket basket = new Basket();
        basket.setId(id);
        List<Basket> selectBasket = select(basket, user);


        if (selectBasket.size() > 0 &&  selectBasket.get(0).getUser().getId() == user.getId())
            return repository.delete(id, user);

        return null;
    }
}
