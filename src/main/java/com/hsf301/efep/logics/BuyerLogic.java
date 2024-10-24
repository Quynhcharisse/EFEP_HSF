package com.hsf301.efep.logics;

import com.hsf301.efep.models.entity_models.Account;
import com.hsf301.efep.models.entity_models.Flower;
import com.hsf301.efep.models.entity_models.Wishlist;
import com.hsf301.efep.models.entity_models.WishlistItem;
import com.hsf301.efep.models.request_models.*;
import com.hsf301.efep.models.response_models.*;
import com.hsf301.efep.repositories.AccountRepo;
import com.hsf301.efep.repositories.FlowerRepo;
import com.hsf301.efep.repositories.WishlistItemRepo;
import com.hsf301.efep.repositories.WishlistRepo;
import com.hsf301.efep.validations.*;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;


@Component
public class BuyerLogic {

    private AccountRepo accountRepo;
    private FlowerRepo flowerRepo;
    private WishlistItemRepo wishlistItemRepo;
    private WishlistRepo wishlistRepo;

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

    public ViewWishlistResponse viewWishlistLogic(int accountId) {
        Account account = accountRepo.findById(accountId).orElse(null);
        assert account !=null;
        List<ViewWishlistResponse.WishlistItems> wishlistItems = viewWishlistItemList(accountId);
        // Trường hợp không có lỗi
        if (!wishlistItems.isEmpty()) {
            // correct case here
            float totalPrice = wishlistItems
                    .stream()
                    .map(items -> items.getPrice() * items.getQuantity())
                    .reduce(0f,Float::sum);
            //end of correct case
            return ViewWishlistResponse.builder()
                    .status("200")
                    .message("View wishlist Successfully")
                    .id(account.getUser().getWishlist().getId())
                    .userId(account.getUser().getId())
                    .userName(account.getUser().getName())
                    .totalPrice(totalPrice)
                    .wishlistItemList(viewWishlistItemList(accountId))
                    .type("msg")
                    .build();
        }

        // fail case here
        else {
            //end of fail case
            // Trường hợp có lỗi
            return ViewWishlistResponse.builder()
                    .status("400")
                    .message("View wishlist Failed")
                    .type("err")
                    .build();
        }
    }
    private List<ViewWishlistResponse.WishlistItems> viewWishlistItemList(int accountId){
        Account account = accountRepo.findById(accountId).orElse(null);
        assert account != null;
        return account.getUser().getWishlist().getWishlistItemList().stream()
                .map(wishlistItem -> new ViewWishlistResponse
                        .WishlistItems(wishlistItem.getId(), wishlistItem.getFlower().getName(), wishlistItem.getQuantity(), wishlistItem.getFlower().getPrice()))
                .toList();

    }

    //--------------------------------ADD TO WISHLIST----------------------------------//

    public AddToWishListResponse AddToWishListLogic(AddToWishListRequest request) {
        String error = AddToWishListValidation.validate(request);
        Flower flower = flowerRepo.findById(request.getFlowerId()).orElse(null);
        assert flower !=null;
        Account account = accountRepo.findById(request.getAccountId()).orElse(null);
        assert account !=null;
        Wishlist wishlist = account.getUser().getWishlist();
        if (error.isEmpty()) {
            // correct case here
            if(checkExistItem(request, wishlist)){
                WishlistItem wishlistItem = wishlistItemRepo.findByFlower_Id(request.getFlowerId()).orElse(null);
                assert wishlistItem != null;
                wishlistItem.setQuantity(wishlistItem.getQuantity() + 1);
                wishlistItemRepo.save(wishlistItem);
            }
            //end of correct case
            return AddToWishListResponse.builder()
                    .status("200")
                    .message("Add to wishlist Successfully")
                    .type("msg")
                    .build();
        }
        // fail case here
        else {
            wishlist.getWishlistItemList().add(wishlistItemRepo.save(
                    WishlistItem.builder()
                            .wishlist(wishlist)
                            .flower(flower)
                            .quantity(1)
                            .build()
            ));
            accountRepo.save(account);
            //end of fail case
            return AddToWishListResponse.builder()
                    .status("400")
                    .message("Add to wishlist Failed")
                    .type("err")
                    .build();
        }
    }


