package com.prjfoody.foody.service;

import com.prjfoody.foody.domain.Users;
import com.prjfoody.foody.repository.Repositories;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

public interface Services<T> {
    final Repositories repositories = null;

    /*
    * select 는 권한 체크가 필요없는 경우 ( ex) 상품조회 ) Users 객체는 빈 객체를 받아도 상관 없음
    *
    * */
    public List<T> select(T t, Users user);
    public Boolean create(T t, Users user);
    public Boolean update(T t, Users user);
    public Boolean delete(Long id, Users user);

}
