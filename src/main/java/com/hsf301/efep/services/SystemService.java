package com.hsf301.efep.services;


import com.hsf301.efep.models.entity_models.Flower;
import com.hsf301.efep.models.request_models.GetFlowerDetailRequest;
import com.hsf301.efep.models.response_models.*;
import com.hsf301.efep.pojo.Teammate;

import com.hsf301.efep.models.request_models.GetFlowerDetailRequest;

import org.springframework.web.servlet.mvc.support.RedirectAttributes;

public interface SystemService {
    String getSlideBarImage(RedirectAttributes attributes);
    String getTopSoldFlower(RedirectAttributes attributes);
    String getCustomerAmount(RedirectAttributes attributes);
    String getFlowerAmount(RedirectAttributes attributes);
    String getWorkingYearAmount(RedirectAttributes attributes);
    String getNewArrivalFlower(RedirectAttributes attributes);
    String getTeammate(RedirectAttributes attributes);
    String getFlowerDetail(GetFlowerDetailRequest request, RedirectAttributes attributes);
    String getCustomerProfile(RedirectAttributes attributes);
    String getCustomerOrderHistory(RedirectAttributes attributes);
    String getCustomerListForShop(RedirectAttributes attributes);
    String getFlowerListForShop(RedirectAttributes attributes);
}
