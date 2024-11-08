package com.hsf301.efep.services;

import com.hsf301.efep.models.request_models.LoginRequest;
import com.hsf301.efep.models.request_models.RegisterRequest;
import com.hsf301.efep.models.response_models.LoginResponse;
import com.hsf301.efep.models.response_models.RegisterResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

public interface AccountService {
    String login(LoginRequest request, HttpSession session, RedirectAttributes redirectAttributes);
    String register(RegisterRequest request, RedirectAttributes redirectAttributes);
    String logout(HttpSession session);


}
