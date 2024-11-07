package com.hsf301.efep.service_implementors;

import com.hsf301.efep.models.request_models.LoginRequest;
import com.hsf301.efep.models.request_models.RegisterRequest;
import com.hsf301.efep.models.response_models.LoginResponse;
import com.hsf301.efep.models.response_models.RegisterResponse;
import com.hsf301.efep.repositories.AccountRepo;
import com.hsf301.efep.repositories.UserRepo;
import com.hsf301.efep.repositories.WishlistRepo;
import com.hsf301.efep.services.AccountService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {
    private final AccountRepo accountRepo;
    private final UserRepo userRepo;
    private final WishlistRepo wishlistRepo;

    //-------------------------------------Login-------------------------------------//

    @Override
    public String login(LoginRequest request, HttpSession session, RedirectAttributes redirectAttributes) {
        return null;
    }

    private LoginResponse loginLogic(LoginRequest request) {
        return null;
    }

    //--------------------TEST--------------------//

    public LoginResponse loginLogicTest(LoginRequest request) {
        return null;
    }


    //-------------------------------------Register-------------------------------------//

    @Override
    public String register(RegisterRequest request, RedirectAttributes redirectAttributes) {
        return null;
    }

    private RegisterResponse registerLogic(RegisterRequest request) {
        return null;
    }

    //--------------------TEST--------------------//

    public RegisterResponse registerLogicTest(RegisterRequest request) {
        return null;
    }

    //-------------------------------------Logout-------------------------------------//

    @Override
    public String logout(HttpSession session) {
        return null;
    }
}
