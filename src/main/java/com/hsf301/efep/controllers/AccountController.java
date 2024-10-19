package com.hsf301.efep.controllers;

import com.hsf301.efep.models.request_models.*;
import com.hsf301.efep.serivces.AccountService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("/account")
public class AccountController {

    private final AccountService accountService;

    //-------------REGISTER--------------//
    @PostMapping("/register")
    public String register(RegisterRequest request, Model model) {
        return accountService.register(request, model);
    }

    //-------------LOGIN--------------//
    @PostMapping("/login")
    public String login(LoginRequest request, HttpSession session, Model model) {
        return accountService.login(request, session, model);
    }

    //----------------LOGOUT----------------//

    @GetMapping("/logout")
    public String logout(HttpSession session){
      return accountService.logout(session);
    }

    //-------------VIEW PROFILE--------------//

    @GetMapping("/profile")
    @Operation(hidden = true)
    public String viewProfile(@ModelAttribute ViewProfileRequest request, Model model) {
        return accountService.viewProfile(request, model);
    }
    
    //-------------UPDATE PROFILE--------------//

    @PutMapping("/update/profile")
    @Operation(hidden = true)
    public String updateProfile(UpdateProfileRequest request, HttpSession session, Model model) {
        return accountService.updateProfile(request, session, model);
    }
    
    //-------------CHANGE PASSWORD--------------//

    @PostMapping("/change/password")
    @Operation(hidden = true)
    public String changePassword(ChangePasswordRequest request, HttpSession session, Model model) {
        return accountService.changePassword(request, session, model);
    }
}
