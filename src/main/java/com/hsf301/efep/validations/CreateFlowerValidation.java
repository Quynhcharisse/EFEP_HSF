package com.quynh.efep_hsf.validations;

import com.quynh.efep_hsf.models.request_models.CreateFlowerRequest;
import com.quynh.efep_hsf.repositories.CategoryRepo;
import com.quynh.efep_hsf.repositories.FlowerRepo;

public class CreateFlowerValidation {
    public static String validate(CreateFlowerRequest request, FlowerRepo flowerRepo, CategoryRepo categoryRepo){
        if(flowerRepo.existsByName(request.getName())){
            return "Name is already in use";
        }

        if(request.getPrice() <= 0){
            return "Price must be greater than 0";
        }

        if(request.getQuantity() < 0){
            return "Quantity must be greater than or equal 0";
        }

        if(request.getFlowerAmount() <= 0){
            return "Flower amount must be greater than 0";
        }

        if(!categoryRepo.existsById(request.getCategoryId())){
            return "Category does not exist";
        }
        return "";
    }
}
