package com.hsf301.efep.logics;

import com.hsf301.efep.enums.Role;
import com.hsf301.efep.models.entity_models.Account;
import com.hsf301.efep.models.entity_models.User;
import com.hsf301.efep.models.request_models.ChangePasswordRequest;
import com.hsf301.efep.models.request_models.LoginRequest;
import com.hsf301.efep.models.request_models.RegisterRequest;
import com.hsf301.efep.models.request_models.UpdateProfileRequest;
import com.hsf301.efep.models.response_models.*;
import com.hsf301.efep.repositories.AccountRepo;
import com.hsf301.efep.repositories.ShopRepo;
import com.hsf301.efep.repositories.UserRepo;
import com.hsf301.efep.validations.*;

import java.time.LocalDate;
import java.util.Optional;


public class AccountLogic {


    //--------------------------------LOGIN----------------------------------//

    public static LoginResponse loginLogic(LoginRequest request) {
        String error = LoginValidation.validate(request);
        if(!error.isEmpty()){
            LoginResponse.builder()
                    .status("400")
                    .message(error)
                    .type("err")
                    .build();
        }

        String email = ""; // change to your data
        String passwordPassword = ""; // change to your data

        return LoginResponse.builder()
                .status("200")
                .message("Login successfully")
                .type("msg")
                .build();
    }

    //--------------------------------REGISTER----------------------------------//

    public static RegisterResponse registerLogic(RegisterRequest request, AccountRepo accountRepo, UserRepo userRepo, ShopRepo shopRepo) {
        String error = RegisterValidation.validate(request);

        if (error.isEmpty()) {
            // correct case here
            Account newAccount = new Account();
            newAccount.setEmail(request.getEmail());
            newAccount.setPassword(request.getPassword());
            newAccount.setRole(Role.BUYER);
            accountRepo.save(newAccount);

            User newUser = new User();
            newUser.setAccount(newAccount);
            newUser.setName(request.getName());
            newUser.setPhone(request.getPhone());
            newUser.setCreatedDate(LocalDate.now());
            userRepo.save(newUser);
            //end of correct case
            return RegisterResponse.builder()
                    .status("200")
                    .message("Register Successfully")
                    .type("msg")
                    .build();
        }

        // fail case here

        return RegisterResponse.builder()
                .status("400")
                .message("Register Failed")
                .type("err")
                .build();

        //end of fail case

    }

    //--------------------------------VIEW PROFILE----------------------------------//
    public static ViewProfileResponse viewProfileLogic(int userId, UserRepo userRepo) {
        String error = ViewProfileValidation.validate();
        if (!error.isEmpty()) {
            // incorrect case here
            return ViewProfileResponse.builder()
                .status("400")
                .message("View Profile Failed")
                .type("err")
                .build();
            //end of correct case
        }

        // correct case here

        User user = userRepo.findById(userId).orElse(null);
        assert user != null;
        return ViewProfileResponse.builder()
                .status("200")
                .message("")
                .id(user.getId())
                .name(user.getName())
                .phone(user.getPhone())
                .type("msg")
                .build();

        //end of correct case
    }

    //--------------------------------UPDATE PROFILE----------------------------------//
    public static UpdateProfileResponse updateProfileLogic(UpdateProfileRequest request, AccountRepo accountRepo, UserRepo userRepo) {
        String error = UpdateProfileValidation.validate(request);
        if (error.isEmpty()) {
            // correct case here
            Account account = accountRepo.findById(request.getId()).orElse(null);
            assert account != null;
            User user = account.getUser();
            user.setName(request.getName());
            user.setPhone(request.getPhone());
            userRepo.save(user);
            //end of correct case

            return UpdateProfileResponse.builder()
                    .status("200")
                    .message("Update Profile Successfully")
                    .id(user.getId())
                    .name(user.getName())
                    .phone(user.getPhone())
                    .type("msg")
                    .build();
        }

        // fail case here

        return UpdateProfileResponse.builder()
                .status("400")
                .message("Update Profile Failed")
                .type("err")
                .build();

        //end of fail case

    }

    //--------------------------------CHANGE PASSWORD----------------------------------//
    public static ChangePasswordResponse changePasswordLogic(ChangePasswordRequest request, AccountRepo accountRepo) {
        String error = ChangePasswordValidation.validate(request);
        if (error.isEmpty()) {
            // correct case here

                Optional<Account> optionalAccount = accountRepo.findById(request.getId());
                if (optionalAccount.isPresent()) {
                    Account account = optionalAccount.get();
                    if (account.getPassword().equals(request.getCurrentPassword())) {
                        account.setPassword(request.getNewPassword());
                        accountRepo.save(account);
                    }
                    else{
                        return ChangePasswordResponse.builder()
                                .status("400")
                                .message("Change Password Failed")
                                .type("err")
                                .build();
                    }
                }

            //end of correct case

            int id = 0; // change to your data
            String currentPassword = ""; // change to your data
            String newPassword = ""; // change to your data
            String confirmPassword = ""; // change to your data


            return ChangePasswordResponse.builder()
                    .status("200")
                    .message("Change Password Successfully")
                    .type("msg")
                    .build();
        }

        // fail case here


        //end of fail case
        return ChangePasswordResponse.builder()
                .status("400")
                .message("Change Password Failed")
                .type("err")
                .build();
    }

}
