package com.prjfoody.foody.service;

import com.prjfoody.foody.domain.Product;
import com.prjfoody.foody.domain.Users;
import com.prjfoody.foody.domain.types.UserType;
import com.prjfoody.foody.modules.Validation;
import com.prjfoody.foody.repository.Repositories;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Qualifier("UserService")
@Slf4j
public class UserServices implements Services<Users> {

    private final Repositories<Users> repository;
    private final Validation validation;


    public UserServices(@Qualifier("UserRepository") Repositories<Users> repository, Validation validation) {
        this.repository = repository;
        this.validation = validation;
    }

    @Override
    public List<Users> select(Users users, Users user) {
        return repository.select(users, user);
    }

    @Override
    public Boolean create(Users users, Users user) {
        users.initCreateTime();
        users.setUserType(UserType.NORMAL);

        return repository.create(users, user);
    }

    @Override
    public Boolean update(Users users, Users user) {
        return repository.update(users, user);
    }

    @Override
    public Boolean delete(Long id, Users user) {
        Users targetUser = new Users();
        targetUser.setId(id);

        if(select(targetUser, targetUser).size() > 0)
            return repository.delete(id, user);


        return false;
    }
}
