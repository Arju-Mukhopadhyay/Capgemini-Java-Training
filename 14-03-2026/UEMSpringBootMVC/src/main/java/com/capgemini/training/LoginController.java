package com.capgemini.training;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LoginController {

    @GetMapping("/")
    public String loginPage() {
        return "login.jsp";
    }

    @PostMapping("/login")
    public String validate(String username, String password) {

        System.out.println(username);
        System.out.println(password);

        return "home.jsp";
    }

    @GetMapping("/register")
    public String registerPage() {
        return "register.jsp";
    }

    @PostMapping("/register")
    @ResponseBody
    public String register(String name, String email, String username, String password) {

        System.out.println(name);
        System.out.println(email);
        System.out.println(username);
        System.out.println(password);

        return "Registration Successful";
    }

    @GetMapping("/forgetpassword")
    public String forgotPage() {
        return "forgetpassword.jsp";
    }

    @PostMapping("/forgetpassword")
    @ResponseBody
    public String forgot(String username, String password) {

        System.out.println(username);
        System.out.println(password);

        return "Password Updated";
    }

}