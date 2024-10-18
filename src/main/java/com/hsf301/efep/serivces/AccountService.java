package com.hsf301.efep.serivces;

import com.hsf301.efep.models.request_models.ChangePasswordRequest;
import com.hsf301.efep.models.request_models.LoginRequest;
import com.hsf301.efep.models.request_models.UpdateProfileRequest;
import com.hsf301.efep.models.request_models.ViewProfileRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.ui.Model;

public interface AccountService {
    
    String login(LoginRequest request, HttpSession session, Model model);
    
    String logout(HttpSession session);

    String viewProfile(ViewProfileRequest request, Model model);
    
    String updateProfile(UpdateProfileRequest request, HttpSession session, Model model);

    String changePassword(ChangePasswordRequest request, HttpSession session, Model model);
}
