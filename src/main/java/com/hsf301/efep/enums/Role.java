package com.hsf301.efep.enums;

import com.hsf301.efep.models.entity_models.Account;
import jakarta.servlet.http.HttpSession;

public class Role {
    public final static String BUYER = "buyer";

    public final static String SHOP = "shop";

    public static boolean checkIfThisAccountIsBuyer(Account account){
        return account.getRole().equals(BUYER);
    }

    public static boolean checkIfThisAccountIsShop(Account account){
        return account.getRole().equals(SHOP);
    }

    public  static Account getCurrentLoggedAccount(HttpSession session){
        return  session.getAttribute("acc")  != null ? (Account) session.getAttribute("acc"): null;
    }


}
