package com.hsf301.efep.service_implementors;

import com.hsf301.efep.enums.PageName;
import com.hsf301.efep.models.request_models.LoginRequest;
import com.hsf301.efep.models.response_models.LoginResponse;
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

    @Override
    public String login(LoginRequest request, HttpSession session, Model model) {
        LoginResponse output = loginLogic(request);
        model.addAttribute(output.getStatus().equals("200") ? "msg" : "error", output);
        if (output.getStatus().equals("200")) {
            session.setAttribute("acc", accountRepo.findByEmailAndPassword(request.getEmail(), request.getPassword()).get());
            return PageName.LOGIN_SUCCESSFUL_PAGE;
        }
        return PageName.LOGIN_FAILED_PAGE;
    }

    private LoginResponse loginLogic(LoginRequest request) {
        String error = LoginValidation.validate(request);
        if(!error.isEmpty()){
            LoginResponse.builder()
                    .status("400")
                    .message(error)
                    .build();
        }

        return LoginResponse.builder()
                .status("200")
                .message("Login successfully")
                .build();
    }

    //-------------------LOGIN------------------//

}
