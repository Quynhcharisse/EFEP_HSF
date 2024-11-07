package com.hsf301.efep.validations;

import com.hsf301.efep.models.entity_models.Account;
import com.hsf301.efep.models.entity_models.Flower;
import com.hsf301.efep.models.request_models.AddToWishListRequest;
import com.hsf301.efep.repositories.FlowerRepo;

public class AddToWishListValidation {
    public static String validate(AddToWishListRequest request, FlowerRepo flowerRepo, Account account){
        Flower flower = flowerRepo.findById(request.getFlowerId()).orElse(null);
        if(flower == null){
            return "Flower not found";
        }

        if(request.getQty() > flower.getQuantity()){
            return "Max quantity exceeded";
        }



        return "";
    }
}
