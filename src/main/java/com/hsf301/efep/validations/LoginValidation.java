package com.hsf301.efep.validations;

import com.hsf301.efep.models.request_models.LoginRequest;

public class LoginValidation {
    public static String validate(LoginRequest request){

        String error = "";

        //give error
        //Email
        //1. Email can empty
        if(request.getEmail().trim().isEmpty()) {
            return "Email cannot be empty.";
        }

        //2. Email does not matched
        if(!request.getEmail().matches("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$")) {
            return "Email is invalid.";
        }


        //Password
        //1. Password can empty
        if(request.getPassword().trim().isEmpty()) {
            return "Password cannot be empty.";
        }

        //2. Password does not matched
        //password is at least 8 characters long
        //password contains at least one letter and one number
        //have special word
        if(!request.getPassword().matches("^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@$!%*?&#])[A-Za-z\\d@$!%*?&#]{8,}$")) {
            return "Password is invalid";
        }

        return error;
    }
}
