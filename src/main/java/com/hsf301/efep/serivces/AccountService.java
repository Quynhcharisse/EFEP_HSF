package com.hsf301.efep.serivces;

import com.hsf301.efep.models.request_models.*;
import jakarta.servlet.http.HttpSession;
import org.springframework.ui.Model;

public interface AccountService {
    
    String login(LoginRequest request, HttpSession session, Model model);
    
    String logout(HttpSession session);

    String viewProfile(ViewProfileRequest request, Model model);
    
    String updateProfile(UpdateProfileRequest request, HttpSession session, Model model);

    String changePassword(ChangePasswordRequest request, HttpSession session, Model model);

    String register(RegisterRequest request, Model model);
}
