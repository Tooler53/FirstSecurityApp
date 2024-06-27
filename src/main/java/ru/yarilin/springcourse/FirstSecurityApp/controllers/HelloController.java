package ru.yarilin.springcourse.FirstSecurityApp.controllers;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.yarilin.springcourse.FirstSecurityApp.security.PersonDetails;

@Controller
@RequestMapping("/hello")
public class HelloController {
    @RequestMapping
    public String sayHello() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        PersonDetails personDetails = (PersonDetails) authentication.getPrincipal();
        System.out.println(personDetails.getPerson());
        return "hello/index";
    }
}
