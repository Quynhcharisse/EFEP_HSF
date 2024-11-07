package com.quynh.efep_hsf.services;

import com.quynh.efep_hsf.models.request_models.LoginRequest;
import com.quynh.efep_hsf.models.request_models.RegisterRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

public interface AccountService {
    String login(LoginRequest request, HttpSession session, RedirectAttributes redirectAttributes);
    String register(RegisterRequest request, RedirectAttributes redirectAttributes);
    String logout(HttpSession session);
}
