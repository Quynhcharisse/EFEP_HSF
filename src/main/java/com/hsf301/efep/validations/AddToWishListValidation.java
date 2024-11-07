package com.quynh.efep_hsf.validations;

import com.quynh.efep_hsf.models.entity_models.Account;
import com.quynh.efep_hsf.models.entity_models.Flower;
import com.quynh.efep_hsf.models.request_models.AddToWishListRequest;
import com.quynh.efep_hsf.repositories.FlowerRepo;

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
