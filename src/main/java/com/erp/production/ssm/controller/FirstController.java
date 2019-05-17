package com.erp.production.ssm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FirstController {

    @RequestMapping("/")
    public String login(Model model){
        model.addAttribute("activeUser",null);
        return "home";
    }
}
