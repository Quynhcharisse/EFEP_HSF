package com.hsf301.efep.validations;

import com.hsf301.efep.models.request_models.LoginRequest;  
import com.hsf301.efep.models.entity_requests.RegisterRequest;
import com.hsf301.efep.repositories.AccountRepo;
import lombok.RequiredArgsConstructor;


public class RegisterValidation {

    private static AccountRepo accountRepo;

    public static String validate(RegisterRequest request) {
            String error = "";

        // Email Validations
        if (request.getEmail().trim().isEmpty()) {
            return "Email cannot be empty.";
        }
        if (!request.getEmail().matches("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$")) {
            return "Email is invalid.";
        }
        if (accountRepo.findByEmail(request.getEmail()) != null) {
            return "The email is already registered.";
        }

        // Password Validations
        if (request.getPassword().trim().isEmpty()) {
            return "Password cannot be empty.";
        }
        if (request.getPassword().length() < 8) {
            return "Password must be at least 8 characters long.";
        }
        if (!request.getPassword().matches("^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,}$")) {
            return "Password must contain both letters and numbers.";
        }
        if (!request.getPassword().matches("^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@$!%*?&#])[A-Za-z\\d@$!%*?&#]{8,}$")) {
            return "Password must include at least one special character.";
        }

        // Confirm Password Validation
        if (!request.getPassword().equals(request.getConfirmPassword())) {
            return "Password and confirm password do not match.";
        }
            return error;
        }
}
