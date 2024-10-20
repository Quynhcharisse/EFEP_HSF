package com.hsf301.efep.controllers;

import com.hsf301.efep.models.request_models.*;
import com.hsf301.efep.serivces.BuyerService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("/buyer")
public class BuyerController {

    private final BuyerService buyerService;

    //-----------------------VIEW SLIDE BAR-------------------//

    @GetMapping("/slide/bar")
    public String viewSlideBar(Model model){
        return buyerService.viewSlideBar(model);
    }


    //-------------------------VIEW WISHLIST------------------//

    @GetMapping("/wishlist")
    @Operation(hidden = true)
    public String viewWishlist(HttpSession session, Model model) {
        return buyerService.viewWishlist(session, model);
    }

    //-------------------------ADD TO WISHLIST------------------//

    @PostMapping("/wishlist")
    public String addToWishlist(AddToWishListRequest request, HttpServletRequest httpServletRequest, Model model, HttpSession session) {
        return buyerService.addToWishList(request, httpServletRequest, session, model);
    }

    //-------------------------UPDATE WISHLIST------------------//

    @PutMapping("/wishlist")
    @Operation(hidden = true)
    public String updateWishlist(UpdateWishlistRequest request, HttpSession session, Model model) {
        return buyerService.updateWishlist(request, session, model);
    }

    //-------------------------DELETE WISHLIST------------------//

    @DeleteMapping("/wishlist")
    @Operation(hidden = true)
    public String deleteWishlist(DeleteWishlistRequest request, HttpSession session, Model model) {
        return buyerService.deleteWishlist(request, session, model);
    }

    //-------------------------DELETE WISHLIST ITEM------------------//

    @DeleteMapping("/wishlist-item")
    @Operation(hidden = true)
    public String deleteWishlistItem(DeleteWishlistItemRequest request, HttpSession session, Model model) {
        return buyerService.deleteWishlistItem(request, session, model);
    }



    //-------------------------VIEW ORDER HISTORY---------------------//

    @GetMapping("/order-history")
    @Operation(hidden = true)
    public String viewOrderHistory(HttpSession session, Model model) {
        return buyerService.viewOrderHistory(session, model);
    }

    //-------------------------VIEW ORDER STATUS---------------------//

    @GetMapping("/order/status")
    @Operation(hidden = true)
    public String viewOrderStatus(HttpSession session, Model model) {
        return buyerService.viewOrderStatus(session, model);
    }

    //-------------------------VIEW ORDER DETAIL---------------------//

    @GetMapping("/order/detail")
    @Operation(hidden = true)
    public String viewOrderDetail(ViewOrderDetailRequest request, HttpSession session, Model model) {
        return buyerService.viewOrderDetail(request, session, model);
    }

    //-------------------------CANCEL ORDER-------------------------//

    @PutMapping("/order")
    @Operation(hidden = true)
    public String cancelOrder(CancelOrderRequest request, HttpSession session, Model model) {
        return buyerService.cancelOrder(request, session, model);
    }

}
