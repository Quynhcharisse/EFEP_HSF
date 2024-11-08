package com.hsf301.efep.services;


import com.hsf301.efep.models.entity_models.Flower;
import com.hsf301.efep.models.request_models.GetFlowerDetailRequest;
import com.hsf301.efep.models.response_models.*;
import com.hsf301.efep.pojo.Teammate;

import com.hsf301.efep.models.request_models.GetFlowerDetailRequest;

import jakarta.servlet.http.HttpSession;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

public interface SystemService {
    GetSlideBarImageResponse getSlideBarImage(RedirectAttributes attributes);
    GetTopSoldFlowerResponse getTopSoldFlower(RedirectAttributes attributes);
    GetCustomerAmountResponse getCustomerAmount(RedirectAttributes attributes);
    GetFlowerAmountResponse getFlowerAmount(RedirectAttributes attributes);
    GetWorkingYearAmountResponse getWorkingYearAmount(RedirectAttributes attributes);
    GetNewArrivalFlowerResponse getNewArrivalFlower(RedirectAttributes attributes);
    GetTeammateResponse getTeammate(RedirectAttributes attributes);
    String getFlowerDetail(GetFlowerDetailRequest request, RedirectAttributes attributes);
    String getCustomerOrderHistory(RedirectAttributes attributes, HttpSession session);
    String getFlowerListForShop(RedirectAttributes attributes);
}