    private boolean checkExistItem(AddToWishListRequest request, Wishlist wishlist){
        return wishlist.getWishlistItemList()
                .stream()
                .anyMatch(wishlistItem -> Objects.equals(wishlistItem.getFlower().getId(), request.getFlowerId()));
    }

    //--------------------------------UPDATE WISHLIST----------------------------------//

    public UpdateWishlistResponse updateWishlistLogic(UpdateWishlistRequest request) {
        String error = WishListValidation.validate(request);
        Account account = accountRepo.findById(request.getAccountId()).orElse(null);
        assert account != null;
        Wishlist wishlist = wishlistRepo.findByUser_Account_Id(account.getId()).orElse(null);
        assert wishlist != null;
        WishlistItem wishlistItem = wishlistItemRepo.findById(Integer.parseInt(request.getWishlistItemId())).orElse(null);
        assert wishlistItem != null;
        if (error.isEmpty()) {
            // correct case here
            if("asc".equals(request.getRequest())){
                wishlistItem.setQuantity(wishlistItem.getQuantity() + 1 );
            } else if ("desc".equals(request.getRequest())) {
                if(wishlistItem.getQuantity() > 1){
                    wishlistItem.setQuantity(wishlistItem.getQuantity() - 1 );
                }else {
                    wishlistItemRepo.delete(wishlistItem);
                }
            }

            wishlistItemRepo.save(wishlistItem);
            //end of correct case
            return UpdateWishlistResponse.builder()
                    .status("200")
                    .message("Update wishlist Successfully")
                    .type("msg")
                    .build();
        } else {
            // fail case here
            //end of fail case
            return UpdateWishlistResponse.builder()
                    .status("400")
                    .message("Update wishlist Failed")
                    .type("err")
                    .build();
        }
    }

    //--------------------------------DELETE WISHLIST----------------------------------//

    public DeleteWishlistResponse deleteWishlistLogic(DeleteWishlistRequest request) {
        String error = DeleteWishListValidation.validate(request);
        Wishlist wishlist = wishlistRepo.findById(request.getWishlistId()).orElse(null);
        assert wishlist != null;
        if (error.isEmpty()) {
            // correct case here
            wishlistItemRepo.deleteAll(wishlist.getWishlistItemList());
            wishlist.getWishlistItemList().clear();
            wishlistRepo.save(wishlist);
            //end of correct case
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

    public DeleteWishlistItemResponse deleteWishlistItemLogic(DeleteWishlistItemRequest request) {
        String error = DeleteWishListItemValidation.validate(request);
        Account account = accountRepo.findById(request.getAccountId()).orElse(null);
        assert account != null;
        if (error.isEmpty()) {
            // correct case here
            Wishlist wishlist = account.getUser().getWishlist();
            Optional<WishlistItem> optionalWishlistItem = wishlist
                    .getWishlistItemList()
                    .stream()
                    .filter(item -> Objects.equals(item.getId(),request.getWishlistItemId()))
                    .findFirst();
            WishlistItem wishlistItem = optionalWishlistItem.get();
            wishlist.getWishlistItemList().remove(wishlistItem);
            wishlistItemRepo.delete(wishlistItem);
            //end of correct case
            return DeleteWishlistItemResponse.builder()
                    .status("200")
                    .message("Delete wishlist item Successfully")
                    .type("msg")
                    .build();
        }

        // fail case here
        return DeleteWishlistItemResponse.builder()
                .status("400")
                .message("Delete wishlist item Failed")
                .type("err")
                .build();
        //end of fail case

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
