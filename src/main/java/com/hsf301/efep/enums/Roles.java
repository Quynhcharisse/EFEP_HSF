package com.hsf301.efep.enums;

import com.hsf301.efep.models.entity_models.Account;
import com.hsf301.efep.repositories.AccountRepo;
import jakarta.servlet.http.HttpSession;

public class Roles {

    public static final String SHOP = "shop";
    public static final String CUSTOMER = "customer";

    public static Account getShopAccount(AccountRepo accountRepo) {
        return accountRepo.findByRole(SHOP);
    }

    public static boolean checkIfThisAccountIsShop(Account account) {
        return SHOP.equals(account.getRole());
    }

    public static boolean checkIfThisAccountIsCustomer(Account account) {
        return CUSTOMER.equals(account.getRole());
    }

    public static Account getCurrentLoggedAccount(HttpSession session){
        return session.getAttribute("account") != null ? (Account) session.getAttribute("account") : null;
    }
}
