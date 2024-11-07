package com.quynh.efep_hsf.validations;

import com.quynh.efep_hsf.enums.Status;
import com.quynh.efep_hsf.models.request_models.DisableFlowerRequest;
import com.quynh.efep_hsf.repositories.FlowerRepo;

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
