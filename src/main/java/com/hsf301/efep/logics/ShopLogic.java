package com.hsf301.efep.logics;

import com.hsf301.efep.enums.Role;
import com.hsf301.efep.enums.Status;
import com.hsf301.efep.models.entity_models.Account;
import com.hsf301.efep.models.entity_models.Flower;
import com.hsf301.efep.models.entity_models.FlowerImage;
import com.hsf301.efep.models.request_models.*;
import com.hsf301.efep.models.response_models.*;
import com.hsf301.efep.repositories.AccountRepo;
import com.hsf301.efep.repositories.FlowerImageRepo;
import com.hsf301.efep.repositories.FlowerRepo;
import com.hsf301.efep.validations.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class ShopLogic {
    private final FlowerRepo flowerRepo;
    private final AccountRepo accountRepo;
    private final FlowerImageRepo flowerImageRepo;
    //-----------------------------------------CREATE FLOWER----------------------------------//

    public CreateFlowerResponse createFlowerLogic(CreateFlowerRequest request) {
        String error = CreateFlowerValidation.validate(request);
        Account account = Role.getCurrentLoggedAccount(request.getAccountId(), accountRepo);
        assert account != null;
        // Trường hợp không có lỗi
        if (error.isEmpty()) {
            // correct case here
            Flower flower = Flower.builder()
                    .name(request.getName())
                    .price(request.getPrice())
                    .shop(account.getUser().getShop())
                    .description(request.getDescription())
                    .flowerAmount(request.getFlowerAmount())
                    .quantity(request.getQuantity())
                    .soldQuantity(0)
                    .status(Status.FLOWER_STATUS_AVAILABLE)
                    .build();
            flowerRepo.save(flower);
            //end of correct case
            addFlowerImages(request, flower);

            return CreateFlowerResponse.builder()
                    .status("200")
                    .message("Create Flower Successfully")
                    .type("msg")
                    .build();
        }
        // fail case here
        //end of fail case
        // Trường hợp có lỗi
        return CreateFlowerResponse.builder()
                .status("400")
                .message("Create Flower Failed")
                .type("err")
                .build();
    }

    private void addFlowerImages(CreateFlowerRequest request, Flower flower) {
        if (request.getImgList() == null) {
            List<String> imgList = new ArrayList<>();
            imgList.add("/img/noImg.png");
            request.setImgList(imgList);
        }
        List<FlowerImage> flowerImages = request.getImgList().stream()
                .map(link -> FlowerImage.builder()
                        .flower(flower)
                        .link(link)
                        .build())
                .collect(Collectors.toList());
        flowerImageRepo.saveAll(flowerImages);
    }


    //---------------------------------------VIEW FLOWER FOR SHOP---------------------------------//

    public ViewFlowerListResponse viewFlowerForShopLogic(int sellerId) {
        List<Flower> flowers = flowerRepo.findByShop_Id(sellerId);
        // Trường hợp không có lỗi
        if(flowers != null){
            // correct case here
            return ViewFlowerListResponse.builder()
                    .status("200")
                    .message("Number of flower" + flowers.size())
                    .flowerList(viewFlowerList(flowers))
                    .type("msg")
                    .build();

            //end of correct case
        }

        // fail case here
        return ViewFlowerListResponse.builder()
                .status("400")
                .message("View Flower Failed")
                .type("err")
                .build();
        //end of fail case

    }

    private List<ViewFlowerListResponse.Flower> viewFlowerList(List<Flower> flowers) {
        return flowers.stream()
                .map(item -> ViewFlowerListResponse.Flower.builder()
                        .id(item.getId())
                        .name(item.getName())
                        .price(item.getPrice())
                        .description(item.getDescription())
                        .flowerImageList(viewImageList(item.getFlowerImageList()))
                        .flowerAmount(item.getFlowerAmount())
                        .quantity(item.getQuantity())
                        .soldQuantity(item.getSoldQuantity())
                        .status(item.getStatus())
                        .build())
                .toList();
    }

    private List<ViewFlowerListResponse.Image> viewImageList(List<FlowerImage> imageList) {
        return imageList.stream()
                .map(img -> ViewFlowerListResponse.Image.builder()
                        .link(img.getLink())
                        .build())
                .toList();
    }

//-----------------------------------------UPDATE FLOWER----------------------------------//

    public UpdateFlowerResponse updateFlowerLogic(UpdateFlowerRequest request) {
        String error = UpdateFlowerValidation.validate(request);

        // Trường hợp không có lỗi
        if (error.isEmpty()) {
            // correct case here
            Flower flower = flowerRepo.findById(request.getFlowerId())
                    .orElseThrow(()-> new RuntimeException("Flower not found with id: "+ request.getFlowerId()));

            flower.setName(request.getName());
            flower.setPrice(request.getPrice());
            flower.setDescription(request.getDescription());
            flower.setFlowerAmount(request.getFlowerAmount());
            flower.setQuantity(request.getQuantity());
            flower.setStatus(request.getStatus());
            flowerRepo.save(flower);

            updateFlowerImages(request, flower);

            return UpdateFlowerResponse.builder()
                    .status("200")
                    .message("Update Flower List Successfully")
                    .type("msg")
                    .build();

            //end of correct case
        }
        // fail case here
        return UpdateFlowerResponse.builder()
                .status("400")
                .message("Update Flower List Failed")
                .type("err")
                .build();
        //end of fail case
    }

    private void updateFlowerImages(UpdateFlowerRequest request, Flower flower) {
        List<FlowerImage> flowerImages = request.getFlowerImageList().stream()
                .map(link -> FlowerImage.builder()
                        .flower(flower)
                        .link(link.getLink())
                        .build())
                .collect(Collectors.toList());
        flowerImageRepo.saveAll(flowerImages);
    }


    //--------------------------------------DELETE FLOWER-----------------------------------//

    public DeleteFlowerResponse deleteFlowerLogic(DeleteFlowerRequest request) {
        String error = "";

        // Trường hợp không có lỗi
        if (error.isEmpty()) {
            Flower flower = flowerRepo.findById(request.getFlowerId()).orElse(null);
            assert flower != null;
            flower.setStatus(Status.FLOWER_STATUS_DELETED);
            flowerRepo.save(flower);
            // correct case here
            return DeleteFlowerResponse.builder()
                    .status("200")
                    .message(flower.getName() + " has been deleted" + "(" + flower.getStatus() + ")")
                    .type("msg")
                    .build();
            //end of correct case
        }
        // fail case here
        return DeleteFlowerResponse.builder()
                .status("400")
                .message("Please login a seller account to do this action")
                .type("err")
                .build();
        //end of fail case
        // Trường hợp có lỗi
    }

    //----------ORDER FOR SHOP(SELLER SHOP)------------//
    //-------------------------------------CHANGE ORDER STATUS------------------------------------//

    public ChangeOrderStatusResponse changeOrderStatusLogic(ChangeOrderStatusRequest request) {
        String error = ChangeOrderStatusValidation.validate(request);

        // Trường hợp không có lỗi
        if (error.isEmpty()) {
            // correct case here
            return ChangeOrderStatusResponse.builder()
                    .status("200")
                    .message("Change Order Status Successfully")
                    .type("msg")
                    .build();
            //end of correct case
        }

        // fail case here
        return ChangeOrderStatusResponse.builder()
                .status("400")
                .message("Change Order Status Failed")
                .type("err")
                .build();
        //end of fail case
        // Trường hợp có lỗi

    }

    //-------------------------VIEW ORDER DETAIL---------------------//

    public ViewOrderDetailResponse viewOrderDetailLogic(ViewOrderDetailRequest request) {
        String error = ViewOrderDetailValidation.validate(request);

        // Trường hợp không có lỗi
        if (error.isEmpty()) {
            // correct case here
            return ViewOrderDetailResponse.builder()
                    .status("200")
                    .message("View Order Detail Successfully")
                    .type("msg")
                    .build();
            //end of correct case
        }

        // fail case here
        return ViewOrderDetailResponse.builder()
                .status("400")
                .message("View Order Detail Failed")
                .type("err")
                .build();
        //end of fail case
        // Trường hợp có lỗi

    }

    //-------------------------VIEW ORDER LIST-------------------------//

    public ViewOrderListResponse viewOrderList(int accountId) {
        String error = ViewOrderListValidation.validate();

        // Trường hợp không có lỗi
        if (error.isEmpty()) {
            // correct case here
            return ViewOrderListResponse.builder()
                    .status("200")
                    .message("View Order List Successfully")
                    .type("msg")
                    .build();
            //end of correct case
        }

        // fail case here
        return ViewOrderListResponse.builder()
                .status("400")
                .message("View Order List Failed")
                .type("err")
                .build();
        //end of fail case
        // Trường hợp có lỗi

    }
}
