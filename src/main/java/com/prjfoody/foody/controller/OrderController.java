package com.prjfoody.foody.controller;

import com.prjfoody.foody.domain.Orders;
import com.prjfoody.foody.domain.UserImage;
import com.prjfoody.foody.domain.Users;
import com.prjfoody.foody.parser.UserFromRequest;
import com.prjfoody.foody.service.Services;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@Slf4j
public class OrderController implements Controllers<Orders> {

    private final Services<Orders> servics;
    private final UserFromRequest userFromRequest;

    public OrderController(@Qualifier("OrderService") Services<Orders> servics, UserFromRequest request) {
        this.servics = servics;
        this.userFromRequest = request;
    }

    //들어온 주문 조회
    @GetMapping("/select")
    @Override
    public String select(@ModelAttribute Orders order, Model model, HttpServletRequest request) {

        if (order == null)
            order = new Orders();

        List<Orders> orders = servics.select(order, new Users());
        model.addAttribute("orders", orders);

        return "createOrders";
    }

    //특정 주문 생성
    @PostMapping("/order/create")
    @Override
    public String create(Orders orders, Model model, HttpServletRequest request) {

        Users users = userFromRequest.convert(request);
        if (servics.create(orders, users)) {
            model.addAttribute("order", orders);
            return "createOrders";
        }
        return "select";
    }

    //특정 주문 수정
    @PostMapping("/order/update")
    @Override
    public String update(Orders orders, Model model, HttpServletRequest request) {

        Users users = userFromRequest.convert(request);
        if (servics.update(orders, users)) {
            model.addAttribute("order", orders);
            return "crateOrders";
        }
        return "select";
    }

    //특정 주문 삭제
    @PostMapping("/order/delect/{id}")
    @Override
    public String delete(@PathVariable Long id, HttpServletRequest request) {

        Users users = userFromRequest.convert(request);
        if (servics.delete(id, users)) {
            return "createOrders";
        }
        return "select";
    }
}
