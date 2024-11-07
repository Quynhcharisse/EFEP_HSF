package com.quynh.efep_hsf.services;

import com.quynh.efep_hsf.models.entity_models.Flower;
import com.quynh.efep_hsf.models.request_models.GetFlowerDetailRequest;
import com.quynh.efep_hsf.models.response_models.*;
import com.quynh.efep_hsf.pojo.Teammate;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

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
