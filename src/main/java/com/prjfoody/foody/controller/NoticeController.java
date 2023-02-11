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

    @GetMapping("/notice/{id}")
    public String selectOne(@PathVariable Long id, Model model) {

        Notice notice = new Notice();
        notice.setId(id);

        List<Notice> notices = service.select(notice, new Users());
        if (notices.size()>0)
            notice = notices.get(0);

        model.addAttribute("notice", notice);

        //공지글 개별 페이지
        return "src-thymeleaf/html/notice/notice_read";

    }

    @GetMapping("/notice")
    @Override
    public String select(@ModelAttribute Notice notice, Model model, HttpServletRequest request) {

        if (notice == null)
            notice = new Notice();

        List<Notice> notices = service.select(notice, new Users());
        model.addAttribute("notices", notices);

        //공지글 목록 페이지
        return "src-thymeleaf/html/notice/notice";
    }

    //사용자가 요청한 '공지 글 쓰기 페이지' 불러오는
    @GetMapping("/notice/create")
    public String create(Model model) {

        model.addAttribute("notice", new Notice());

        //공지글 생성 페이지
        return "src-thymeleaf/html/notice/write";
    }

    @PostMapping("/notice/create")
    @Override
    public String create(Notice notice, Model model, HttpServletRequest request) {

        Users user = userFromRequest.convert(request);

        //관리자만 공지글 생성 가능
        if (user != null) {
            System.out.println("null아님: "+notice.getDescription());
            if (service.create(notice, user)) {
                model.addAttribute("notice", notice);

                return "src-thymeleaf/html/notice/notice";
            }
        } else {
            Users users= new Users();
            users.setName("수딩");

            if (service.create(notice, users)) {
                model.addAttribute("notice", notice);
                return "src-thymeleaf/html/notice/notice";
            }
        }
        return "src-thymeleaf/html/notice/write";
    }

    @GetMapping("/notice/update/{id}")
    public String update(@PathVariable Long id, Model model, HttpServletRequest request) {

        Users user = userFromRequest.convert(request);

        Notice notice = new Notice();
        notice.setId(id);

        if (user.getUserType() == UserType.ADMIN) {
            List<Notice> notices = service.select(notice, user);
            if (notices.size() > 0) {
                model.addAttribute("notice", notices.get(0));

                return "updateNotice";
            }
        }

        return "notices";
    }

    @PostMapping("/notice/update")
    @Override
    public String update(Notice notice, Model model, HttpServletRequest request) {

        Users user = userFromRequest.convert(request);

        if (user.getUserType() == UserType.ADMIN) {
            if (service.update(notice, user)) {
                model.addAttribute("notice", notice);

                return "redirect:/notice/select";
            }
        }

        return "notices";
    }

    @PostMapping("/notice/delete/{id}")
    @Override
    public String delete(@PathVariable Long id, HttpServletRequest request) {

        Users user = userFromRequest.convert(request);

        if (user.getUserType() == UserType.ADMIN) {
            if (service.delete(id, user)) {
                return "notices";
            }
        }
        return "notices";
    }
}
