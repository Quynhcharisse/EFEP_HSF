package com.hsf301.efep.logics;

import com.hsf301.efep.models.request_models.*;
import com.hsf301.efep.models.response_models.*;
import com.hsf301.efep.repositories.CategoryRepo;
import com.hsf301.efep.validations.*;

import java.util.ArrayList;
import java.util.List;

public class BuyerLogic {
    public static ViewSlideBarResponse viewSlideBar(){
            String error = "";

//            }    if(!error.isEmpty()){
//            ViewSlideBarResponse.builder()
//                    .status("400")
//                    .message(error)
//                    .type("err")
//                    .build();

        List<String> flowerImgageLinkList = new ArrayList<>();
         flowerImgageLinkList.add("https://static.vecteezy.com/system/resources/previews/003/110/648/original/spring-sale-banner-season-floral-discount-poster-with-flowers-vector.jpg");
         flowerImgageLinkList.add("https://as2.ftcdn.net/v2/jpg/02/44/86/81/1000_F_244868120_ZDcYjdJ6NMJHumrT6FQQQDiiEkX9h427.jpg");
         flowerImgageLinkList.add("https://static.vecteezy.com/system/resources/previews/003/110/679/large_2x/summer-sale-promo-web-banner-multicolour-editable-floral-flower-frame-vector.jpg");
         flowerImgageLinkList.add("https://as1.ftcdn.net/v2/jpg/02/40/86/86/1000_F_240868665_0HcnhSG2uUOvAvCdRrHnnTIDsCAGTUqK.jpg");
            return ViewSlideBarResponse.builder()
                    .status("200")
                    .message("Login successfully")
                    .imageList(flowerImgageLinkList)
                    .type("msg")
                    .build();
        }

    //--------------------------------VIEW WISHLIST----------------------------------//

    public static ViewWishlistResponse viewWishlistLogic() {
        String error = "";

        // Trường hợp không có lỗi
        if (error.isEmpty()) {
            // correct case here


            //end of correct case

            return ViewWishlistResponse.builder()
                    .status("200")
                    .message("View wishlist Successfully")
                    .type("msg")
                    .build();
        }

        // fail case here


        //end of fail case
        // Trường hợp có lỗi
        return ViewWishlistResponse.builder()
                .status("400")
                .message("View wishlist Failed")
                .type("err")
                .build();
    }

    //--------------------------------ADD TO WISHLIST----------------------------------//

    public static AddToWishListResponse AddToWishListLogic(AddToWishListRequest request) {
        String error = AddToWishListValidation.validate(request);
        if (error.isEmpty()) {
            // correct case here


            //end of correct case

            Integer accountId = 0; // change to your data
            Integer flowerId = 0; // change to your data



            return AddToWishListResponse.builder()
                    .status("200")
                    .message("Add to wishlist Successfully")
                    .type("msg")
                    .build();
        }

        // fail case here


        //end of fail case
        return AddToWishListResponse.builder()
                .status("400")
                .message("Add to wishlist Failed")
                .type("err")
                .build();
    }

    //--------------------------------UPDATE WISHLIST----------------------------------//

    public static UpdateWishlistResponse updateWishlistLogic(UpdateWishlistRequest request) {
        String error = WishListValidation.validate(request);
        if (error.isEmpty()) {
            // correct case here


            //end of correct case

            int accountId = 0; // change to your data
            int flowerId = 0; // change to your data



            return UpdateWishlistResponse.builder()
                    .status("200")
                    .message("Update wishlist Successfully")
                    .type("msg")
                    .build();
        }

        // fail case here


        //end of fail case
        return UpdateWishlistResponse.builder()
                .status("400")
                .message("Update wishlist Failed")
                .type("err")
                .build();
    }

    //--------------------------------DELETE WISHLIST----------------------------------//

    public static DeleteWishlistResponse deleteWishlistLogic(DeleteWishlistRequest request) {
        String error = DeleteWishListValidation.validate(request);
        if (error.isEmpty()) {
            // correct case here


            //end of correct case

            Integer accountId = 0; // change to your data
            Integer flowerId = 0; // change to your data



            return DeleteWishlistResponse.builder()
                    .status("200")
                    .message("Delete wishlist Successfully")
                    .type("msg")
                    .build();
        }

        // fail case here


        //end of fail case
        return DeleteWishlistResponse.builder()
                .status("400")
                .message("Delete wishlist Failed")
                .type("err")
                .build();
    }

    //--------------------------------DELETE WISHLIST ITEM----------------------------------//

    public static DeleteWishlistItemResponse deleteWishlistItemLogic(DeleteWishlistItemRequest request) {
        String error = DeleteWishListItemValidation.validate(request);
        if (error.isEmpty()) {
            // correct case here


            //end of correct case

            int accountId = 0; // change to your data
            int wishlistItemId = 0; // change to your data



            return DeleteWishlistItemResponse.builder()
                    .status("200")
                    .message("Delete wishlist item Successfully")
                    .type("msg")
                    .build();
        }

        // fail case here


        //end of fail case
        return DeleteWishlistItemResponse.builder()
                .status("400")
                .message("Delete wishlist item Failed")
                .type("err")
                .build();
    }

    //-------------------------VIEW ORDER HISTORY---------------------//

    public static ViewOrderHistoryResponse viewOrderHistoryLogic() {
        String error = "";
        if (error.isEmpty()) {
            // correct case here


            //end of correct case

            return ViewOrderHistoryResponse.builder()
                    .status("200")
                    .message("View Order History Successfully")
                    .type("msg")
                    .build();
        }

        // fail case here


        //end of fail case
        return ViewOrderHistoryResponse.builder()
                .status("400")
                .message("View Order History Failed")
                .type("err")
                .build();
    }

    //-------------------------VIEW ORDER STATUS---------------------//

    public static ViewOrderStatusResponse viewOrderStatusLogic() {
        String error = "";
        if (error.isEmpty()) {
            // correct case here


            //end of correct case

            return ViewOrderStatusResponse.builder()
                    .status("200")
                    .message("View Order Status Successfully")
                    .type("msg")
                    .build();
        }

        // fail case here


        //end of fail case
        return ViewOrderStatusResponse.builder()
                .status("400")
                .message("View Order Status Failed")
                .type("err")
                .build();
    }

    //-------------------------VIEW ORDER DETAIL---------------------//

    public static ViewOrderDetailBuyerResponse viewOrderDetailLogic(ViewOrderDetailRequest request) {
        String error = ViewOrderDetailBuyerValidation.validate(request);
        if (error.isEmpty()) {
            // correct case here


            //end of correct case

            return ViewOrderDetailBuyerResponse.builder()
                    .status("200")
                    .message("View Order Detail Buyer Successfully")
                    .type("msg")
                    .build();
        }

        // fail case here


        //end of fail case
        return ViewOrderDetailBuyerResponse.builder()
                .status("400")
                .message("View Order Detail Buyer Failed")
                .type("err")
                .build();
    }

    //-------------------------CANCEL ORDER-------------------------//

    public static CancelOrderResponse cancelOrderLogic(CancelOrderRequest request) {
        String error = CancelOrderValidation.validate(request);
        if (error.isEmpty()) {
            // correct case here


            //end of correct case

            return CancelOrderResponse.builder()
                    .status("200")
                    .message("Cancel Order Successfully")
                    .type("msg")
                    .build();
        }

        // fail case here


        //end of fail case
        return CancelOrderResponse.builder()
                .status("400")
                .message("Cancel Order Failed")
                .type("err")
                .build();
    }
}
