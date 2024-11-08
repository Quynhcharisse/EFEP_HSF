package com.hsf301.efep.service_implementors;

import com.hsf301.efep.configurations.ReturnPageConfig;
import com.hsf301.efep.enums.ActionCaseValues;
import com.hsf301.efep.enums.Roles;
import com.hsf301.efep.enums.Status;
import com.hsf301.efep.models.entity_models.Account;
import com.hsf301.efep.models.entity_models.Category;
import com.hsf301.efep.models.entity_models.Flower;
import com.hsf301.efep.models.request_models.*;
import com.hsf301.efep.models.response_models.*;
import com.hsf301.efep.repositories.CategoryRepo;
import com.hsf301.efep.repositories.FlowerRepo;
import com.hsf301.efep.services.ShopService;
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
        CreateFlowerResponse response = createFlowerLogic(request, Roles.getCurrentLoggedAccount(session));
        attributes.addFlashAttribute(response.getStatus().equals("200") ? "msg" : "error", response);
        if(response.getStatus().equals("403")) return ReturnPageConfig.generateReturnMapping(ActionCaseValues.AUTHED_FAIL);
        return ReturnPageConfig.generateReturnMapping(ActionCaseValues.CREATE_FLOWER);
    }

    private CreateFlowerResponse createFlowerLogic(CreateFlowerRequest request, Account account) {
        if(account == null || !Roles.checkIfThisAccountIsShop(account)) {
            return CreateFlowerResponse.builder()
                    .status("403")
                    .message("Please login a customer account first")
                    .build();
        }

        String error = CreateFlowerValidation.validate(request, flowerRepo, categoryRepo);
        if(!error.isEmpty()) {
            return CreateFlowerResponse.builder()
                    .status("400")
                    .message(error)
                    .build();
        }

        flowerRepo.save(
                Flower.builder()
                        .description(request.getDescription())
                        .flowerAmount(request.getFlowerAmount())
                        .img("https://img.freepik.com/premium-photo/default-dogwood-flowers-with-bokeh-background_1114710-193206.jpg")
                        .name(request.getName())
                        .price(request.getPrice())
                        .quantity(request.getQuantity())
                        .soldQuantity(0)
                        .status(Status.FLOWER_AVAILABLE)
                        .category(categoryRepo.findById(request.getCategoryId()).get())
                        .seller(account.getUser().getSeller())
                        .build()
        );

        return CreateFlowerResponse.builder().status("200").message("Create flower successfully").build();
    }

    //--------------------TEST--------------------//

    public CreateFlowerResponse createFlowerLogicTest(CreateFlowerRequest request, Account account) {
        if(account == null || !Roles.checkIfThisAccountIsShop(account)) {
            return CreateFlowerResponse.builder()
                    .status("403")
                    .message("Please login a customer account first")
                    .build();
        }

        String error = CreateFlowerValidation.validate(request, flowerRepo, categoryRepo);
        if(!error.isEmpty()) {
            return CreateFlowerResponse.builder()
                    .status("400")
                    .message(error)
                    .build();
        }

        flowerRepo.save(
                Flower.builder()
                        .description(request.getDescription())
                        .flowerAmount(request.getFlowerAmount())
                        .img("https://img.freepik.com/premium-photo/default-dogwood-flowers-with-bokeh-background_1114710-193206.jpg")
                        .name(request.getName())
                        .price(request.getPrice())
                        .quantity(request.getQuantity())
                        .soldQuantity(0)
                        .status(Status.FLOWER_AVAILABLE)
                        .category(categoryRepo.findById(request.getCategoryId()).get())
                        .seller(account.getUser().getSeller())
                        .build()
        );

        return CreateFlowerResponse.builder().status("200").message("Create flower successfully").build();
    }

    //-------------------------------------Update Flower-------------------------------------//
    @Override
    public String updateFlower(UpdateFlowerRequest request, RedirectAttributes attributes, HttpSession session) {
        UpdateFlowerResponse response = updateFlowerLogic(request, Roles.getCurrentLoggedAccount(session));
        attributes.addFlashAttribute(response.getStatus().equals("200") ? "msg" : "error", response);
        if(response.getStatus().equals("403")) return ReturnPageConfig.generateReturnMapping(ActionCaseValues.AUTHED_FAIL);
        return ReturnPageConfig.generateReturnMapping(ActionCaseValues.UPDATE_FLOWER);
    }

    private UpdateFlowerResponse updateFlowerLogic(UpdateFlowerRequest request, Account account) {
        if(account == null || !Roles.checkIfThisAccountIsShop(account)) {
            return UpdateFlowerResponse.builder()
                    .status("403")
                    .message("Please login a customer account first")
                    .build();
        }

        String error = UpdateFlowerValidation.validate(request, flowerRepo, categoryRepo);
        if(!error.isEmpty()) {
            return UpdateFlowerResponse.builder()
                    .status("400")
                    .message(error)
                    .build();
        }

        Flower flower = flowerRepo.findById(request.getId()).get();
        Category category = categoryRepo.findById(request.getCategoryId()).get();
        flower.setName(request.getName());
        flower.setPrice(request.getPrice());
        flower.setQuantity(request.getQuantity());
        flower.setFlowerAmount(request.getFlowerAmount());
        flower.setDescription(request.getDescription());
        flower.setCategory(category);
        flowerRepo.save(flower);

        return UpdateFlowerResponse.builder().status("200").message("Update flower successfully").build();
    }
    //--------------------TEST--------------------//

    public UpdateFlowerResponse updateFlowerLogicTest(UpdateFlowerRequest request, Account account) {
        if(account == null || !Roles.checkIfThisAccountIsShop(account)) {
            return UpdateFlowerResponse.builder()
                    .status("403")
                    .message("Please login a customer account first")
                    .build();
        }

        String error = UpdateFlowerValidation.validate(request, flowerRepo, categoryRepo);
        if(!error.isEmpty()) {
            return UpdateFlowerResponse.builder()
                    .status("400")
                    .message(error)
                    .build();
        }

        Flower flower = flowerRepo.findById(request.getId()).get();
        Category category = categoryRepo.findById(request.getCategoryId()).get();
        flower.setName(request.getName());
        flower.setPrice(request.getPrice());
        flower.setQuantity(request.getQuantity());
        flower.setFlowerAmount(request.getFlowerAmount());
        flower.setDescription(request.getDescription());
        flower.setCategory(category);
        flowerRepo.save(flower);

        return UpdateFlowerResponse.builder().status("200").message("Update flower successfully").build();
    }

    //-------------------------------------Delete Flower-------------------------------------//
    @Override
    public String disableFlower(DisableFlowerRequest request, RedirectAttributes attributes, HttpSession session) {
        DisableFlowerResponse response = disableFlowerLogic(request, Roles.getCurrentLoggedAccount(session));
        attributes.addFlashAttribute(response.getStatus().equals("200") ? "msg" : "error", response);
        if(response.getStatus().equals("403")) return ReturnPageConfig.generateReturnMapping(ActionCaseValues.AUTHED_FAIL);
        return ReturnPageConfig.generateReturnMapping(ActionCaseValues.DELETE_FLOWER);
    }

    private DisableFlowerResponse disableFlowerLogic(DisableFlowerRequest request, Account account) {
        if(account == null || !Roles.checkIfThisAccountIsShop(account)) {
            return DisableFlowerResponse.builder()
                    .status("403")
                    .message("Please login a customer account first")
                    .build();
        }

        String error = DeleteFlowerValidation.validate(request, flowerRepo);
        if(!error.isEmpty()) {
            return DisableFlowerResponse.builder()
                    .status("400")
                    .message(error)
                    .build();
        }

        Flower flower = flowerRepo.findById(request.getId()).get();
        flower.setStatus(Status.FLOWER_DISABLE);
        flowerRepo.save(flower);

        return DisableFlowerResponse.builder().status("200").message("Disable successfully").build();
    }

    //--------------------TEST--------------------//

    public DisableFlowerResponse disableFlowerLogicTest(DisableFlowerRequest request, Account account) {
        if(account == null || !Roles.checkIfThisAccountIsShop(account)) {
            return DisableFlowerResponse.builder()
                    .status("403")
                    .message("Please login a customer account first")
                    .build();
        }

        String error = DeleteFlowerValidation.validate(request, flowerRepo);
        if(!error.isEmpty()) {
            return DisableFlowerResponse.builder()
                    .status("400")
                    .message(error)
                    .build();
        }

        Flower flower = flowerRepo.findById(request.getId()).get();
        flower.setStatus(Status.FLOWER_DISABLE);
        flowerRepo.save(flower);

        return DisableFlowerResponse.builder().status("200").message("Disable successfully").build();
    }
}
