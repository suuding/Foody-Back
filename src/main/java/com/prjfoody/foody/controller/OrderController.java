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

    @GetMapping("/select/{id}")
    public String selectOne(@PathVariable Long id, Model model) {

        Orders order = new Orders();
        order.setId(id);

        List<Orders> orders = servics.select(order, new Users());
        if (orders.size()>0)
            order = orders.get(0);

        model.addAttribute("order", order);

        return "order";
    }

    //들어온 주문 조회
    @GetMapping("/select")
    @Override
    public String select(@ModelAttribute Orders order, Model model, HttpServletRequest request) {

        if (order == null)
            order = new Orders();

        List<Orders> orders = servics.select(order, new Users());
        model.addAttribute("orders", orders);

        return "orders";
    }

    //'바로 주문' 또는 '장바구니'로 주문 넣으면 
    @GetMapping("/order/create")
    public String create(Model model) {

        model.addAttribute("order", new Orders());

        //주문하기 -> 장바구니 페이지
        return "basket";
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

    //장바구니에서 주문 수정
    //자기 장바구니 어떻게 알지? -> id로? userid로?
    @GetMapping("/order/update/{id}")
    public String update(@PathVariable Long id, Model model, HttpServletRequest request) {

        Users user = userFromRequest.convert(request);

        Orders order = new Orders();
        order.setUsers(user);

        List<Orders> orders = servics.select(order, user);
        if (orders.size()>0) {
            model.addAttribute("order", orders.get(0));

            return "basket";
        }

        return "order";
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
    @PostMapping("/order/delete/{id}")
    @Override
    public String delete(@PathVariable Long id, HttpServletRequest request) {

        Users users = userFromRequest.convert(request);

        if (servics.delete(id, users)) {
            return "createOrders";
        }
        return "select";
    }
}
