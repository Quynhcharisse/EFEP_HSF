package com.hsf301.efep.logics;

import com.hsf301.efep.models.request_models.*;
import com.hsf301.efep.models.response_models.*;
import com.hsf301.efep.validations.*;

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

    public static RegisterResponse registerLogic(RegisterRequest request) {
        String error = RegisterValidation.validate(request);
        if (error.isEmpty()) {
            // correct case here


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
    public static UpdateProfileResponse updateProfileLogic(UpdateProfileRequest request) {
        String error = UpdateProfileValidation.validate(request);
        if (error.isEmpty()) {
            // correct case here


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
    public static ChangePasswordResponse changePasswordLogic(ChangePasswordRequest request) {
        String error = ChangePasswordValidation.validate(request);
        if (error.isEmpty()) {
            // correct case here


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
