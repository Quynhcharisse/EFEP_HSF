package com.hsf301.efep.logics;

import com.hsf301.efep.models.entity_models.Account;
import com.hsf301.efep.models.entity_models.Flower;
import com.hsf301.efep.models.request_models.*;
import com.hsf301.efep.models.response_models.*;
import com.hsf301.efep.repositories.AccountRepo;
import com.hsf301.efep.repositories.FlowerRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;


@RequiredArgsConstructor
@Component
public class ShopLogic {
    private final FlowerRepo flowerRepo;
    private final AccountRepo accountRepo;

    //------------------------CREATE FLOWER---------------------//

    public CreateFlowerResponse createFlowerLogic(CreateFlowerRequest request) {
        String error = "";
        Account account = accountRepo.findById(request.getAccountId()).orElse(null);
        assert  account != null;

        // Trường hợp không có lỗi
        if (error.isEmpty()) {
            // correct case here
            Flower flower = new Flower();
            flower.setName(request.getName());
            flower.setDescription(request.getDescription());
            flower.setFlowerAmount(request.getFlowerAmount());
            flower.setQuantity(request.getQuantity());
//            Float totalPrice =

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

    //-------------------------VIEW FLOWER---------------------//

    public static ViewFlowerListResponse viewFlowerLogic(ViewFlowerListRequest request) {
        String error = "";

        // Trường hợp không có lỗi
        if (error.isEmpty()) {
            // correct case here


            //end of correct case

            return ViewFlowerListResponse.builder()
                    .status("200")
                    .message("View Flower List Successfully")
                    .type("msg")
                    .build();
        }

        // fail case here


        //end of fail case
        // Trường hợp có lỗi
        return ViewFlowerListResponse.builder()
                .status("400")
                .message("View Flower List Failed")
                .type("err")
                .build();
    }

//------------------------UPDATE FLOWER---------------------//

    public static UpdateFlowerResponse updateFlowerLogic(UpdateFlowerRequest request) {
        String error = "";

        // Trường hợp không có lỗi
        if (error.isEmpty()) {
            // correct case here


            //end of correct case

            return UpdateFlowerResponse.builder()
                    .status("200")
                    .message("Update Flower List Successfully")
                    .type("msg")
                    .build();
        }

        // fail case here


        //end of fail case
        // Trường hợp có lỗi
        return UpdateFlowerResponse.builder()
                .status("400")
                .message("Update Flower List Failed")
                .type("err")
                .build();
    }

    //-------------------DELETE FLOWER---------------------//

    public static DeleteFlowerResponse deleteFlowerLogic(DeleteFlowerRequest request) {
        String error = "";

        // Trường hợp không có lỗi
        if (error.isEmpty()) {
            // correct case here


            //end of correct case

            return DeleteFlowerResponse.builder()
                    .status("200")
                    .message("Delete Flower List Successfully")
                    .type("msg")
                    .build();
        }

        // fail case here


        //end of fail case
        // Trường hợp có lỗi
        return DeleteFlowerResponse.builder()
                .status("400")
                .message("Delete Flower List Failed")
                .type("err")
                .build();
    }

    //-------------------------CHANGE ORDER STATUS---------------------//

    public static ChangeOrderStatusResponse changeOrderStatusLogic(ChangeOrderStatusRequest request) {
        String error = "";

        // Trường hợp không có lỗi
        if (error.isEmpty()) {
            // correct case here


            //end of correct case

            return ChangeOrderStatusResponse.builder()
                    .status("200")
                    .message("Change Order Status Successfully")
                    .type("msg")
                    .build();
        }

        // fail case here


        //end of fail case
        // Trường hợp có lỗi
        return ChangeOrderStatusResponse.builder()
                .status("400")
                .message("Change Order Status Failed")
                .type("err")
                .build();
    }

    //-------------------------VIEW ORDER DETAIL---------------------//

    public static ViewOrderDetailResponse viewOrderDetailLogic(ViewOrderDetailRequest request) {
        String error = "";

        // Trường hợp không có lỗi
        if (error.isEmpty()) {
            // correct case here


            //end of correct case

            return ViewOrderDetailResponse.builder()
                    .status("200")
                    .message("View Order Detail Successfully")
                    .type("msg")
                    .build();
        }

        // fail case here


        //end of fail case
        // Trường hợp có lỗi
        return ViewOrderDetailResponse.builder()
                .status("400")
                .message("View Order Detail Failed")
                .type("err")
                .build();
    }

    //-------------------------VIEW ORDER LIST-------------------------//

    public static ViewOrderListResponse viewOrderList() {
        String error = "";

        // Trường hợp không có lỗi
        if (error.isEmpty()) {
            // correct case here


            //end of correct case

            return ViewOrderListResponse.builder()
                    .status("200")
                    .message("View Order List Successfully")
                    .type("msg")
                    .build();
        }

        // fail case here


        //end of fail case
        // Trường hợp có lỗi
        return ViewOrderListResponse.builder()
                .status("400")
                .message("View Order List Failed")
                .type("err")
                .build();
    }
}
