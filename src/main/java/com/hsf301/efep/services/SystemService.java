package com.quynh.efep_hsf.services;

import com.quynh.efep_hsf.models.entity_models.Flower;
import com.quynh.efep_hsf.models.request_models.GetFlowerDetailRequest;
import com.quynh.efep_hsf.models.response_models.*;
import com.quynh.efep_hsf.pojo.Teammate;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

public interface SystemService {
    GetSlideBarImageResponse getSlideBarImage(RedirectAttributes attributes);
    GetTopSoldFlowerResponse getTopSoldFlower(RedirectAttributes attributes);
    GetCustomerAmountResponse getCustomerAmount(RedirectAttributes attributes);
    GetFlowerAmountResponse getFlowerAmount(RedirectAttributes attributes);
    GetWorkingYearAmountResponse getWorkingYearAmount(RedirectAttributes attributes);
    GetNewArrivalFlowerResponse getNewArrivalFlower(RedirectAttributes attributes);
    GetTeammateResponse getTeammate(RedirectAttributes attributes);
    GetFlowerDetailResponse getFlowerDetail(GetFlowerDetailRequest request, RedirectAttributes attributes);
//    GetCustomerProfileResponse getCustomerProfile(RedirectAttributes attributes);
    GetCustomerOrderHistoryResponse getCustomerOrderHistory(RedirectAttributes attributes);
    GetCustomerListForShopResponse getCustomerListForShop(RedirectAttributes attributes);
    GetFlowerListForShopResponse getFlowerListForShop(RedirectAttributes attributes);
}
