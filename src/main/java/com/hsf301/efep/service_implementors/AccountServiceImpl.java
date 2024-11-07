package com.quynh.efep_hsf.service_implementors;

import com.quynh.efep_hsf.configurations.ReturnPageConfig;
import com.quynh.efep_hsf.enums.ActionCaseValues;
import com.quynh.efep_hsf.enums.Roles;
import com.quynh.efep_hsf.enums.Status;
import com.quynh.efep_hsf.models.entity_models.Account;
import com.quynh.efep_hsf.models.entity_models.User;
import com.quynh.efep_hsf.models.entity_models.Wishlist;
import com.quynh.efep_hsf.models.request_models.LoginRequest;
import com.quynh.efep_hsf.models.request_models.RegisterRequest;
import com.quynh.efep_hsf.models.response_models.LoginResponse;
import com.quynh.efep_hsf.models.response_models.RegisterResponse;
import com.quynh.efep_hsf.repositories.AccountRepo;
import com.quynh.efep_hsf.repositories.UserRepo;
import com.quynh.efep_hsf.repositories.WishlistRepo;
import com.quynh.efep_hsf.services.AccountService;
import com.quynh.efep_hsf.validations.RegisterValidation;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDate;
import java.util.ArrayList;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {
    private final AccountRepo accountRepo;
    private final UserRepo userRepo;
    private final WishlistRepo wishlistRepo;

    //-------------------------------------Login-------------------------------------//

    @Override
    public String login(LoginRequest request, HttpSession session, RedirectAttributes redirectAttributes) {
        LoginResponse response = loginLogic(request);
        if (response.getStatus().equals("400")) {
            redirectAttributes.addFlashAttribute("error", response);
            return ReturnPageConfig.generateReturnMapping(ActionCaseValues.LOGIN_FAIL);
        }
        Account account = accountRepo.findByEmailAndPassword(request.getEmail(), request.getPassword()).get();
        session.setAttribute("account", account);
        redirectAttributes.addFlashAttribute("msg", response);
        if (Roles.checkIfThisAccountIsCustomer(account)) {
            return ReturnPageConfig.generateReturnMapping(ActionCaseValues.LOGIN_SUCCESS_CUSTOMER);
        }
        return ReturnPageConfig.generateReturnMapping(ActionCaseValues.LOGIN_SUCCESS_SHOP);
    }

    private LoginResponse loginLogic(LoginRequest request) {
        Account account = accountRepo.findByEmailAndPassword(request.getEmail(), request.getPassword()).orElse(null);
        if (account == null) {
            return LoginResponse.builder().status("400").message("Email or password is incorrect").build();
        }
        return LoginResponse.builder().status("200").message("Login successfully").build();
    }

    //--------------------TEST--------------------//

    public LoginResponse loginLogicTest(LoginRequest request) {
        Account account = accountRepo.findByEmailAndPassword(request.getEmail(), request.getPassword()).orElse(null);
        if (account == null) {
            return LoginResponse.builder().status("400").message("Email or password is incorrect").build();
        }
        return LoginResponse.builder().status("200").message("Login successfully").build();
    }


    //-------------------------------------Register-------------------------------------//

    @Override
    public String register(RegisterRequest request, RedirectAttributes redirectAttributes) {
        RegisterResponse response = registerLogic(request);
        if (response.getStatus().equals("400")) {
            redirectAttributes.addFlashAttribute("error", response);
            return ReturnPageConfig.generateReturnMapping(ActionCaseValues.REGISTER_FAIL);
        }
        redirectAttributes.addFlashAttribute("msg", response);
        return ReturnPageConfig.generateReturnMapping(ActionCaseValues.REGISTER_SUCCESS);
    }

    private RegisterResponse registerLogic(RegisterRequest request) {
        String error = RegisterValidation.validate(request, userRepo, accountRepo);
        if (!error.isEmpty()) {
            return RegisterResponse.builder().status("400").message(error).build();
        }
        Account acc = accountRepo.save(
                Account.builder()
                        .status(Status.ACCOUNT_ACTIVE)
                        .email(request.getEmail())
                        .password(request.getPassword())
                        .role(Roles.CUSTOMER)
                        .build()
        );

        User user = userRepo.save(
                User.builder()
                        .account(acc)
                        .name(request.getName())
                        .phone(request.getPhone())
                        .avatar("/img/userImg.png")
                        .background("")
                        .createdDate(LocalDate.now())
                        .build()
        );

        acc.setUser(user);
        accountRepo.save(acc);

        Wishlist wishlist = wishlistRepo.save(
                Wishlist.builder()
                        .user(user)
                        .wishlistItemList(new ArrayList<>())
                        .build()
        );

        user.setWishlist(wishlist);
        userRepo.save(user);

        return RegisterResponse.builder().status("200").message("Register successfully").build();
    }

    //--------------------TEST--------------------//

    public RegisterResponse registerLogicTest(RegisterRequest request) {
        String error = RegisterValidation.validate(request, userRepo, accountRepo);
        if (!error.isEmpty()) {
            return RegisterResponse.builder().status("400").message(error).build();
        }
        Account acc = accountRepo.save(
                Account.builder()
                        .status(Status.ACCOUNT_ACTIVE)
                        .email(request.getEmail())
                        .password(request.getPassword())
                        .role(Roles.CUSTOMER)
                        .build()
        );

        User user = userRepo.save(
                User.builder()
                        .account(acc)
                        .name(request.getName())
                        .phone(request.getPhone())
                        .avatar("https://www.svgrepo.com/show/384670/account-avatar-profile-user.svg")
                        .background("")
                        .createdDate(LocalDate.now())
                        .build()
        );

        acc.setUser(user);
        accountRepo.save(acc);

        Wishlist wishlist = wishlistRepo.save(
                Wishlist.builder()
                        .user(user)
                        .wishlistItemList(new ArrayList<>())
                        .build()
        );

        user.setWishlist(wishlist);
        userRepo.save(user);

        return RegisterResponse.builder().status("200").message("Register successfully").build();
    }

    //-------------------------------------Logout-------------------------------------//

    @Override
    public String logout(HttpSession session) {
        session.invalidate();
        return ReturnPageConfig.generateReturnMapping(ActionCaseValues.HOME);
    }
}
