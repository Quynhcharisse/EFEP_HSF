package com.hsf301.efep.service_implementors;

import com.hsf301.efep.models.request_models.AddToWishListRequest;
import com.hsf301.efep.models.request_models.DeleteWishlistItemRequest;
import com.hsf301.efep.models.request_models.DeleteWishlistRequest;
import com.hsf301.efep.models.request_models.UpdateWishlistRequest;
import com.hsf301.efep.serivces.BuyerService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

@Service
@RequiredArgsConstructor
public class BuyerServiceImpl implements BuyerService {

    @Override
    public String viewWishlist(HttpSession session, Model model) {
        return "";
    }

    @Override
    public String addToWishList(AddToWishListRequest request, HttpServletRequest httpServletRequest, HttpSession session, Model model) {
        return "";
    }

    @Override
    public String updateWishlist(UpdateWishlistRequest request, HttpSession session, Model model) {
        return "";
    }

    @Override
    public String deleteWishlist(DeleteWishlistRequest request, HttpSession session, Model model) {
        return "";
    }

    @Override
    public String deleteWishlistItem(DeleteWishlistItemRequest request, HttpSession session, Model model) {
        return "";
    }

}
