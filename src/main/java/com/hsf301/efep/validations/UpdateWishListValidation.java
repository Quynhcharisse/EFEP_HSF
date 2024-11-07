package com.quynh.efep_hsf.validations;

import com.quynh.efep_hsf.models.entity_models.Flower;
import com.quynh.efep_hsf.models.entity_models.WishlistItem;
import com.quynh.efep_hsf.models.request_models.UpdateWishListRequest;
import com.quynh.efep_hsf.repositories.FlowerRepo;
import com.quynh.efep_hsf.repositories.WishlistItemRepo;

public class UpdateWishListValidation {
    public static String validate(UpdateWishListRequest request, WishlistItemRepo wishlistItemRepo){
        WishlistItem item = wishlistItemRepo.findById(request.getWishListItemId()).orElse(null);
        if(item == null){
            return "Wishlist item not found";
        }

        if(request.getNewQty() > item.getFlower().getQuantity()){
            return "Max quantity exceeded";
        }

        return "";
    }
}
