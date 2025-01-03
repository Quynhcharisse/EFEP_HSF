package com.hsf301.efep.services;

import com.hsf301.efep.models.request_models.*;
import jakarta.servlet.http.HttpSession;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

public interface CustomerService {
    String searchFlowers(SearchFlowerRequest request, RedirectAttributes attributes);
    String sortFlowers(SortFlowerRequest request, RedirectAttributes attributes);
    String addToWishList(AddToWishListRequest request, RedirectAttributes attributes, HttpSession session);
    String updateWishList(UpdateWishListRequest request, RedirectAttributes attributes, HttpSession session);
    String clearWishList(RedirectAttributes attributes, HttpSession session);
    String checkout(CheckoutRequest request, RedirectAttributes attributes, HttpSession session);
}
