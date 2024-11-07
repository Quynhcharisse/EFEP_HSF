package com.quynh.efep_hsf.enums;

import com.quynh.efep_hsf.models.entity_models.Account;
import com.quynh.efep_hsf.repositories.AccountRepo;
import jakarta.servlet.http.HttpSession;

public class Roles {

    public static final String SHOP = "shop";

    public static final String CUSTOMER = "customer";

    public static boolean checkIfThisAccountIsShop(Account account) {
        return SHOP.equals(account.getRole());
    }

    public static boolean checkIfThisAccountIsCustomer(Account account) {
        return CUSTOMER.equals(account.getRole());
    }

    public static Account getShopLoggedAccount(HttpSession session){
        return session.getAttribute("acc") != null ? (Account) session.getAttribute("acc") : null;
    }

    public static Account getCustomerLoggedAccount(int id, AccountRepo accountRepo){
        return accountRepo.findById(id).orElse(null);
    }
}
