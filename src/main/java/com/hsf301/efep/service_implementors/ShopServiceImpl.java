package com.quynh.efep_hsf.service_implementors;

import com.quynh.efep_hsf.models.request_models.*;
import com.quynh.efep_hsf.models.response_models.*;
import com.quynh.efep_hsf.services.ShopService;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

public class ShopServiceImpl implements ShopService {
    @Override
    public CreateFlowerResponse createFlower(CreateFlowerRequest request, RedirectAttributes attributes) {
        return null;
    }

    @Override
    public UpdateFlowerResponse updateFlower(UpdateFlowerRequest request, RedirectAttributes attributes) {
        return null;
    }

    @Override
    public DeleteFlowerResponse deleteFlower(DeleteFlowerRequest request, RedirectAttributes attributes) {
        return null;
    }

    @Override
    public BanCustomerResponse banCustomer(BanCustomerRequest request, RedirectAttributes attributes) {
        return null;
    }

    @Override
    public UnbanCustomerResponse unbanCustomer(UnbanCustomerRequest request, RedirectAttributes attributes) {
        return null;
    }
}
