package com.quynh.efep_hsf.service_implementors;

import com.quynh.efep_hsf.enums.Roles;
import com.quynh.efep_hsf.models.entity_models.Account;
import com.quynh.efep_hsf.models.request_models.LoginRequest;
import com.quynh.efep_hsf.models.request_models.RegisterRequest;
import com.quynh.efep_hsf.models.response_models.LoginResponse;
import com.quynh.efep_hsf.repositories.AccountRepo;
import com.quynh.efep_hsf.services.AccountService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {
    private final AccountRepo accountRepo;

    //-----------------Login----------------------//

    @Override
    public String login(LoginRequest request, HttpSession session, RedirectAttributes redirectAttributes) {
        Account account = accountRepo.findByEmailAndPassword(request.getEmail(), request.getPassword()).orElse(null);
        if (account == null) {
            redirectAttributes.addFlashAttribute("response", LoginResponse.builder().status("400").message("Email or password is incorrect").build());
            return "redirect:/login";
        }
        session.setAttribute("account", account);
        if(Roles.checkIfThisAccountIsCustomer(account)) {
            return "redirect:/";
        }
        return "redirect:/";
    }

    //-----------------Register----------------------//

    @Override
    public String register(RegisterRequest request, RedirectAttributes redirectAttributes) {
        return "";
    }

    //-----------------Logout----------------------//

    @Override
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/";
    }

}
