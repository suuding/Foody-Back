package com.prjfoody.foody.repository;

import com.prjfoody.foody.domain.Users;

import java.util.List;

public interface Repositories<T> {

    /*
    * Repository에서 인자값으로 받는 객체들의 전처리는 Repository에서 진행하지 않음
    * 동적 쿼리를 위한 조건문 사용은 가능함
    * */

    public List<T> select(T t, Users user);
    public Boolean create(T t, Users user);
    public Boolean update(T t, Users user);
    public Boolean delete(Long id, Users user);
}
