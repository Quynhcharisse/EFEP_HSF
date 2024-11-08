package com.hsf301.efep.validations;

import com.hsf301.efep.models.entity_models.Flower;
import com.hsf301.efep.models.request_models.UpdateFlowerRequest;
import com.hsf301.efep.repositories.CategoryRepo;
import com.hsf301.efep.repositories.FlowerRepo;

public class UpdateFlowerValidation {
    public static String validate(UpdateFlowerRequest request, FlowerRepo flowerRepo, CategoryRepo categoryRepo){
        if(!flowerRepo.existsById(request.getId())){
            return "Flower does not exist";
        }

        if (flowerRepo.existsByNameAndIdNot(request.getName(), request.getId())){
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

        if(request.getDescription().length() > 256){
            return "Description must be less than 256 characters, current length is " + request.getDescription().length();
        }

        if(!categoryRepo.existsById(request.getCategoryId())){
            return "Category does not exist";
        }

        return "";
    }
}
