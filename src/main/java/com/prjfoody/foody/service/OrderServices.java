package com.prjfoody.foody.service;

import com.prjfoody.foody.domain.Orders;
import com.prjfoody.foody.domain.Users;
import com.prjfoody.foody.modules.Validation;
import com.prjfoody.foody.repository.Repositories;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Qualifier("OrderService")
@Slf4j
public class OrderServices implements Services<Orders> {

    private final Repositories<Orders> repository;
    private final Validation validation;

    public OrderServices(@Qualifier("OrderRepository")Repositories<Orders> repository, Validation validation) {
        this.repository=repository;
        this.validation=validation;
    }

    @Override
    public List<Orders> select(Orders orders, Users user) {
        return repository.select(orders, user);
    }

    @Override
    public Boolean create(Orders orders, Users user) {

        if(!validation.validUser(user))
            return false;


        return repository.create(orders, user);
    }

    @Override
    public Boolean update(Orders orders, Users user) {

        if(!validation.validUser(user))
            return false;

        return repository.update(orders, user);
    }

    @Override
    public Boolean delete(Long id, Users user) {

        if(!validation.validUser(user))
            return false;

        return repository.delete(id, user);
    }
}
