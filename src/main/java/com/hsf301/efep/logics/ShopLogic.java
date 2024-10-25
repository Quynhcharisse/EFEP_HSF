package com.hsf301.efep.logics;

import com.hsf301.efep.enums.Status;
import com.hsf301.efep.models.entity_models.Flower;
import com.hsf301.efep.models.request_models.*;
import com.hsf301.efep.models.response_models.*;
import com.hsf301.efep.repositories.AccountRepo;
import com.hsf301.efep.repositories.FlowerRepo;
import com.hsf301.efep.validations.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ShopLogic {
    private FlowerRepo flowerRepo;
    private AccountRepo accountRepo;
    //-----------------------------------------CREATE FLOWER----------------------------------//

    public CreateFlowerResponse createFlowerLogic(CreateFlowerRequest request) {
        String error = CreateFlowerValidation.validate(request);

        // Trường hợp không có lỗi
        if (error.isEmpty()) {
            // correct case here


            //end of correct case

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

    //---------------------------------------VIEW FLOWER FOR SHOP---------------------------------//

    public ViewFlowerListResponse viewFlowerForShopLogic(int sellerId) {
        String error = "";
        List<Flower> flowers = flowerRepo.findBySeller_Id(sellerId);
        // Trường hợp không có lỗi
        // correct case here

        return ViewFlowerListResponse.builder()
                .status("200")
                .message("Number of flower" + flowers.size())
                .type("msg")
                .build();

        //end of correct case

        // fail case here
        //not error
        //end of fail case
        // Trường hợp có lỗi

    }

//-----------------------------------------UPDATE FLOWER----------------------------------//

    public UpdateFlowerResponse updateFlowerLogic(UpdateFlowerRequest request) {
        String error = UpdateFlowerValidation.validate(request);

        // Trường hợp không có lỗi
        if (error.isEmpty()) {
            // correct case here

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
        // Trường hợp có lỗi

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
