package com.capgemini.training.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.capgemini.training.entity.UserEntity;
import com.capgemini.training.services.LoginServices;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class LoginController {

    @Autowired
    private LoginServices loginServices;

    // ================= LOGIN =================

    @GetMapping("/")
    public String loginPage() {
        return "login.jsp";
    }

    @PostMapping("/login")
    public String validate(HttpServletRequest request) {

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        System.out.println(username);
        System.out.println(password);

        boolean flag = loginServices.validateUser(username, password);

        if (flag) {
            // redirect to employee list
            return "redirect:/allemp";
        } else {
            request.setAttribute("message",
                    "<font style='color:red'>Invalid user id or password</font>");
            return "login.jsp";
        }
    }

    // ================= SIGN-UP =================

    @GetMapping("/sign-up")
    public String signUp() {
        return "register.jsp";
    }

    // ================= REGISTER =================

    @GetMapping("/register")
    public String registerPage() {
        return "register.jsp";
    }

    @PostMapping("/register")
    public String register(HttpServletRequest request) {

        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        System.out.println(name);
        System.out.println(email);
        System.out.println(username);
        System.out.println(password);

        UserEntity userEntity = new UserEntity();
        userEntity.setName(name);
        userEntity.setEmail(email);
        userEntity.setUser(username);
        userEntity.setPassword(password);

        loginServices.registerUser(userEntity);

        request.setAttribute("message",
                "<font style='color:green'>Registered Successfully</font>");

        return "login.jsp";
    }

    // ================= FORGOT PASSWORD =================

    @GetMapping("/forgetpassword")
    public String forgotPage() {
        return "forgetpassword.jsp";
    }

    @PostMapping("/forgetpassword")
    public String forgot(HttpServletRequest request) {

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        boolean flag = loginServices.updatePassword(username, password);

        if (flag) {
            request.setAttribute("message",
                    "<font style='color:green'>Password Reset Successfully</font>");
        } else {
            request.setAttribute("message",
                    "<font style='color:red'>User not found</font>");
        }

        return "login.jsp";
    }
}