package com.prjfoody.foody.service;

import com.prjfoody.foody.domain.Mtm;
import com.prjfoody.foody.domain.Users;
import com.prjfoody.foody.modules.Validation;
import com.prjfoody.foody.repository.Repositories;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Qualifier("MtmService")
@Slf4j
public class MtmServices implements Services<Mtm> {

    private final Repositories<Mtm> repository;
    private final Validation validation;

    public MtmServices(@Qualifier("MtmRepository") Repositories<Mtm> repository, Validation validation) {
        this.repository = repository;
        this.validation = validation;
    }

    @Override
    public List<Mtm> select(Mtm mtm, Users users) {

        return repository.select(mtm, users);
    }

    @Override
    public Boolean create(Mtm mtm, Users user) {

        mtm.initStuff(user);
        System.out.println(mtm.getTitle());
        System.out.println(mtm.getContent());
        
        return repository.create(mtm, user);
    }

    @Override
    public Boolean update(Mtm mtm, Users user) {
        if(!validation.validUser(user))
            return false;

        //작성자만 수정 가능
        if(validation.validOwnStuff(mtm, user)) {
            mtm.setLastDateTime(LocalDateTime.now());

            return repository.update(mtm, user);
        }
        return false;
    }

    @Override
    public Boolean delete(Long id, Users user) {

        if(!validation.validUser(user))
            return false;

        Mtm mtm = new Mtm();
        mtm.setId(id);
        mtm.setOwner(user);

        //작성자만 수정가능 (관리자는?)
        if(validation.validOwnStuff(mtm, user)) {
            return repository.delete(id, user);
        }
        return null;
    }
}
