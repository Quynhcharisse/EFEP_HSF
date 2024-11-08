package com.hsf301.efep.validations;

import com.hsf301.efep.models.request_models.GetFlowerDetailRequest;
import com.hsf301.efep.repositories.FlowerRepo;

public class GetFlowerDetailValidation {
    public static String validate(GetFlowerDetailRequest request, FlowerRepo flowerRepo){
        if(!flowerRepo.existsById(request.getId())){
            return "Flower does not exist";
        }

        return "";
    }
}
