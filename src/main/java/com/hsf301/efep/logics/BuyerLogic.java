package com.hsf301.efep.logics;
import com.hsf301.efep.enums.Role;
import com.hsf301.efep.enums.Status;
import com.hsf301.efep.models.entity_models.*;
import com.hsf301.efep.models.request_models.*;
import com.hsf301.efep.models.response_models.*;
import com.hsf301.efep.repositories.*;
import com.hsf301.efep.validations.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.sql.DatabaseMetaData;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Component
@RequiredArgsConstructor
// neu bo @Component==> bao loi
public class BuyerLogic {

    private final AccountRepo accountRepo;
    private final FlowerRepo flowerRepo;

    private final FlowerCategoryRepo flowerCategoryRepo;
    private final WishlistItemRepo wishlistItemRepo;
    private final WishlistRepo wishlistRepo;
    private final CategoryRepo categoryRepo;

    private final WishlistItemRepo wishlistItemRepo;
    private final WishlistRepo wishlistRepo;
    private final OrderRepo orderRepo;


    //-----------------------------------------------VIEW SLIDE BAR-----------------------------------------//

    public ViewSlideBarResponse viewSlideBar() {
        String error = "";
        if (!error.isEmpty()) {
            ViewSlideBarResponse.builder()
                    .status("400")
                    .message(error)
                    .type("err")
                    .build();
        }

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

    //-----------------------------------------------VIEW SLIDE BAR----------------------------------------------//


    public ViewFlowerTopListResponse viewFlowerTopListLogic(int top) {
        String error = "";
        return ViewFlowerTopListResponse.builder()
                .status("200")
                .message("")
                .flowerList(flowerRepo.findAll().stream().map(flower -> ViewFlowerTopListResponse.Flower.builder()
                                        .id(flower.getId())
                                        .name(flower.getName())
                                        .price(flower.getPrice())
                                        .imageList(flower.getFlowerImageList().stream()
                                                .map(
                                                        img -> ViewFlowerTopListResponse.Image.builder()
                                                                .link(img.getLink())
                                                                .build()
                                                )
                                                .toList()
                                        )
                                        .build()
                                )
                                .toList()
                )
                .build();
    }
    //-----------------------------------------------VIEW WISHLIST------------------------------------------------//

    public ViewWishlistResponse viewWishlistLogic(int accountId) {
        Account account = accountRepo.findById(accountId).orElse(null);
        assert account != null;
        List<ViewWishlistResponse.WishlistItems> wishlistItems = viewWishlistItemList(accountId);
        // Trường hợp không có lỗi
        if (!wishlistItems.isEmpty()) {
            // correct case here
            float totalPrice = wishlistItems
                    .stream()
                    .map(items -> items.getPrice() * items.getQuantity())
                    .reduce(0f, Float::sum);
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

    private List<ViewWishlistResponse.WishlistItems> viewWishlistItemList(int accountId) {
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
        assert flower != null;
        Account account = accountRepo.findById(request.getAccountId()).orElse(null);
        assert account != null;
        Wishlist wishlist = account.getUser().getWishlist();
        if (error.isEmpty()) {
            // correct case here
            if (checkExistItem(request, wishlist)) {
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


    private boolean checkExistItem(AddToWishListRequest request, Wishlist wishlist) {
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
            if ("asc".equals(request.getRequest())) {
                wishlistItem.setQuantity(wishlistItem.getQuantity() + 1);
            } else if ("desc".equals(request.getRequest())) {
                if (wishlistItem.getQuantity() > 1) {
                    wishlistItem.setQuantity(wishlistItem.getQuantity() - 1);
                } else {
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
                    .filter(item -> Objects.equals(item.getId(), request.getWishlistItemId()))
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

    //----------------------------CREATE ORDER------------------------//

    public CreateOrderResponse createOrderLogic(CreateOrderRequest request) {
        String error = CreateOrderValidation.validate(request);
        if (error.isEmpty()) {
            // correct case here


            //end of correct case

            return CreateOrderResponse.builder()
                    .status("200")
                    .message("")
                    .type("msg")
                    .build();
        }

        // fail case here


        //end of fail case
        return CreateOrderResponse.builder()
                .status("400")
                .message("")
                .type("err")
                .build();
    }


    //-------------------------VIEW ORDER HISTORY---------------------//

    public ViewOrderHistoryResponse viewOrderHistoryLogic(int accountId) {
        Account account = Role.getCurrentLoggedAccount(accountId, accountRepo);
        List<Order> orderList = orderRepo.findAllByUser_Id(account.getUser().getId());
        String error = ViewOrderHistoryValidation.validate(account, orderList);
        if (error.isEmpty()) {
            // correct case here
            if (!orderList.isEmpty()) {
                List<ViewOrderHistoryResponse.Order> orders = orderList.stream()
                        .map(this::viewOrderList)
                        .toList();

                return ViewOrderHistoryResponse.builder()
                        .status("200")
                        .message("Orders found")
                        .orderList(orders)
                        .type("msg")
                        .build();
            }
            //end of correct case
        }

        // fail case here


        //end of fail case
        return ViewOrderHistoryResponse.builder()
                .status("404")
                .message("No orders found for User")
                .type("err")
                .build();
        //end of fail case
    }

    private ViewOrderHistoryResponse.Order viewOrderList(Order order) {
        String shopName = order.getOrderDetailList().stream()
                .findFirst()
                .map(detail -> detail.getFlower().getShop().getUser().getName())
                .orElse("Unknown Seller");
        return ViewOrderHistoryResponse.Order.builder()
                .orderId(order.getId())
                .shopName(shopName)
                .totalPrice(order.getTotalPrice())
                .status(order.getStatus())
                .detailList(viewOrderDetailList(order.getOrderDetailList()))
                .build();
    }

    private List<ViewOrderHistoryResponse.Detail> viewOrderDetailList(List<OrderDetail> orderDetails) {
        return orderDetails.stream()
                .map(detail -> ViewOrderHistoryResponse.Detail.builder()
                        .flowerName(detail.getFlowerName())
                        .price(detail.getPrice())
                        .quantity(detail.getQuantity())
                        .build()
                )
                .collect(Collectors.toList());
    }
    //-------------------------VIEW ORDER STATUS---------------------//

    public ViewOrderStatusResponse viewOrderStatusLogic(int orderId) {
        Order order = orderRepo.findById(orderId).orElse(null);

        if (order != null) {
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

    public ViewOrderDetailBuyerResponse viewOrderDetailLogic(ViewOrderDetailRequest request) {
        Account account = Role.getCurrentLoggedAccount(request.getAccountId(), accountRepo);
        Order order = orderRepo.findById(request.getOrderId()).orElse(null);
        assert order != null;
        String error = ViewOrderDetailBuyerValidation.validate(request, account, order);
        if (error.isEmpty()) {
            // correct case here
            List<ViewOrderDetailResponse.Detail> detailList = viewOrderDetailLists(order.getOrderDetailList());
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

    private List<ViewOrderDetailResponse.Detail> viewOrderDetailLists(List<OrderDetail> orderDetails) {
        return orderDetails.stream()
                .map(detail -> ViewOrderDetailResponse.Detail.builder()
                        .sellerName(detail.getFlower().getShop().getUser().getName())
                        .flowerName(detail.getFlowerName())
                        .quantity(detail.getQuantity())
                        .price(detail.getPrice())
                        .build())
                .collect(Collectors.toList());
    }
    //-------------------------CANCEL ORDER-------------------------//

    public CancelOrderResponse cancelOrderLogic(CancelOrderRequest request) {
        String error = CancelOrderValidation.validate(request, orderRepo);

        if (error.isEmpty()) {
            // correct case here
            Order order = orderRepo.findById(request.getOrderId()).orElse(null);
            assert order != null;
            Status.changeOrderStatus(order, Status.ORDER_STATUS_CANCELLED, orderRepo);
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

    //-------------------------VIEW CATEGORY-------------------------//

    public ViewCategoryResponse viewCategoryLogic() {
        String error = "";

        // correct case here

        //categoryList = null;
        return ViewCategoryResponse.builder()
                .status("200")
                .message("")
                .type("msg")
                .categoryList(
                        categoryRepo.findAll().stream()
                                .map(category -> ViewCategoryResponse.Category.builder()
                                        .id(category.getId())
                                        .name(category.getName())
                                        .build())
                                .toList())
                .build();
        //end of correct case

        // fail case here
        //no error
        //end of fail case
    }


    //-------------------------FITER CATEGORY-------------------------//

    public FilterCategoryResponse filterCategoryLogic(FilterCategoryRequest request) {
        String error = "";

        // correct case here



        return FilterCategoryResponse.builder()
                .status("200")
                .message("Cancel Order Successfully")
                .type("msg")
                .categoryId(request.getCategoryId())
                .flowers(
                        flowerRepo.findAll().stream()
                                .map(
                                        flower -> FilterCategoryResponse.Flower.builder()
                                                .id(flower.getId())
                                                .name(flower.getName())
                                                .price(flower.getPrice())
                                                .images(
                                                       flower.getFlowerImageList().stream()
                                                               .map(
                                                                       img -> FilterCategoryResponse.Image.builder()
                                                                               .link(img.getLink())
                                                                               .build()
                                                               )
                                                               .toList()
                                                )
                                                .build()
                                )
                                .toList()
                )
                .build();

        //end of correct case


        // fail case here
        //no error
        //end of fail case
    }

    //-------------------------SEARCH FLOWER BY NAME-------------------------//

    public SearchFlowerResponse searchFlowerLogic(SearchFlowerRequest request) {
        String error = "";

        // correct case here




        return SearchFlowerResponse.builder()
                .status("200")
                .message("")
                .type("msg")
                .keyword(request.getKeyword())
                .flowerList(
                        flowerRepo.findAll().stream()
                        .map(
                                flower -> SearchFlowerResponse.Flower.builder()
                                        .id(flower.getId())
                                        .name(flower.getName())
                                        .price(flower.getPrice())
                                        .images(
                                                flower.getFlowerImageList().stream()
                                                        .map(
                                                                img -> SearchFlowerResponse.Image.builder()
                                                                        .link(img.getLink())
                                                                        .build()
                                                        )
                                                        .toList()
                                        )
                                        .build()
                        )
                        .toList()
                )
                .build();

        //end of correct case


        // fail case here
        //no error
        //end of fail case
    }

}
