package com.hsf301.efep.controllers;

import com.hsf301.efep.models.request_models.AddToWishListRequest;
import com.hsf301.efep.serivces.BuyerService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/buyer")
public class BuyerController {

    private final BuyerService buyerService;

    @PostMapping("/wishlist")
    public String wishlist(AddToWishListRequest request, HttpServletRequest httpServletRequest, Model model, HttpSession session) {
        return buyerService.addToWishList(request, httpServletRequest, session, model);
    }

}
