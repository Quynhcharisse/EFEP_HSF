package com.hsf301.efep.validations;

import com.hsf301.efep.models.request_models.CreateFlowerRequest;
import com.hsf301.efep.repositories.CategoryRepo;
import com.hsf301.efep.repositories.FlowerRepo;

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
