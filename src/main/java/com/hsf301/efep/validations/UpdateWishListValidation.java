package com.hsf301.efep.validations;

import com.hsf301.efep.models.entity_models.Flower;
import com.hsf301.efep.models.entity_models.WishlistItem;
import com.hsf301.efep.models.request_models.UpdateWishListRequest;
import com.hsf301.efep.repositories.FlowerRepo;
import com.hsf301.efep.repositories.WishlistItemRepo;

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
