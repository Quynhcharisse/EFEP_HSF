package com.quynh.efep_hsf.controllers;


import com.quynh.efep_hsf.models.request_models.LoginRequest;
import com.quynh.efep_hsf.models.request_models.RegisterRequest;
import com.quynh.efep_hsf.services.AccountService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequiredArgsConstructor
@RequestMapping("/account")
public class AccountController {

    private final AccountService accountService;

    @PostMapping("/login")
    public String login(LoginRequest request, HttpSession session, RedirectAttributes redirectAttributes){
        return accountService.login(request, session, redirectAttributes);
    }

    @PostMapping("/register")
    public String register(RegisterRequest request, RedirectAttributes redirectAttributes){
        return accountService.register(request, redirectAttributes);
    }

    @GetMapping("/logout")
    public String logout(HttpSession session){
        return accountService.logout(session);
    }


}
