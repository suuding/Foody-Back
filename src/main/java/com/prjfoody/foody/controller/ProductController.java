package com.prjfoody.foody.controller;

import com.prjfoody.foody.domain.Product;
import com.prjfoody.foody.domain.Users;
import com.prjfoody.foody.domain.define.SessionAttributes;
import com.prjfoody.foody.parser.UserFromRequest;
import com.prjfoody.foody.service.Services;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

// PostCostructor 같은 걸로 메소드 종료 시 무조건 호출되는 기능 있으면 거기에
// (호출함수(전역변수?), suc/fail) 등의 인자 값을 받으면 로그 찍어주는 메소드
@Controller
@Slf4j
public class ProductController implements Controllers<Product> {

    private final Services<Product> service;
    private final UserFromRequest userFromRequest;

    public ProductController(@Qualifier("ProductService") Services<Product> service, UserFromRequest userFromRequest) {
        this.service = service;
        this.userFromRequest = userFromRequest;
    }

    /* 상품 개별 조회 */
    @GetMapping("/product/{id}")
    public String selectOne(@PathVariable Long id, Model model){

        Product product = new Product();
        product.setId(id);

        List<Product> productsResult = service.select(product, new Users());
        if (productsResult.size() > 0)
            product = productsResult.get(0);

        model.addAttribute("product", product);

        return "select";
    }

    /* 상품 다수 조회 */
    @GetMapping("/product")
    @Override
    // 접근 url : /product?id=1&title=abcd
    public String select(@ModelAttribute Product product, Model model, HttpServletRequest request) {

        if (product == null)
            product = new Product();

        List<Product> products = service.select(product, userFromRequest.convert(request));
        if(products.size() > 0){
            model.addAttribute("products", products);
        }


        return "/src-thymeleaf/html/product/product";
    }

    @GetMapping("/product/event")
    public String event() {
        return "/src-thymeleaf/html/product/event";
    }

    // todo: 상품등록 페이지 필요
    /* 상품등록 */
    @PostMapping("/product/create")
    @Override
    public String create(Product product, Model model, HttpServletRequest request) {
        log.info(product.getTitle());
        log.info(product.getDescription());

        // session에서 가져온 user객체
        Users users = userFromRequest.convert(request);
        if (service.create(product, users)){
            model.addAttribute("product", product);
            return "createProduct";
        }

        // 에러페이지
        return "select";
    }

    // todo: 상품 수정 페이지
    // Get 요청이 들어오면 상품등록페이지와 같은 url에 Product 객체를 select해서 넘겨주기
    @PostMapping("/product/update")
    @Override
    public String update(Product product, Model model, HttpServletRequest request) {

        Users users = userFromRequest.convert(request);
        if (service.update(product, users)){
            model.addAttribute("product", product);
            return "createProduct";
        }

        // 에러페이지
        return "select";
    }

    @PostMapping("/product/delete/{id}")
    @Override
    public String delete(@PathVariable Long id, HttpServletRequest request) {

        Users users = userFromRequest.convert(request);
        if (service.delete(id, users)){
            return "main";
        }

        // 에러페이지
        return "main";
    }


}
