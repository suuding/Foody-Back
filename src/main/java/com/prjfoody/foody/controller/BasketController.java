package com.prjfoody.foody.controller;

import com.prjfoody.foody.domain.Basket;
import com.prjfoody.foody.domain.Product;
import com.prjfoody.foody.domain.Users;
import com.prjfoody.foody.parser.UserFromRequest;
import com.prjfoody.foody.service.Services;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@Slf4j
public class BasketController implements Controllers<Basket> {

    private final Services<Basket> service;
    private final UserFromRequest userFromRequest;

    public BasketController(@Qualifier("BasketService") Services<Basket> service, UserFromRequest userFromRequest) {
        this.service = service;
        this.userFromRequest = userFromRequest;
    }

    @GetMapping("/basket")
    @Override
    public String select(Basket basket, Model model, HttpServletRequest request) {
        Users sessionUser = userFromRequest.convert(request);
        List<Basket> selectBasket = service.select(basket, sessionUser);
        model.addAttribute("baskets", selectBasket);

        return "src-thymeleaf/html/basket/basket";
    }


    @PostMapping("/basket/create")
    public String createBasket(Product product, Model model, HttpServletRequest request) {
        Users sessionUser = userFromRequest.convert(request);

        // services interface를 상속하고 있기 때문에 무조건 basket을 넘겨줄수 밖에 없음
        // 어쩔수 없이 new Basket을 해야하는 상황임
        Basket basket = new Basket();
        basket.setProduct(product);
        service.create(basket, sessionUser);

        return null;
    }

    @Override
    public String create(Basket basket, Model model, HttpServletRequest request) {
        return null;
    }
/*
    @PostMapping("/basket/create")
    @Override
    public String create(Basket basket, Model model, HttpServletRequest request) {
        Users sessionUser = userFromRequest.convert(request);
        service.create(basket, sessionUser);
        return null;
    }


 */
    @PostMapping("/basket/update")
    @Override
    public String update(Basket basket, Model model, HttpServletRequest request) {
        Users sessionUser = userFromRequest.convert(request);
        service.update(basket, sessionUser);
        return null;
    }

    @GetMapping("/basket/delete/{id}")
    @Override
    public String delete(@PathVariable Long id, HttpServletRequest request) {
        Users sessionUser = userFromRequest.convert(request);
        service.delete(id, sessionUser);
        return null;
    }
}
