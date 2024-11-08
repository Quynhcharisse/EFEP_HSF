package com.hsf301.efep.configurations;

import com.hsf301.efep.enums.ActionCaseValues;

import java.util.HashMap;


public class ReturnPageConfig {
    private static HashMap<String, String> event;
    private static void initActionCase(){
        event = new HashMap<>();
        event.put("HOME", "");
        event.put("AUTHED_FAIL", "login");
        event.put("LOGIN_FAIL", "login");
        event.put("LOGIN_SUCCESS_CUSTOMER", "");
        event.put("LOGIN_SUCCESS_SHOP", "");
        event.put("REGISTER_FAIL", "register");
        event.put("REGISTER_SUCCESS", "login");
        event.put("SEARCH_FLOWER", "shop");
        event.put("SORT_FLOWER", "shop");
        event.put("ADD_TO_WISHLIST", "wishlist");
        event.put("UPDATE_WISHLIST", "");
        event.put("CLEAR_WISHLIST", "");
        event.put("CHECK_OUT", "");
        event.put("CREATE_FLOWER", "");
        event.put("UPDATE_FLOWER", "");
        event.put("DELETE_FLOWER", "");
        event.put("FLOWER_DETAIL", "flower/detail");
        event.put("ORDER_HISTORY", "");
        event.put("SHOP_FLOWER", "");
    }



    public static String generateReturnMapping(@ActionCase(actionCase = ActionCaseValues.HOME) ActionCaseValues actionCaseValues) {
        initActionCase();
        return makeURL(event.get(actionCaseValues.toString()));
    }

    private static String makeURL(String actionCase){
        return "redirect:/" + actionCase;
    }

    public static void main(String[] args) {
        System.out.println(generateReturnMapping(ActionCaseValues.LOGIN_FAIL));
    }
}

