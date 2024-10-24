package com.hsf301.efep.validations;

import com.hsf301.efep.models.request_models.RegisterRequest;
import com.hsf301.efep.repositories.AccountRepo;

public class RegisterValidation {

    public static String validate(RegisterRequest request, AccountRepo accountRepo) {
        String error = "";
        //code validate here

        // Name
        // 1. Name must require
        if (request.getName().isEmpty()) {
            return "Name cannot be empty";
        }

        //2. Check name exist in DB
        if (accountRepo.findByUserName(request.getName()).isPresent()) {
            return "Name already exists";
        }

        // Phone
        //1. Phone must require
        if (request.getPhone().isEmpty()) {
            return "Phone cannot be empty";
        }

        //2. Phone must be 10 digit
        if (!request.getPhone().matches("\\d{10}")) {
            return "Phone number must be 10 digits";
        }

        //3. Check Phone exist in DB
        if (accountRepo.findByUserPhone(request.getPhone()).isPresent()) {
            return "Phone already exists";
        }


        //Email
        if (request.getEmail().isEmpty()) {
            return "Email cannot be empty";
        }

        if (!request.getEmail().matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$")) {
            return "Email is in invalid format";
        }

        if (accountRepo.findByEmail(request.getEmail()).isPresent()) {
            return "Email already exists";
        }

        //password is equal confirmed password
        //password isn't equal confirmed password
        if (request.getPassword().isEmpty()) {
            return "Password cannot be empty";
        }

        if (!request.getPassword().matches("^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@$!%*#?&])[A-Za-z\\d@$!%*#?&]{8,}$")) {
            return "Password is invalid format";
        }

        if (!request.getPassword().equals(request.getConfirmPassword())) {
            return "Confirmed password doesn't match the password";

        }

        return error;
    }
}
