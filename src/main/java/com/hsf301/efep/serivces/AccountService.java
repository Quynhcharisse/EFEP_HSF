package com.hsf301.efep.serivces;

import com.hsf301.efep.models.request_models.*;
import jakarta.servlet.http.HttpSession;
import org.springframework.ui.Model;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

public interface AccountService {
    
    String login(LoginRequest request, HttpSession session, Model model);
    
    String logout(HttpSession session);

    String viewProfile( Model model, HttpSession session, RedirectAttributes redirectAttributes, int userId);
    
    String updateProfile(UpdateProfileRequest request, HttpSession session, Model model, RedirectAttributes redirectAttributes);

    String changePassword(ChangePasswordRequest request, HttpSession session, Model model);

    String register(RegisterRequest request, Model model);
}
