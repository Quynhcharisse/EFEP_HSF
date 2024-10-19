package com.hsf301.efep.service_implementors;

import com.hsf301.efep.enums.PageName;
import com.hsf301.efep.models.request_models.ChangePasswordRequest;
import com.hsf301.efep.models.request_models.LoginRequest;
import com.hsf301.efep.models.request_models.UpdateProfileRequest;
import com.hsf301.efep.models.request_models.ViewProfileRequest;
import com.hsf301.efep.models.response_models.LoginResponse;
import com.hsf301.efep.enums.FailPageFor;
import com.hsf301.efep.enums.SuccessPageFor;
import com.hsf301.efep.logics.AccountLogic;
import com.hsf301.efep.models.entity_models.Account;
import com.hsf301.efep.models.request_models.*;
import com.hsf301.efep.models.response_models.*;
import com.hsf301.efep.repositories.AccountRepo;
import com.hsf301.efep.serivces.AccountService;
import com.hsf301.efep.validations.LoginValidation;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService{

    private final AccountRepo accountRepo;

    //---------------------------------REGISTER--------------------------------------//

    @Override
    public String register(RegisterRequest request, Model model) {
        RegisterResponse response = AccountLogic.registerLogic(request);
        model.addAttribute(response.getType(), response);
        return response.getStatus().equals("200") ? SuccessPageFor.REGISTER : FailPageFor.REGISTER;
    }

    //---------------------------------LOGIN--------------------------------------//

    @Override
    public String login(LoginRequest request, HttpSession session, Model model) {
        LoginResponse response = AccountLogic.loginLogic(request);
        model.addAttribute(response.getType(), response);
        return response.getStatus().equals("200") ? SuccessPageFor.LOGIN : FailPageFor.LOGIN;
    }

    //------------------------------------LOGOUT------------------------------------//

    @Override
    public String logout(HttpSession session) {
            session.invalidate();
        return SuccessPageFor.LOGOUT;
    }

    //--------------------------------VIEW PROFILE----------------------------------//

    @Override
    public String viewProfile(ViewProfileRequest request, Model model) {
        ViewProfileResponse response = AccountLogic.viewProfileLogic(request);
        model.addAttribute(response.getType(), response);
        return response.getStatus().equals("200") ? SuccessPageFor.VIEW_PROFILE : FailPageFor.VIEW_PROFILE;
    }


    //---------------------------------UPDATE PROFILE---------------------------------//

    @Override
    public String updateProfile(UpdateProfileRequest request, HttpSession session, Model model) {
        UpdateProfileResponse response = AccountLogic.updateProfileLogic(request);
        model.addAttribute(response.getType(), response);
        return response.getStatus().equals("200") ? SuccessPageFor.VIEW_PROFILE : FailPageFor.VIEW_PROFILE;
    }

    //---------------------------------CHANGE PASSWORD--------------------------------//

    @Override
    public String changePassword(ChangePasswordRequest request, HttpSession session, Model model) {
        ChangePasswordResponse response = AccountLogic.changePasswordLogic(request);
        model.addAttribute(response.getType(), response);
        return response.getStatus().equals("200") ? SuccessPageFor.CHANGE_PASSWORD : FailPageFor.CHANGE_PASSWORD;
    }


}
