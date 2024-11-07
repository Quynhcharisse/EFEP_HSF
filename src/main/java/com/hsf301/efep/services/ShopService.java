package com.quynh.efep_hsf.services;

import com.quynh.efep_hsf.models.request_models.*;
import com.quynh.efep_hsf.models.response_models.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

public interface ShopService {
    CreateFlowerResponse createFlower(CreateFlowerRequest request, RedirectAttributes attributes);
    UpdateFlowerResponse updateFlower(UpdateFlowerRequest request, RedirectAttributes attributes);
    DeleteFlowerResponse deleteFlower(DeleteFlowerRequest request, RedirectAttributes attributes);
    BanCustomerResponse banCustomer(BanCustomerRequest request, RedirectAttributes attributes);
    UnbanCustomerResponse unbanCustomer(UnbanCustomerRequest request, RedirectAttributes attributes);
}
