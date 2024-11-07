package com.hsf301.efep.service_implementors;


import com.hsf301.efep.configurations.ReturnPageConfig;
import com.hsf301.efep.enums.ActionCaseValues;
import com.hsf301.efep.enums.Roles;
import com.hsf301.efep.enums.Status;
import com.hsf301.efep.models.entity_models.Account;
import com.hsf301.efep.models.entity_models.User;
import com.hsf301.efep.models.entity_models.Wishlist;

import com.hsf301.efep.configurations.ReturnPageConfig;
import com.hsf301.efep.enums.ActionCaseValues;
import com.hsf301.efep.enums.Roles;
import com.hsf301.efep.models.entity_models.Account;
import com.hsf301.efep.models.request_models.LoginRequest;
import com.hsf301.efep.models.request_models.RegisterRequest;
import com.hsf301.efep.models.response_models.LoginResponse;
import com.hsf301.efep.models.response_models.RegisterResponse;
import com.hsf301.efep.repositories.AccountRepo;
import com.hsf301.efep.repositories.UserRepo;
import com.hsf301.efep.repositories.WishlistRepo;
import com.hsf301.efep.services.AccountService;

import com.hsf301.efep.validations.RegisterValidation;

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
        LoginResponse response = loginLogic(request);
        if (response.getStatus().equals("400")) {
            redirectAttributes.addFlashAttribute("error", response);
            return ReturnPageConfig.generateReturnMapping(ActionCaseValues.LOGIN_FAIL);
        }
        Account account = accountRepo.findByEmailAndPassword(request.getEmail(), request.getPassword()).get();
        session.setAttribute("account", account);
        redirectAttributes.addFlashAttribute("msg", response);
        if (Roles.checkIfThisAccountIsCustomer(account)) {
            return ReturnPageConfig.generateReturnMapping(ActionCaseValues.LOGIN_SUCCESS_CUSTOMER);
        }
        return ReturnPageConfig.generateReturnMapping(ActionCaseValues.LOGIN_SUCCESS_SHOP);
    }

    private LoginResponse loginLogic(LoginRequest request) {
        Account account = accountRepo.findByEmailAndPassword(request.getEmail(), request.getPassword()).orElse(null);
        if (account == null) {
            return LoginResponse.builder().status("400").message("Email or password is incorrect").build();
        }
        return LoginResponse.builder().status("200").message("Login successfully").build();
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
