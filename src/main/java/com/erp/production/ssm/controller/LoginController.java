package com.erp.production.ssm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class LoginController {
    @RequestMapping("erp")
    public String login(Model model){
        return "login";
    }
}
