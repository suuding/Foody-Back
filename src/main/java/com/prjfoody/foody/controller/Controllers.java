package com.prjfoody.foody.controller;

import com.prjfoody.foody.service.Services;
import org.springframework.ui.Model;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

public interface Controllers<T> {
    final Services service = null;

    /*
    * select, create, update 는 model에 해당하는 객체를 addAttribute로 넣어주고 반환
    * select 에서 만약에 프론트 페이지에서 표시할 정보가 없을 경우 ( ex)상품 등록페이지는 Product객체 정보가 필요하지 않다 ) ==> 빈 객체를 만들어서 반환
    * create, update 는 생성, 변경된 객체를 addAttribute에 반환
    * delete 는 객체를 넣지 않고 페이지를 그대로 리턴
    *  */
    public String select(T t, Model model, HttpServletRequest request);
    public String create(T t, Model model, HttpServletRequest request);
    public String update(T t, Model model, HttpServletRequest request);
    public String delete(Long id, HttpServletRequest request);

}
