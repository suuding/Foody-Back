package com.prjfoody.foody.controller;

import com.prjfoody.foody.domain.Product;
import com.prjfoody.foody.domain.Users;
import com.prjfoody.foody.parser.UserFromRequest;
import com.prjfoody.foody.service.Services;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class MainController {

    private Services<Product> service;
    public MainController(@Qualifier("ProductService") Services<Product> service) {
        this.service = service;
    }

    @GetMapping("/")
    public String main(Model model){
        System.out.println("MainController.main");

        List<Product> select = service.select(new Product(), new Users());
        model.addAttribute("productList", select);
        return "/src-thymeleaf/html/main/main-page";
    }

    @GetMapping("/main")
    public String main() {
        return "/src-thymeleaf/html/main/main-page";
    }

}
