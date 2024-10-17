package com.hsf301.efep.serivces;

import com.hsf301.efep.models.request_models.AddToWishListRequest;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.ui.Model;

public interface BuyerService {

    String addToWishList(AddToWishListRequest request, HttpServletRequest httpServletRequest, HttpSession session, Model model);
}
