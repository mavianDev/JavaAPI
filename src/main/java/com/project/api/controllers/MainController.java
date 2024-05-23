package com.project.api.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping ("/")
    public String home (Model model) {
        model.addAttribute ("title", "Caelum Networks | Главная Страница");
        return "home";
    }

    @GetMapping ("/login")
    public String login (Model model) {
        model.addAttribute ("title", "Caelum Networks | Авторизация");
        return "login";
    }

}