package com.hsf301.efep.validations;

import com.hsf301.efep.enums.Status;
import com.hsf301.efep.models.request_models.DisableFlowerRequest;
import com.hsf301.efep.repositories.FlowerRepo;

public class DeleteFlowerValidation {
    public static String validate(DisableFlowerRequest request, FlowerRepo flowerRepo){

        if(!flowerRepo.existsById(request.getId())){
            return "Flower does not exist";
        }

        if(flowerRepo.findById(request.getId()).get().getStatus().equals(Status.FLOWER_DISABLE)){
            return "Flower is already disabled";
        }

        return "";
    }
}
