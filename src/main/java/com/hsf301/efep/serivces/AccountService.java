package com.hsf301.efep.serivces;

import com.hsf301.efep.models.request_models.LoginRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.ui.Model;

public interface AccountService {
    String login(LoginRequest request, HttpSession session, Model model);
}
