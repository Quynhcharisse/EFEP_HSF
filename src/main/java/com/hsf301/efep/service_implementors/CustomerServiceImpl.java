package com.hsf301.efep.service_implementors;

import com.hsf301.efep.configurations.ReturnPageConfig;
import com.hsf301.efep.enums.ActionCaseValues;
import com.hsf301.efep.enums.Roles;
import com.hsf301.efep.enums.Status;
import com.hsf301.efep.models.entity_models.*;
import com.hsf301.efep.models.request_models.*;
import com.hsf301.efep.models.response_models.*;
import com.hsf301.efep.repositories.*;
import com.hsf301.efep.services.CustomerService;
import com.hsf301.efep.validations.AddToWishListValidation;
import com.hsf301.efep.validations.CheckoutValidation;
import com.hsf301.efep.validations.UpdateWishListValidation;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {
    private final FlowerRepo flowerRepo;
    private final CategoryRepo categoryRepo;
    private final WishlistRepo wishlistRepo;
    private final WishlistItemRepo wishlistItemRepo;
    private final AccountRepo accountRepo;
    private final OrderRepo orderRepo;
    private final OrderDetailRepo orderDetailRepo;


    //-----------------Search Flowers----------------------//

    @Override
    public String searchFlowers(SearchFlowerRequest request, RedirectAttributes attributes) {
        SearchFlowerResponse response = searchFlowersLogic(request);
        attributes.addFlashAttribute("msg", response);
        return ReturnPageConfig.generateReturnMapping(ActionCaseValues.SEARCH_FLOWER);
    }

    private SearchFlowerResponse searchFlowersLogic(SearchFlowerRequest request) {
        return SearchFlowerResponse.builder()
                .status("200")
                .message("")
                .flowers(
                        flowerRepo.findAll().stream()
                                .filter(flower -> flower.getStatus().equals(Status.FLOWER_AVAILABLE) && flower.getName().contains(request.getKeyword()))
                                .map(
                                        flower -> SearchFlowerResponse.Flower.builder()
                                                .id(flower.getId())
                                                .name(flower.getName())
                                                .price(flower.getPrice())
                                                .img(flower.getImg())
                                                .build()
                                )
                                .toList()
                )
                .build();
    }

    //--------------------TEST--------------------//

    public SearchFlowerResponse searchFlowersLogicTest(SearchFlowerRequest request) {
        return null;
    }

    //-----------------Sort Flowers----------------------//
    @Override
    public String sortFlowers(SortFlowerRequest request, RedirectAttributes attributes) {
        SortFlowerResponse response = sortFlowersLogic(request);
        attributes.addFlashAttribute("msg", response);
        return ReturnPageConfig.generateReturnMapping(ActionCaseValues.SORT_FLOWER);
    }

    private SortFlowerResponse sortFlowersLogic(SortFlowerRequest request) {
        //Check price
        List<Flower> flowers = flowerRepo.findAll().stream()
                .filter(f -> f.getStatus().equals(Status.FLOWER_AVAILABLE))
                .filter(f -> f.getPrice() >= request.getStartPrice() && f.getPrice() <= request.getEndPrice())
                .toList();

        //Check category
        try {
            int cateId = Integer.parseInt(request.getCateId());
            if (categoryRepo.existsById(cateId)) {
                flowers = flowers.stream()
                        .filter(f -> f.getCategory().getId() == cateId)
                        .toList();
            }
        } catch (NumberFormatException e) {
            System.err.println("Well just a funny message that there is no category to sort with id: " + request.getCateId());
        }

        //Check sortType
        flowers.sort(Comparator.comparing(Flower::getId).reversed());
        if (request.getSortType() != null) {
            switch (request.getSortType()) {
                case "asc" -> {
                    flowers.sort(Comparator.comparing(Flower::getName));
                }

                case "desc" -> {
                    flowers.sort(Comparator.comparing(Flower::getName).reversed());
                }

                case "priceUp" -> {
                    flowers.sort(Comparator.comparing(Flower::getPrice));
                }

                case "priceDown" -> {
                    flowers.sort(Comparator.comparing(Flower::getPrice).reversed());
                }

            }
        }

        return SortFlowerResponse.builder()
                .status("200")
                .message("")
                .flowers(flowers.stream()
                        .map(f -> SortFlowerResponse.Flower.builder()
                                .id(f.getId())
                                .name(f.getName())
                                .price(f.getPrice())
                                .img(f.getImg())
                                .build()
                        )
                        .toList()
                )
                .build();
    }

    //--------------------TEST--------------------//

    public SortFlowerResponse sortFlowersLogicTest(SortFlowerRequest request) {
        return null;
    }

    //-----------------Add To WishList----------------------//
    @Override
    public String addToWishList(AddToWishListRequest request, RedirectAttributes attributes, HttpSession session) {
        AddToWishListResponse response = addToWishListLogic(request, Roles.getCurrentLoggedAccount(session));
        attributes.addFlashAttribute(response.getStatus().equals("200") ? "msg" : "error", response);
        if(response.getStatus().equals("403")) return ReturnPageConfig.generateReturnMapping(ActionCaseValues.AUTHED_FAIL);
        return ReturnPageConfig.generateReturnMapping(ActionCaseValues.ADD_TO_WISHLIST);
    }

    private AddToWishListResponse addToWishListLogic(AddToWishListRequest request, Account account) {
        if(account == null || !Roles.checkIfThisAccountIsCustomer(account)) {
            return AddToWishListResponse.builder()
                    .status("403")
                    .message("Please login a customer account first")
                    .build();
        }

        String error = AddToWishListValidation.validate(request, flowerRepo, account);
        if(!error.isEmpty()) {
            return AddToWishListResponse.builder()
                    .status("400")
                    .message(error)
                    .build();
        }

        Flower flower = flowerRepo.findById(request.getFlowerId()).orElse(null);
        assert flower != null;
        WishlistItem item = wishlistItemRepo.findByFlower_IdAndWishlist_User_Account_Id(flower.getId(), account.getId()).orElse(null);
        Wishlist wishlist = account.getUser().getWishlist();
        if(item == null) {
            item = WishlistItem.builder()
                    .wishlist(wishlist)
                    .quantity(request.getQty())
                    .flower(flower)
                    .build();
        }else{
            if(item.getQuantity() + request.getQty() > flower.getQuantity()){
                return AddToWishListResponse.builder()
                        .status("400")
                        .message("Max quantity exceeded")
                        .build();
            }
            item.setQuantity(item.getQuantity() + request.getQty());
        }
        wishlistItemRepo.save(item);
        return AddToWishListResponse.builder()
                .status("200")
                .message("Add to wishlist successfully")
                .build();
    }

    //--------------------TEST--------------------//

    public AddToWishListResponse addToWishListLogicTest(AddToWishListRequest request, Account account) {
        return null;
    }

    //-----------------Update WishList----------------------//
    @Override
    public String updateWishList(UpdateWishListRequest request, RedirectAttributes attributes, HttpSession session) {
        UpdateWishListResponse response = updateWishListLogic(request, Roles.getCurrentLoggedAccount(session));
        attributes.addFlashAttribute(response.getStatus().equals("200") ? "msg" : "error", response);
        if(response.getStatus().equals("403")) return ReturnPageConfig.generateReturnMapping(ActionCaseValues.AUTHED_FAIL);
        return ReturnPageConfig.generateReturnMapping(ActionCaseValues.UPDATE_WISHLIST);
    }

    private UpdateWishListResponse updateWishListLogic(UpdateWishListRequest request, Account account) {
        if(account == null || !Roles.checkIfThisAccountIsCustomer(account)) {
            return UpdateWishListResponse.builder()
                    .status("403")
                    .message("Please login a customer account first")
                    .build();
        }

        String error = UpdateWishListValidation.validate(request, wishlistItemRepo);
        if(!error.isEmpty()) {
            return UpdateWishListResponse.builder()
                    .status("400")
                    .message(error)
                    .build();
        }

        WishlistItem item = wishlistItemRepo.findById(request.getWishListItemId()).get();
        item.setQuantity(request.getNewQty());
        wishlistItemRepo.save(item);
        return UpdateWishListResponse.builder()
                .status("200")
                .message("Update wishlist successfully")
                .build();
    }
    //--------------------TEST--------------------//

    public UpdateWishListResponse updateWishListLogicTest(UpdateWishListRequest request, Account account) {
        return null;
    }

    //-----------------Clear WishList----------------------//
    @Override
    public String clearWishList(RedirectAttributes attributes, HttpSession session) {
        return null;
    }

    //--------------------TEST--------------------//

    public ClearWishListResponse clearWishListLogicTest(Account account) {
        return null;
    }

    //-----------------Check out----------------------//
    @Override
    public String checkout(CheckoutRequest request, RedirectAttributes attributes, HttpSession session) {
        return null;
    }

    private CheckoutResponse buildOrder (CheckoutRequest request, Account account){
        return null;
    }

    private float calculateTotalPrice(Account account){
        return 0;
    }

    private Order createOrder(Account account, float totalPrice){
        return null;
    }

    private void createOrderDetail(Order order, Account account){
    }

    private void updateFlowerNewQuantityAndSoldQuantity(WishlistItem item){
    }

    //--------------------TEST--------------------//

    public CheckoutResponse checkoutLogicTest(CheckoutRequest request, Account account) {
        return null;
    }
}
