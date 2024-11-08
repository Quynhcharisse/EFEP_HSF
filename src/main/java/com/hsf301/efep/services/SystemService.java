package com.hsf301.efep.services;

import com.hsf301.efep.models.request_models.GetFlowerDetailRequest;
import com.hsf301.efep.models.response_models.*;

import jakarta.servlet.http.HttpSession;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

public interface SystemService {
    GetTopSoldFlowerResponse getTop10SoldFlower();
    GetTopSoldFlowerResponse getTop2SoldFlower();
    GetCustomerAmountResponse getCustomerAmount();
    GetFlowerAmountResponse getFlowerAmount();
    GetWorkingYearAmountResponse getWorkingYearAmount();
    GetNewArrivalFlowerResponse getNewArrivalFlower();
    GetTeammateResponse getTeammate();
    String getFlowerDetail(GetFlowerDetailRequest request, RedirectAttributes attributes);
    String getCustomerOrderHistory(RedirectAttributes attributes, HttpSession session);
    String getFlowerListForShop(RedirectAttributes attributes, HttpSession session);
}
