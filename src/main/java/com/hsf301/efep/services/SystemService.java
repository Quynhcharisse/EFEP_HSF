package com.hsf301.efep.services;

import com.hsf301.efep.models.entity_models.Flower;
import com.hsf301.efep.models.request_models.GetFlowerDetailRequest;
import com.hsf301.efep.models.response_models.*;
import jakarta.servlet.http.HttpSession;
import org.springframework.data.domain.Page;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

public interface SystemService {
    GetTopSoldFlowerResponse getTop8SoldFlower();
    GetTopSoldFlowerResponse getTop2SoldFlower();
    GetFlowerListResponse getFlowerList(int page, int size);
    GetFlowerListResponse getFlowerList(Page<Flower> flowers, int page, String keyword);
    String getWishListItem(HttpSession session, RedirectAttributes attributes);
    GetCustomerAmountResponse getCustomerAmount();
    GetFlowerAmountResponse getFlowerAmount();
    GetWorkingYearAmountResponse getWorkingYearAmount();
    GetOrderAmountResponse getOrderAmount();
    GetFlowerNumberPerCategoryResponse getFlowerNumberPerCategory(int top);
    GetNewArrivalFlowerResponse getNewArrivalFlower();
    GetTeammateResponse getTeammate();
    String getFlowerDetail(GetFlowerDetailRequest request, RedirectAttributes attributes);
    String getCustomerOrderHistory(RedirectAttributes attributes, HttpSession session);
    String getFlowerListForShop(RedirectAttributes attributes, HttpSession session);
}
