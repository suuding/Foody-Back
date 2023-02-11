package com.prjfoody.foody.controller;

import com.prjfoody.foody.domain.Mtm;
import com.prjfoody.foody.domain.Users;
import com.prjfoody.foody.domain.types.UserType;
import com.prjfoody.foody.parser.UserFromRequest;
import com.prjfoody.foody.service.MtmServices;
import com.prjfoody.foody.service.Services;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@Slf4j
public class MtmController implements Controllers<Mtm> {

    private final Services<Mtm> service;
    private final UserFromRequest userFromRequest;

    public MtmController(@Qualifier("MtmService") Services<Mtm> service, UserFromRequest userFromRequest) {
        this.service = service;
        this.userFromRequest = userFromRequest;
    }

    //익명: 공개글 조회만 가능
    //회원: 공개글 조회, 작성, 수정, 삭제 가능
    //관리자: 모든 글 조회 가능

    //한 문의글 조회
    @GetMapping("/mtm/{id}")
    public String selectOne(@PathVariable Long id, Model model) {

        Mtm mtm = new Mtm();
        mtm.setId(id);

        List<Mtm> mtms = service.select(mtm, new Users());
        if (mtms.size()>0)
            mtm = mtms.get(0);

        model.addAttribute("mtm", mtm);

        //문의글 개별 페이지
        return "src-thymeleaf/html/mtm/mtm_read";
    }

    @GetMapping("/mtm")
    @Override
    public String select(@ModelAttribute Mtm mtm, Model model, HttpServletRequest request) {

        if (mtm == null)
            mtm = new Mtm();

        List<Mtm> mtms = service.select(mtm, new Users());
        model.addAttribute("mtms", mtms);

        //문의글 전체 조희 페이지
        return "src-thymeleaf/html/mtm/mtm";
    }

    @GetMapping("/mtm/create")
    public String create(Model model) {

        model.addAttribute("mtm", new Mtm());

        //문의글 생성(작성) 페이지
        return "src-thymeleaf/html/mtm/write";
    }

    //글 등록
    @PostMapping("/mtm/create")
    @Override
    public String create(Mtm mtm, Model model, HttpServletRequest request) {

        Users user = userFromRequest.convert(request);

        //회원과 관리자만 문의글 작성 가능
        if (user != null) {
            System.out.println("null아님: "+mtm.getContent());
            if (service.create(mtm, user)) {
                model.addAttribute("mtm", mtm);
                return "src-thymeleaf/html/mtm/mtm";
            }
        } else {
            Users users= new Users();
            users.setName("수딩");

            if (service.create(mtm, users)) {
                model.addAttribute("mtm", mtm);
                return "src-thymeleaf/html/mtm/mtm";
            }
        }

        return "src-thymeleaf/html/mtm/write";
    }

    @GetMapping("/mtm/update/{id}")
    public String update(@PathVariable Long id, Model model, HttpServletRequest request) {

        Users user = userFromRequest.convert(request);

        Mtm mtm = new Mtm();
        mtm.setId(id);

        if (user.getUserType() != UserType.ANONY) {
            List<Mtm> mtms = service.select(mtm, user);
            if (mtms.size() > 0) {
                model.addAttribute("mtm", mtm);

                return "updateMtm";
            }
        }

        return "mtms";
    }

    //글 수정
    @PostMapping("/mtm/update")
    @Override
    public String update(Mtm mtm, Model model, HttpServletRequest request) {

        Users user = userFromRequest.convert(request);

        if (user.getUserType() != UserType.ANONY) {
            if (service.update(mtm, user)) {
                model.addAttribute("mtm", mtm);

                return "redirect:/mtm/select";
            }
        }

        return "mtms";
    }

    //글 삭제
    @PostMapping("/mtm/delete/{id}")
    @Override
    public String delete(@PathVariable Long id, HttpServletRequest request) {

        Users user = userFromRequest.convert(request);

        if (user.getUserType() != UserType.ANONY) {
            if (service.delete(id, user)) {
                return "createMtm";
            }
        }

        return "select";
    }

}
