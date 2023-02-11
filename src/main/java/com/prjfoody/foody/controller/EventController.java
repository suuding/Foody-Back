package com.prjfoody.foody.controller;

import com.prjfoody.foody.domain.Event;
import com.prjfoody.foody.domain.Mtm;
import com.prjfoody.foody.domain.Users;
import com.prjfoody.foody.parser.UserFromRequest;
import com.prjfoody.foody.service.Services;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class EventController implements Controllers<Event> {

    private final Services<Event> service;
    private final UserFromRequest userFromRequest;

    public EventController(@Qualifier("EventService") Services<Event> service, UserFromRequest userFromRequest) {
        this.service = service;
        this.userFromRequest = userFromRequest;
    }

    @GetMapping("/product/event")
    @Override
    public String select(Event event, Model model, HttpServletRequest request) {
        model.addAttribute("eventList", service.select(event, new Users()));

        return "src-thymeleaf/html/product/event";
    }

    @Override
    public String create(Event event, Model model, HttpServletRequest request) {
        return null;
    }

    @Override
    public String update(Event event, Model model, HttpServletRequest request) {
        return null;
    }

    @Override
    public String delete(Long id, HttpServletRequest request) {
        return null;
    }
}