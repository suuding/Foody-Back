package com.prjfoody.foody.service;

import com.prjfoody.foody.domain.Notice;
import com.prjfoody.foody.domain.Users;
import com.prjfoody.foody.domain.types.UserType;
import com.prjfoody.foody.modules.Validation;
import com.prjfoody.foody.repository.Repositories;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Qualifier("NoticeServices")
@Slf4j
public class NoticeServices implements Services<Notice> {

    private final Repositories<Notice> repository;
    private final Validation validation;

    public NoticeServices(@Qualifier("NoticeRepository") Repositories<Notice> repository, Validation validation) {
        this.repository = repository;
        this.validation = validation;
    }


    @Override
    public List<Notice> select(Notice notice, Users user) {
        return repository.select(notice, user);
    }

    @Override
    public Boolean create(Notice notice, Users user) {
        //관리자만 공지 글 생성 가능
        if (user.getUserType() == UserType.ADMIN) {
            notice.initStuff(user);

            return repository.create(notice, user);
        }

        return false;
    }

    @Override
    public Boolean update(Notice notice, Users user) {
        //관리자만 공지 글 수정 가능
        if (user.getUserType() == UserType.ADMIN) {
            notice.setLastDateTime(LocalDateTime.now());

            return repository.update(notice, user);
        }

        return false;
    }

    @Override
    public Boolean delete(Long id, Users user) {

        if (user.getUserType() == UserType.ADMIN) {
            return repository.delete(id, user);
        }

        return false;
    }
}
