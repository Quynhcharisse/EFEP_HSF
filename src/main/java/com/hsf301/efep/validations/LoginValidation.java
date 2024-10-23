package com.hsf301.efep.validations;

import com.hsf301.efep.models.request_models.LoginRequest;

public class LoginValidation {
    public static String validate(LoginRequest request){
        String error = "";

        // Check if email is not empty
        if(request.getEmail().trim().isEmpty()) {
            return "Email cannot be empty.";
        }

        // Validate email format
        if(!request.getEmail().matches("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$")) {
            return "Email is invalid.";
        }

        // Check if password is not empty
        if(request.getPassword().trim().isEmpty()) {
            return "Password cannot be empty.";
        }

        // Ensure password is at least 8 characters long
        if(request.getPassword().length() < 8) {
            return "Password must be at least 8 characters long.";
        }

        // Ensure password contains at least one letter and one number
        if(!request.getPassword().matches("^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,}$")) {
            return "Password must contain both letters and numbers.";
        }

        // Optional: Ensure password contains at least one special character
        if(!request.getPassword().matches("^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@$!%*?&#])[A-Za-z\\d@$!%*?&#]{8,}$")) {
            return "Password must include at least one special character.";
        }

        return error;
    }
}
