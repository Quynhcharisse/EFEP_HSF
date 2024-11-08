package com.hsf301.efep.validations;

import com.hsf301.efep.models.request_models.RegisterRequest;
import com.hsf301.efep.repositories.AccountRepo;
import com.hsf301.efep.repositories.UserRepo;

public class RegisterValidation {
    public static String validate(RegisterRequest request, UserRepo userRepo, AccountRepo accountRepo){
        if(!request.getEmail().matches("^[a-zA-Z0-9]+@[a-zA-Z0-9]+\\.[a-z]{2,}(\\.[a-z]{2,})?$")){
            return "Email is invalid";
        }

        if(accountRepo.existsByEmail(request.getEmail())){
            return "Email is already in use";
        }

        if(!request.getPassword().matches("^(?=.*[A-Z])(?=.*\\d)(?=.*[^a-zA-Z\\d]).{8,16}$")){
            return "Password must be 8 to 16 characters and contain at least 1 uppercase letter, 1 number and 1 special character";
        }

        if(userRepo.existsByPhone(request.getPhone())){
            return "Phone number is already in use";
        }

        if(!request.getConfirmPassword().equals(request.getPassword())){
            return "Confirmed password is not matched password";
        }

        return "";
    }
}
