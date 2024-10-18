package com.hsf301.efep.serivces;

import com.hsf301.efep.models.request_models.AddToWishListRequest;
import com.hsf301.efep.models.request_models.DeleteWishlistItemRequest;
import com.hsf301.efep.models.request_models.DeleteWishlistRequest;
import com.hsf301.efep.models.request_models.UpdateWishlistRequest;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.ui.Model;

public interface BuyerService {

    String addToWishList(AddToWishListRequest request, HttpServletRequest httpServletRequest, HttpSession session, Model model);

    String viewWishlist(HttpSession session, Model model);

    String updateWishlist(UpdateWishlistRequest request, HttpSession session, Model model);

    String deleteWishlist(DeleteWishlistRequest request, HttpSession session, Model model);

    String deleteWishlistItem(DeleteWishlistItemRequest request, HttpSession session, Model model);
}
