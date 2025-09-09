package com.livrei.les.ecomercy.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {
    @GetMapping("/client-register")
    public String showClientRegisterPage() {
        return "client-register";
    }
}