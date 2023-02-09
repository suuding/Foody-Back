package com.prjfoody.foody.controller;

import com.prjfoody.foody.domain.Mtm;
import com.prjfoody.foody.domain.Users;
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

    @PostMapping("/mtm")
    @Override
    public String select(@ModelAttribute Mtm mtm, Model model, HttpServletRequest request) {

        if (mtm == null)
            mtm = new Mtm();

        List<Mtm> mtms = service.select(mtm, new Users());
        model.addAttribute("mtms", mtms);

        return "createMtm";
    }

    //글 등록
    @PostMapping("/mtm/create")
    @Override
    public String create(Mtm mtm, Model model, HttpServletRequest request) {

        Users users = userFromRequest.convert(request);
        if (service.create(mtm, users)) {
            model.addAttribute("mtm", mtm);
            return "createMtm";
        }

        return "select";
    }

    //글 조회
    @GetMapping("/mtm/{id}")
    public String select(@PathVariable Long id, Model model) {

        Mtm mtm = new Mtm();
        mtm.setId(id);

        List<Mtm> MtmResult = service.select(mtm, new Users());
        if (MtmResult.size()>0)
            mtm=MtmResult.get(0);

        model.addAttribute("mtm", mtm);

        return "select";
    }

    //글 수정
    @PostMapping("/mtm/update")
    @Override
    public String update(Mtm mtm, Model model, HttpServletRequest request) {
        Users users = userFromRequest.convert(request);
        if (service.update(mtm, users)) {
            model.addAttribute("mtm", mtm);
            return "createmtm";
        }

        return "mtm";
    }

    //글 삭제
    @PostMapping("/mtm/delete/{id}")
    @Override
    public String delete(@PathVariable Long id, HttpServletRequest request) {
        Users user = userFromRequest.convert(request);
        if (service.delete(id, user)) {
            return "createMtm";
        }

        return "select";
    }

}
