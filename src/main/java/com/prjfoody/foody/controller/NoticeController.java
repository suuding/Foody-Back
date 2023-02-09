package com.prjfoody.foody.controller;

import com.prjfoody.foody.domain.Notice;
import com.prjfoody.foody.domain.Users;
import com.prjfoody.foody.domain.types.UserType;
import com.prjfoody.foody.parser.UserFromRequest;
import com.prjfoody.foody.service.Services;
import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@Slf4j
public class NoticeController implements Controllers<Notice>{

    private final Services<Notice> service;
    private final UserFromRequest userFromRequest;

    public NoticeController (@Qualifier("NoticeServices") Services<Notice> service, UserFromRequest userFromRequest) {
        this.service = service;
        this.userFromRequest = userFromRequest;
    }

    @GetMapping("/notice")
    @Override
    public String select(@ModelAttribute Notice notice, Model model, HttpServletRequest request) {

        if (notice == null)
            notice = new Notice();

        List<Notice> notices = service.select(notice, new Users());
        model.addAttribute("notices", notices);

        return "createNotice";
    }

    @PostMapping("/notice/create")
    @Override
    public String create(Notice notice, Model model, HttpServletRequest request) {

        Users user = userFromRequest.convert(request);

        //관리자만 공지글 생성 가능
        if (user.getUserType() == UserType.ADMIN) {
            if (service.create(notice, user)) {
                model.addAttribute("notice", notice);
                return "createNotice";
            }
        }
        return "select";
    }

    @PostMapping("/notice/update")
    @Override
    public String update(Notice notice, Model model, HttpServletRequest request) {

        Users user = userFromRequest.convert(request);

        if (user.getUserType() == UserType.ADMIN) {
            if (service.update(notice, user)) {
                model.addAttribute("notice", notice);
                return "createNotice";
            }
        }

        return "select";
    }

    @PostMapping("/notice/delete/{id}")
    @Override
    public String delete(@PathVariable Long id, HttpServletRequest request) {

        Users user = userFromRequest.convert(request);

        if (user.getUserType() == UserType.ADMIN) {
            if (service.delete(id, user)) {
                return "createNotice";
            }
        }
        return "select";
    }
}
