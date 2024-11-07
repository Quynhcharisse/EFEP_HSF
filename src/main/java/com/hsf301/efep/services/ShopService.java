package com.quynh.efep_hsf.services;

import com.quynh.efep_hsf.models.request_models.*;
import jakarta.servlet.http.HttpSession;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

public interface ShopService {
    String createFlower(CreateFlowerRequest request, RedirectAttributes attributes, HttpSession session);
    String updateFlower(UpdateFlowerRequest request, RedirectAttributes attributes, HttpSession session);
    String disableFlower(DisableFlowerRequest request, RedirectAttributes attributes, HttpSession session);
}
