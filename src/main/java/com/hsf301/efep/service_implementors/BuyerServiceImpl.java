package com.hsf301.efep.service_implementors;

import com.hsf301.efep.enums.FailPageFor;
import com.hsf301.efep.enums.SuccessPageFor;
import com.hsf301.efep.logics.AccountLogic;
import com.hsf301.efep.logics.BuyerLogic;
import com.hsf301.efep.models.request_models.*;
import com.hsf301.efep.models.response_models.*;
import com.hsf301.efep.serivces.BuyerService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

@Service
@RequiredArgsConstructor
public class BuyerServiceImpl implements BuyerService {

    private final BuyerLogic buyerLogic;


    //-------------------------------------------------VIEW SLIDE BAR-------------------------//

    @Override
    public String viewSlideBar(Model model) {
        ViewSlideBarResponse response = buyerLogic.viewSlideBar();
        model.addAttribute(response.getType(), response);
        return response.getStatus().equals("200") ? SuccessPageFor.VIEW_SLIDE_BAR : FailPageFor.VIEW_SLIDE_BAR;
    }

    //--------------------------------VIEW WISHLIST----------------------------------//
    @Override
    public String viewWishlist(HttpSession session, Model model, int accountId) {
        ViewWishlistResponse response = buyerLogic.viewWishlistLogic(accountId);
        model.addAttribute(response.getType(), response);
        return response.getStatus().equals("200") ? SuccessPageFor.VIEW_WISHLIST : FailPageFor.VIEW_WISHLIST;
    }

    //-------------------------------------------------ADD TO WISHLIST---------------//

    @Override
    public String addToWishList(AddToWishListRequest request, HttpServletRequest httpServletRequest, HttpSession session, Model model) {
        AddToWishListResponse response = buyerLogic.AddToWishListLogic(request);
        model.addAttribute(response.getType(), response);
        return response.getStatus().equals("200") ? SuccessPageFor.ADD_TO_WISHLIST : FailPageFor.ADD_TO_WISHLIST;
    }

    //-------------------------------------------------UPDATE WISHLIST-----------------//

    @Override
    public String updateWishlist(UpdateWishlistRequest request, HttpSession session, Model model) {
        UpdateWishlistResponse response = buyerLogic.updateWishlistLogic(request);
        model.addAttribute(response.getType(), response);
        return response.getStatus().equals("200") ? SuccessPageFor.UPDATE_WISHLIST : FailPageFor.UPDATE_WISHLIST;
    }

    //-------------------------------------------------DELETE WISHLIST------------------//

    @Override
    public String deleteWishlist(DeleteWishlistRequest request, HttpSession session, Model model) {
        DeleteWishlistResponse response = buyerLogic.deleteWishlistLogic(request);
        model.addAttribute(response.getType(), response);
        return response.getStatus().equals("200") ? SuccessPageFor.DELETE_WISHLIST : FailPageFor.DELETE_WISHLIST;
    }

    //-------------------------------------------------DELETE WISHLIST ITEM-------------------//

    @Override
    public String deleteWishlistItem(DeleteWishlistItemRequest request, HttpSession session, Model model) {
        DeleteWishlistItemResponse response = buyerLogic.deleteWishlistItemLogic(request);
        model.addAttribute(response.getType(), response);
        return response.getStatus().equals("200") ? SuccessPageFor.DELETE_WISHLIST_ITEM : FailPageFor.DELETE_WISHLIST_ITEM;
    }

    //-------------------------VIEW ORDER HISTORY---------------------//

    @Override
    public String viewOrderHistory(HttpSession session, Model model, int accountId) {
        ViewOrderHistoryResponse response = buyerLogic.viewOrderHistoryLogic(accountId);
        model.addAttribute(response.getType(), response);
        return response.getStatus().equals("200") ? SuccessPageFor.VIEW_ORDER_HISTORY : FailPageFor.VIEW_ORDER_HISTORY;
    }

    //-------------------------VIEW ORDER STATUS---------------------//

    @Override
    public String viewOrderStatus(HttpSession session, Model model, int orderId) {
        ViewOrderStatusResponse response = buyerLogic.viewOrderStatusLogic(orderId);
        model.addAttribute(response.getType(), response);
        return response.getStatus().equals("200") ? SuccessPageFor.VIEW_ORDER_STATUS : FailPageFor.VIEW_ORDER_STATUS;
    }

    //-------------------------VIEW ORDER DETAIL---------------------//

    @Override
    public String viewOrderDetail(ViewOrderDetailRequest request, HttpSession session, Model model) {
        ViewOrderDetailBuyerResponse response = buyerLogic.viewOrderDetailLogic(request);
        model.addAttribute(response.getType(), response);
        return response.getStatus().equals("200") ? SuccessPageFor.VIEW_ORDER_DETAIL_BUYER : FailPageFor.VIEW_ORDER_DETAIL_BUYER;
    }

    //-------------------------CANCEL ORDER-------------------------//

    @Override
    public String cancelOrder(CancelOrderRequest request, HttpSession session, Model model) {
        CancelOrderResponse response = buyerLogic.cancelOrderLogic(request);
        model.addAttribute(response.getType(), response);
        return response.getStatus().equals("200") ? SuccessPageFor.CANCEL_ORDER : FailPageFor.CANCEL_ORDER;
    }

}
