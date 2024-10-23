package com.hsf301.efep.logics;

import com.hsf301.efep.enums.Role;
import com.hsf301.efep.models.entity_models.Account;
import com.hsf301.efep.models.entity_models.Shop;
import com.hsf301.efep.models.entity_models.User;
import com.hsf301.efep.models.request_models.*;
import com.hsf301.efep.models.response_models.*;
import com.hsf301.efep.repositories.AccountRepo;
import com.hsf301.efep.repositories.ShopRepo;
import com.hsf301.efep.repositories.UserRepo;
import com.hsf301.efep.validations.*;
import jakarta.mail.Session;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.ui.Model;

import java.time.LocalDate;
import java.util.Optional;


public class AccountLogic {


    //--------------------------------LOGIN----------------------------------//

    public static LoginResponse loginLogic(LoginRequest request, HttpSession session) {
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
            //newAccount.setRole(request.getRole());
            newAccount.setRole(Role.ACCOUNT_BUYER);
            accountRepo.save(newAccount);

            User newUser = new User();
            newUser.setAccount(newAccount);
            newUser.setName(request.getName());
            newUser.setPhone(request.getPhone());
            newUser.setAvatar(request.getAvatar());
            newUser.setBackground(request.getBackground());
            newUser.setCreatedDate(LocalDate.now());
            userRepo.save(newUser);

//            if(newAccount.getRole().equals(Role.ACCOUNT_SHOP)){
//                Shop newShop = new Shop();
//                newShop.setUser(newUser);
//                shopRepo.save(newShop);
//            }
            //end of correct case

            String name = "";// change to your data
            String email = ""; // change to your data
            String phone = ""; // change to your data
            String avatar = ""; // change to your data
            String background = ""; // change to your data
            String password = ""; // change to your data
            String confirmPassword = ""; // change to your data


            return RegisterResponse.builder()
                    .status("200")
                    .message("Register Successfully")
                    .type("msg")
                    .build();
        }

        // fail case here


        //end of fail case
        return RegisterResponse.builder()
                .status("400")
                .message("Register Failed")
                .type("err")
                .build();
    }

    //--------------------------------VIEW PROFILE----------------------------------//
    public static ViewProfileResponse viewProfileLogic(ViewProfileRequest request) {
        String error = ViewProfileValidation.validate(request);
        if (error.isEmpty()) {
            // correct case here


            //end of correct case

            int id = 0; // change to your data
            String name = ""; // change to your data
            String phone = ""; // change to your data
            String avatar = ""; // change to your data
            String background = ""; // change to your data

            return ViewProfileResponse.builder()
                    .status("200")
                    .message("View Profile Successfully")
                    .type("msg")
                    .id(id)
                    .name(name)
                    .phone(phone)
                    .avatar(avatar)
                    .background(background)
                    .build();
        }

        // fail case here


        //end of fail case
        return ViewProfileResponse.builder()
                .status("400")
                .message("View Profile Failed")
                .type("err")
                .build();
    }

    //--------------------------------UPDATE PROFILE----------------------------------//
    public static UpdateProfileResponse updateProfileLogic(UpdateProfileRequest request, AccountRepo accountRepo, UserRepo userRepo) {
        String error = UpdateProfileValidation.validate(request);
        if (error.isEmpty()) {
            // correct case here
            Optional<User> optionalUser = userRepo.findById(request.getId());
            if(optionalUser.isPresent()){
                User user = optionalUser.get();
                user.setName(request.getName());
                user.setPhone(request.getPhone());
                user.setAvatar(request.getAvatar());
                user.setBackground(request.getBackground());
                userRepo.save(user);
            } else {
                return UpdateProfileResponse.builder()
                        .status("404")
                        .message("User not found")
                        .type("err")
                        .build();
            }

            //end of correct case

            int id = 0; // change to your data
            String name = ""; // change to your data
            String phone = ""; // change to your data
            String avatar = ""; // change to your data
            String background = ""; // change to your data

            return UpdateProfileResponse.builder()
                    .status("200")
                    .message("Update Profile Successfully")
                    .type("msg")
                    .id(id)
                    .name(name)
                    .phone(phone)
                    .avatar(avatar)
                    .background(background)
                    .build();
        }

        // fail case here


        //end of fail case
        return UpdateProfileResponse.builder()
                .status("400")
                .message("Update Profile Failed")
                .type("err")
                .build();
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
