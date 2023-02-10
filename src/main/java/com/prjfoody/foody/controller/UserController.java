package com.prjfoody.foody.controller;

import com.prjfoody.foody.domain.Product;
import com.prjfoody.foody.domain.Users;
import com.prjfoody.foody.domain.define.SessionAttributes;
import com.prjfoody.foody.parser.UserFromRequest;
import com.prjfoody.foody.service.Services;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;


@Controller
@Slf4j
public class UserController implements Controllers<Users> {

    private final Services<Users> service;
    private final UserFromRequest userFromRequest;

    public UserController(@Qualifier("UserService") Services<Users> service, UserFromRequest userFromRequest) {
        this.service = service;
        this.userFromRequest = userFromRequest;
    }

    // 로그인 웹 페이지 요청
    @GetMapping("/login")
    public String login(Model model, HttpServletRequest request) {
        model.addAttribute("user", new Users());

        return "users/login";
    }
    
    // 로그인 요청
    @PostMapping("/login")
    public String loginPost(Users users, HttpServletRequest request){
        List<Users> selectUser = service.select(users, users);

        if (selectUser.size() > 0) {
            HttpSession session = request.getSession();
            session.setAttribute(SessionAttributes.ID.name(), selectUser.get(0));
        }

        return "users/userDetail";
    }

    // 로그아웃 요청
    @GetMapping("/logout")
    public String logout(HttpServletRequest request) {
        Users users = userFromRequest.convert(request);
        if (users != null && users.getId() != null)
            request.getSession().invalidate();

        return "main";
    }

    // 사용자 조회
    @GetMapping("/user")
    @Override
    public String select(Users users, Model model, HttpServletRequest request) {
        Users sessionUser = userFromRequest.convert(request);
        List<Users> selectUsers = service.select(sessionUser, sessionUser);

        if (selectUsers.size() > 0 && selectUsers.get(0).getId() != null) {
            model.addAttribute("user", selectUsers.get(0));
            return "users/userDetail";
        }

        return "main";
    }

    // 회원가입
    @PostMapping("/user/sign-on")
    @Override
    public String create(Users users, Model model, HttpServletRequest request) {
        log.info(users.getName());
        log.info(users.getPasswd());

        service.create(users, users);

        return "redirect:/login";
    }

    // 회원수정
    @PostMapping("/user/update")
    @Override
    public String update(Users users, Model model, HttpServletRequest request) {
        model.addAttribute("user", users);

        Users sessionUser = userFromRequest.convert(request);

        if(service.update(users, sessionUser))
            model.addAttribute("user", users);

        return "users/userDetail";
    }

    // 회원탈퇴

    @PostMapping("/user/delete")
    @Override
    public String delete(Long id, HttpServletRequest request) {
        Users sessionUser = userFromRequest.convert(request);
        service.delete(id, sessionUser);
        return "redirect:/login";
    }

}
