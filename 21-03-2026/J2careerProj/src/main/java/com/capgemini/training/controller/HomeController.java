package com.capgemini.training.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home() {
        return "index"; // index.jsp
    }

    @PostMapping("/selectRole")
    public String handleRole(@RequestParam String role,
                             @RequestParam String action) {

        if (action.equals("login")) {
            return "redirect:/login?role=" + role;
        } else {
            return "redirect:/register?role=" + role;
        }
    }

    @GetMapping("/login")
    public String loginPage(@RequestParam String role,
                           org.springframework.ui.Model model) {
        model.addAttribute("role", role);
        return "login";
    }

    @GetMapping("/register")
    public String registerPage(@RequestParam String role,
                              org.springframework.ui.Model model) {
        model.addAttribute("role", role);
        return "register";
    }
}