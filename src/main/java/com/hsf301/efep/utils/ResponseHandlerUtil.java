package com.quynh.efep_hsf.utils;

import org.springframework.ui.Model;

public class ResponseHandlerUtil {

    public static boolean checkResponse(Object response, Class<?> classType) {
        return response.getClass().equals(classType);
    }

    public static void initResponse(Object response, String status, Model model) {
        model.addAttribute(status.equals("200") ? "msg" : "err", response);
    }
}
