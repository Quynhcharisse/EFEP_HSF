package com.hsf301.efep.serivces;

import com.hsf301.efep.models.request_models.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.ui.Model;

import java.util.Map;

public interface BuyerService {

    String addToWishList(AddToWishListRequest request, HttpServletRequest httpServletRequest, HttpSession session, Model model);

    String viewWishlist(HttpSession session, Model model, int accountId);

    String updateWishlist(UpdateWishlistRequest request, HttpSession session, Model model);

    String deleteWishlist(DeleteWishlistRequest request, HttpSession session, Model model);

    String deleteWishlistItem(DeleteWishlistItemRequest request, HttpSession session, Model model);

    String viewOrderStatus(HttpSession session, Model model, int orderId);

    String viewOrderHistory(HttpSession session, Model model, int accountId);

    String viewOrderDetail(ViewOrderDetailRequest request, HttpSession session, Model model);

    String cancelOrder(CancelOrderRequest request, HttpSession session, Model model);

    String viewSlideBar(Model model);

    String viewFlowerTopList(int top, Model model);

    String viewCategory(Model model);

    String filterCategory(FilterCategoryRequest request, Model model);

    String searchFlower(SearchFlowerRequest request, Model model);

    String createOrder(HttpServletRequest httpServletRequest, Model model, HttpSession session, CreateOrderRequest request);
}
