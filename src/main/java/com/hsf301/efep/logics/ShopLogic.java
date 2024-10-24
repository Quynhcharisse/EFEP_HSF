package com.hsf301.efep.logics;

import com.hsf301.efep.models.request_models.*;
import com.hsf301.efep.models.response_models.*;
import com.hsf301.efep.validations.ChangeOrderStatusValidation;
import com.hsf301.efep.validations.ViewOrderDetailValidation;
import com.hsf301.efep.validations.ViewOrderListValidation;
import org.springframework.stereotype.Component;

@Component
public class ShopLogic {
    private final FlowerRepo flowerRepo;
    private final AccountRepo accountRepo;

    //-----------------------------------------CREATE FLOWER----------------------------------//

    public static CreateFlowerResponse createFlowerLogic(CreateFlowerRequest request) {
        String error = "";

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

    public static ViewFlowerListResponse viewFlowerForShopLogic(ViewFlowerListRequest request) {
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

//-----------------------------------------UPDATE FLOWER----------------------------------//

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

    //--------------------------------------DELETE FLOWER-----------------------------------//

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

                                    //---------FLOWER IMAGE ---------//

    //---------------------------------------VIEW FLOWER IMAGE------------------------------------------//

    public String viewFlowerLogic() {
        return "";
    }

    //---------------------------------------ADD FLOWER IMAGE------------------------------------------//

    public String addFlowerImageLogic() {
        return "";
    }

    //---------------------------------------DELETE FLOWER IMAGE------------------------------------------//

    public String deleteFlowerImageLogic() {
        return "";
    }

                              //----------ORDER FOR SHOP(SELLER SHOP)------------//
    //-------------------------------------CHANGE ORDER STATUS------------------------------------//

    public static ChangeOrderStatusResponse changeOrderStatusLogic(ChangeOrderStatusRequest request) {
        String error = ChangeOrderStatusValidation.validate(request);

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
        String error = ViewOrderDetailValidation.validate(request);

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

    public static ViewOrderListResponse viewOrderList(int accountId) {
        String error = ViewOrderListValidation.validate();

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
