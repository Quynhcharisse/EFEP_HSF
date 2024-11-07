package com.hsf301.efep.service_implementors;

import com.hsf301.efep.configurations.ReturnPageConfig;
import com.hsf301.efep.enums.ActionCaseValues;
import com.hsf301.efep.enums.Roles;
import com.hsf301.efep.enums.Status;
import com.hsf301.efep.models.entity_models.Account;
import com.hsf301.efep.models.entity_models.Flower;
import com.hsf301.efep.models.entity_models.Category;
import com.hsf301.efep.models.entity_models.Flower;

import com.hsf301.efep.models.entity_models.Account;

import com.hsf301.efep.models.request_models.CreateFlowerRequest;
import com.hsf301.efep.models.request_models.DisableFlowerRequest;
import com.hsf301.efep.models.request_models.UpdateFlowerRequest;
import com.hsf301.efep.models.response_models.CreateFlowerResponse;
import com.hsf301.efep.models.response_models.DisableFlowerResponse;
import com.hsf301.efep.models.response_models.UpdateFlowerResponse;
import com.hsf301.efep.repositories.CategoryRepo;
import com.hsf301.efep.repositories.FlowerRepo;
import com.hsf301.efep.services.ShopService;
import com.hsf301.efep.validations.CreateFlowerValidation;

import com.hsf301.efep.validations.CreateFlowerValidation;
import com.hsf301.efep.validations.DeleteFlowerValidation;
import com.hsf301.efep.validations.UpdateFlowerValidation;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Service
@RequiredArgsConstructor
public class ShopServiceImpl implements ShopService {

    private final FlowerRepo flowerRepo;
    private final CategoryRepo categoryRepo;


    //-------------------------------------Create Flower-------------------------------------//
    @Override
    public String createFlower(CreateFlowerRequest request, RedirectAttributes attributes, HttpSession session) {
        return null;
    }

    private CreateFlowerResponse createFlowerLogic(CreateFlowerRequest request, Account account) {
        return null;
    }

    //--------------------TEST--------------------//

    public CreateFlowerResponse createFlowerLogicTest(CreateFlowerRequest request, Account account) {
        return null;
    }

    //-------------------------------------Update Flower-------------------------------------//
    @Override
    public String updateFlower(UpdateFlowerRequest request, RedirectAttributes attributes, HttpSession session) {
        return null;
    }

    private UpdateFlowerResponse updateFlowerLogic(UpdateFlowerRequest request, Account account) {
        return null;
    }
    //--------------------TEST--------------------//

    public UpdateFlowerResponse updateFlowerLogicTest(UpdateFlowerRequest request, Account account) {
        return null;
    }

    //-------------------------------------Delete Flower-------------------------------------//
    @Override
    public String disableFlower(DisableFlowerRequest request, RedirectAttributes attributes, HttpSession session) {
        return null;
    }

    private DisableFlowerResponse disableFlowerLogic(DisableFlowerRequest request, Account account) {
        return null;
    }

    //--------------------TEST--------------------//

    public DisableFlowerResponse disableFlowerLogicTest(DisableFlowerRequest request, Account account) {
        return null;
    }
}
